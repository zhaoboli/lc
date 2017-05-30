public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }

        int len = triangle.length;

        if (len == 1) {
            return triangle[0][0];
        }

        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        int minTotal = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            int row = triangle[i].length;
            for (int j = 0; j < row; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i-1][0] + triangle[i][j];
                } else if (j == row-1) {
                    dp[i][j] = dp[i-1][row-2] + triangle[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                if (i == len -1) {
                    minTotal = Math.min(minTotal, dp[i][j]);
                }
            }
        }

        return minTotal;
    }
}
