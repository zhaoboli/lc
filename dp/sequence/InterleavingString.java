public class Solution {
    /*
     * @param: A string
     * @param: A string
     * @param: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j]: s1的前i个和s2的前j个，能不能组成s3的前i+j个
        //dp[i][j] = dp[i-1][j] || dp[i][j-1]
        //初始 if i = 0; dp[i][j] = s2[j] == s3[j]
        // if j = 0; dp[i][j] = s1[i] == s3[i]
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) {
            return false;
        }
          boolean[][] dp = new boolean[n+1][m+1];
          dp[0][0] = true;

          for (int j = 1; j <= m; j++) {
              dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1];
          }
          for (int i = 1; i <= n; i++) {
              dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0];
          }

          for (int i = 1; i <= n; i++) {
              for (int j = 1; j <= m; j++) {
                  dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
              }
          }
          return dp[n][m];
    }
}
