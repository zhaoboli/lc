public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substirng
     */
    public String longestPalindromic(Sting s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 0;
        int sIndex = 0;
        int eIndex = 0;
        // dp[0][0] = s[0] == s[0]; dp[0][1] = s[0] == s[1], dp[1][1] = s[1] == s[1]
        // dp[0][2] = s[0] == s[2] && dp[1][1], dp[1][2] = s[1] == s[2], dp[2][2] == s[2] == s[2]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 2) {
                    if (s.charAt(j) == s.charAt(i)) {
                        dp[j][i] = i - j + 1;
                    }
                } else {
                    if (s.charAt(j) == s.charAt(i) && dp[j+1][i-1] > 0) {
                        dp[j][i] = i - j +1;
                    }
                }
                if (dp[j][i] > max) {
                    max = dp[j][i];
                    sIndex = j;
                    eIndex = i;
                }
            }
        }
        return s.substring(sIndex, eIndex + 1);
    }
}
