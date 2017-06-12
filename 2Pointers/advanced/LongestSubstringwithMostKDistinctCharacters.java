package com.zhaobo;

import java.util.HashSet;

/**
 * Created by Nate_Li on 5/2/2017.
 */
public class LongestSubstringwithMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }

        int j = 0;
        int max = 0;
        int[] map = new int[256];
        int distinctCt = 0;

        for (int i = 0; i < s.length(); i++) {
            while( j < s.length()) {
                int ch = s.charAt(j);
                if (map[ch] == 0) {
                    if (distinctCt + 1 > k) {
                        break;
                    }
                    map[ch] = 1;
                    distinctCt++;
                    j++;
                } else {
                    map[ch] += 1;
                    j++;
                }
            }
            max = Math.max(max, j - i);
            map[s.charAt(i)] -= 1;
            if (map[s.charAt(i)] == 0) {
                distinctCt--;
            }
        }
        return max;
    }

    //Tricky, be careful of edge cases
    public int lengthOfLongestSubstringKDistinctImprvd(String s, int k) {
    if (s == null || s.length() == 0) {
        return 0;
    }
    
    int[] map = new int[256];
    int j = 0;
    int distinctCt = 0;
    int maxLen = 0;

    for (int i = 0; i < s.length(); i++) {
        while (j < s.length()) {
            map[s.charAt(j)] += 1;
            if (map[s.charAt(j)] == 1) {
                distinctCt++;
            }
            j++;
            if (distinctCt > k) {
                break;
            }
            maxLen = Math.max(j- i, maxLen);
        }
        map[s.charAt(i)] -= 1;
        if (map[s.charAt(i)] == 0) {
            distinctCt--;
        }
    }

    return maxLen;
}
}
