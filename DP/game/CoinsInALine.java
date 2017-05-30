public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean equal to true if first player win
     */
    public boolean firstWillWin(int n) {
        if (n == 0) {
            return false;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i <=n; i++) {
            if (dp[i-1] && dp[i-2]) {
               dp[i] = false;
            }
            if (!dp[i-1] || !dp[i-2]) {
                dp[i] = true;
            }
        }
        return dp[n];
    }
}
