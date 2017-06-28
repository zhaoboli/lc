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
        //结尾是A的第i个和B的第j个的字符串, 并且A i和B j想等， 的最大子字符串 
        int[][] dp = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = 1;
                    if (i-1 >= 0 && j-1>= 0 && A.charAt(i-1) == B.charAt(j-1)) {
                       dp[i][j] += dp[i-1][j-1]; 
                    }
                } 
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
