public class Solution {
    /**
     * @param grid a chessboard included 0 and 1
     * @return the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;
        // goes from up to down, left to right
        for (int j = 1; j < m; j++) {
           for (int i = 0; i < n; i++) {
              if (!grid[i][j]) {
                //Be careful of Overflow
                if (j - 1 >= 0 && i + 2 < n && dp[i+2][j-1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i+2][j-1] + 1, dp[i][j]);
                }
                if (j - 1 >= 0 && i - 2 >= 0 && dp[i-2][j-1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i-2][j-1] + 1, dp[i][j]);
                }
                if (j - 2 >= 0 && i - 1 >= 0 && dp[i-1][j-2] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i-1][j-2] + 1, dp[i][j]);
                }
                if (j - 2 >= 0 && i + 1 < n && dp[i+1][j-2] != Integer.MAX_VALUE ) {
                    dp[i][j] = Math.min(dp[i+1][j-2] + 1, dp[i][j]);
                }
              }
           }
        }


        if (dp[n-1][m-1] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[n-1][m-1];
    }
}
