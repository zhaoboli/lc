public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: the minimum number of steps
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int n = word1.length();
        int m = word2.length();
        /** 
         * dp minimum steps required to convert 
         * first i number of word1 to first j number of word 2
         * 最少步数去把 1的前i个转化成2的前j个
         *  1. if last character of word1 and word2 is same
         *  if word1 and word2 are same length dp[i-1][j-1];
         *  if word1 is longer: throw character i away dp[i-1][j] + 1: d
         *  if word1 is shorter: insert character j into word 1 dp[i][j-1] + 1 :i
         *  2. if last character of word1 and word2 is not same
         *  if word1 and word2 are same length dp[i-1][j-1] + 1: r
         *  if word1 is shorter: dp[i][j-1] + 1: i
         *  if word1 is longer: dp[i-1][j] + 1 : d
        */
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    //j number of insert
                    dp[i][j] = j;
                } else if (j == 0) {
                    //i number of delete
                    dp[i][j] = i;
                } else {
                    //注意i-1和j-1
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));
                    }
                }
            }
        }
        return dp[n][m];
    }
}
