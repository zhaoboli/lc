package com.zhaobo;

/**
 * Created by Nate_Li on 5/2/2017.
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

 For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int j = 0;
        int[] map = new int[256];
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                int index = s.charAt(j);
                if (map[index] == 1) {
                    break;
                } else {
                    map[index] = 1;
                    j++;
                }
            }
            max = Math.max(max, j - i);
            int toRemoveIndex = s.charAt(i);
            map[toRemoveIndex] = 0;
        }
        return max;
    }
}
