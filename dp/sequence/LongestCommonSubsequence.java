public class Solution {
    /**
     * @param A, B: Two strings
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int na = A.length();
        int nb = B.length();

        int[][] dp = new int[na+1][nb+1];

        for (int i = 0; i <= na; i++) {
            for (int j = 0; j <= nb; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                } 
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[na][nb];
    }

    //recursion
    public int longestCommonSubsequence(String A, String B) { 
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int na = A.length();
        int nb = B.length();
        return lcs(A, na - 1, B, nb - 1);
    }

    private int lcs(String A, int indexA, String B, int indexB) {
        if (indexA < 0 || indexB < 0) {
            return 0;
        }
        if (A.charAt(indexA) == B.charAt(indexB)) {
            return lcs(A, indexA--, B, indexB--) + 1;
        } else {
            return Math.max(lcs(A, indexA--, B, indexB), lcs(A, indexA, B, indexB--));
        }
    }
}
