package com.zhaobo;

public class MinimumWindowSubstring {
    /**
     * 5/4/2017 6/10/2017
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if (source == null && target.length() > source.length()) {
            return "";
        }

        int[] targetHash = new int[256];
        int[] sourceHash = new int[256];
        for (int index = 0; index < target.length(); index++) {
            targetHash[target.charAt(index)] += 1;
        }
        int minWindow = Integer.MAX_VALUE;
        String minStr = "";
        int j = 0;

        for (int i = 0; i < source.length(); i++) {
            while (j < source.length() && !isValidSubStr(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)] += 1;
                j++;
            }
            if (isValidSubStr(sourceHash, targetHash)) {
                if (j -i < minWindow) {
                    minWindow = j - i;
                    minStr = source.substring(i, j);
                }
            }
            sourceHash[source.charAt(i)] -= 1;
        }
        return minStr;
    }
    //暴力判断
    private boolean isValidSubStr(int[] source, int[] target) {
        for (int i = 0; i < target.length; i++) {
            if (source[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}
