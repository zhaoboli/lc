public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
    // dp[i][j] = Math.min(dp[i][k], dp[k+1][j]) + sum(i,j)
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;    
        int[][] dp = new int[n][n];
        boolean[][] flag = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            flag[i][i] = true;
        }
        return search(A, 0, n-1, dp, flag);
    }

    private int search(int[] A, int i, int j, int[][] dp, boolean[][] flag) {
        if(flag[i][j]) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        //error k < j-i
        for(int k = i; k < j; k++) {
            min = Math.min(min, search(A, i, k, dp, flag) + search(A, k+1, j, dp, flag) + sum(A, i, j)); 
        }
        dp[i][j] = min;
        flag[i][j] = true;
        return min;
    }

    private int sum(int[] A, int i, int j) {
        int sum = 0;
        for (int index = i; index <= j; index++) {
            sum += A[index]; 
        }
        return sum;
    }
}
