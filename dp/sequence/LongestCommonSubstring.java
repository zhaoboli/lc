public class Solution {
    /**
     * @param A, B: Two string
     * @return: the legnth of the longest common substring.
     */
    public int longestCommonSubstring (String A, String B) {
        if (A == null || B == null) {
            return 0;
        }

        int n = A.length();
        int m = B.length();
        //此题可以不用动规，先把A的所有子字符串找出，然后看是否在B里，最大的就好 n^3
        //A的前i个和B的前j个的字符串, 并且从i,j开始相等并往前倒查最多连续相等的子字符串 
        int[][] dp = new int[n+1][m+1];

        int max = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } 
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
