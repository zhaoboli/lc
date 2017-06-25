public class Solution {
    /**
     * @param matrix a matrix of 0 and 1
     * @return an integer
     */
    public int maxsquare2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0 || (i -1 < 0 || j -1 < 0) || dp[i-1][j-1] == 0) {
                    dp[i][j] = matrix[i][j];
                    max = Math.max(dp[i][j], max);
                    continue;
                }
                int extend = dp[i-1][j-1];
                dp[i][j] = maxextend(matrix, i, j, extend) + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }

    private int maxextend(int[][] matrix, int i, int j, int extend) {
        int maxextend = 0;
        for (; maxextend < extend; maxextend++) {
            if (matrix[i][j-1-maxextend] > 0 || matrix[i-1-maxextend][j] > 0) {
                break;
            }
        }
        return maxextend;
    }

    public int maxSquare2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;

        int[][] dp = new int[n][m];
        int[][] left = new int[n][m];
        int[][] up = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 < 0 ) {
                    dp[i][j] = matrix[i][j];
                    up[i][j] = matrix[i][j] == 1 ? 0 : 1;
                } else if ( j - 1 < 0) {
                    dp[i][j] = matrix[i][j];
                    left[i][j] = matrix[i][j] == 1 ? 0: 1;
                } else {
                    if (matrix[i][j] == 0) {
                        left[i][j] = 1 + left[i][j-1];
                        up[i][j] = 1 + up[i-1][j];
                        dp[i][j] = 0;
                    } else {
                        left[i][j] = 0;
                        up[i][j] = 0;
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(left[i][j-1], up[i-1][j]));
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
