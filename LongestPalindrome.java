/**
 * Prob: longest-palindrome No: 628
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Notice: Assume the length of given string will not exceed 1010.
 * example: Given s = "abccccdd" return 7
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 */
 public class Solution {
    /*
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        int remove = set.size();
        if (remove > 0) {
            remove -= 1;
        }
        return s.length() - remove;
    }
}
