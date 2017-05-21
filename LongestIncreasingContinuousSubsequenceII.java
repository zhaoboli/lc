public class Solution {
    /**
     * @param A an integer matrix
     * @return an integer
     */
     public int longestIncreasingContinuousSubsequenceII(int[][] A) {
         // Write your code here
         if (A == null || A.length == 0) {
             return 0;
         }

         int max = 0;
         int len = A.length;
         int width = A[0].length;

         int[][] memo = new int[len][width];
         boolean[][] flag = new boolean[len][width];

         for(int i = 0; i < A.length; i++) {
             for(int j = 0; j < A[0].length; j++) {
                 max = Math.max(max, search(A, memo, flag, i, j));
             }
         }
         return max;
     }

     private int search(int[][] A, int[][] memo, boolean[][] flag, int i, int j) {
         if(flag[i][j]) {
             return memo[i][j];
         }

         int[] dX = {-1, 1, 0, 0};
         int[] dY = {0, 0, -1, 1};
         int longest = 1;

         for (int index = 0; index < 4; index++) {
             int m = i + dX[index];
             int n = j + dY[index];
             if (isInBound(A, m, n) && A[m][n] < A[i][j]) {
                 longest = Math.max(longest, search(A, memo, flag, m, n) + 1);
             }
         }

         memo[i][j] = longest;
         flag[i][j] = true;
         return memo[i][j];
     }

     public boolean isInBound(int[][] A, int i, int j) {
         return i >= 0 && j >= 0 && i < A.length && j < A[0].length;
     }
}
