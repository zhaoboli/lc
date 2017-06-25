public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if ( S == null || T == null || S.length() == 0 || T.length() == 0) {
           return 0;
        } 
        //dp:T的前i个在S的前j个的distinct subsequence
        int n = T.length();
        int m = S.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    //求方案总数,要j和不要j两种情况
                    if (T.charAt(i-1) == S.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
