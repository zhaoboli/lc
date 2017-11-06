/**
 * Prob: palindrome-partitioning-ii No: 108
 * Given a string s, cut s into some substrings such that every substring is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * Given s = "aab",
 * Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.
 * 思路：
 * 最大，最小，大致一想貌似得搜一遍,联想到dp
 * 可以算出任意两个下标之间是不是回文串
 * dp方程：见下面代码
 */
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if (s == null) {
            return -1;
        }
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        //preparation
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        
        for (int i = 0; i < n -1; i++) {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }     
        //此处len并非长度，可以理解成区间上下标的差值，比如len=2,包括下标为0,1,2,或者2,3,4
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                isPalindrome[i][i+len] = isPalindrome[i+1][i+len-1] && s.charAt(i) == s.charAt(i+len);
            }
        }

        int[] dp = new int[n+1];
        //前ｉ个可以最少被切割成个几个回文串
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i-1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        //此处要求最少切几刀，切３个回文串，只需两刀，所以要减1
        return dp[n] - 1;
    }
};
