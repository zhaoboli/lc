public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		
		int n = grid.length;
		int m = grid[0].length;
		
		int[][] dp = new int[n][m];
		dp[0][0] = grid[0][0];
		
		for (int i = 1; i < m; i++ ) {
			dp[0][i] = grid[0][i] + dp[0][i-1];
		}
		for (int j = 1; j < n; j++) {
			dp[j][0] = grid[j][0] + dp[j-1][0];
		}
		
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		return dp[n-1][m-1];
    }
}
