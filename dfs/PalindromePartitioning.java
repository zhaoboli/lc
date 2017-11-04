/**
 * Prob: palindrome-partitioning No: 136
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * Given s = "aab", return:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * 思路：
 *　典型深搜，按原序切开，递归定义：以startIndex开始的子符串中找到回文串，并加入结果集中
 */
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> path = new ArrayList<String>();
        helper(0, s, path, result);
        return result;
    }

    private void helper(int startIndex, String s, List<String> path, List<List<String>> result) {
        if (startIndex == s.length()) {
        	//note here use new ArrayList
            result.add(new ArrayList<String>(path));
            return;
        }
        //note == s.length(), not <, as substring is used 
        for (int i = startIndex + 1; i <= s.length(); i++) {
            if (!isValidPalindrome(s.substring(startIndex, i))) {
                continue;
            }
            path.add(s.substring(startIndex, i));
            helper(i, s, path, result);
            path.remove(path.size() - 1);
        }
    }


    private boolean isValidPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
} 
