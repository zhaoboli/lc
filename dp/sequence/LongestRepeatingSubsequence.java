public class Solution {
    /**
     * @param str a string
     * @return the lenght of the longest repeating subsequence
     */
    public int longestRepeatingSubsequence(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= len; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (str.charAt(i-1) == str.charAt(j-1) && i != j) {
                    dp[i][j] = dp[i-1][j-1] + 1; 
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len][len];
    }
}
