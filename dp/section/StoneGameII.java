public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] newA = new int[n+1];
        for(int i = 0; i < n; i++) {
            newA[i] = A[i];
        }
        newA[n] = A[0];
        int[][] dp = new int[n+1][n+1];
        boolean[][] flag = new boolean[n+1][n+1];
        return Math.min(searchMinimum(newA, 0, n - 1, dp, flag), searchMinimum(newA, 1, n, dp, flag));
    }

    private int searchMinimum(int[] A, int i, int j, int[][] dp, boolean[][] flag) {
        if (flag[i][j]) {
            return dp[i][j];
        } 
        if (i == j) {
            //as dp[i][j] = 0 exists, so use flag[i][j]
            dp[i][j] = 0;
            flag[i][j] = true;
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int index = i; index < j; index++) {
            min = Math.min(min, searchMinimum(A, i, index, dp, flag) + sum(A, i, j) + searchMinimum(A, index +1, j, dp, flag));
        }
        dp[i][j] = min;
        flag[i][j] = true;
        return min;
    }

    private int sum(int[] A, int i, int j) {
        int sum = 0;
        for(int index = i; index <= j; index++) {
            sum += A[index];
        }
        return sum;
    }
}
