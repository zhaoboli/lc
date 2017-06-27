public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagrams(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }
        String temp = "";
        boolean[] map = new boolean[s.length()];
        helper(s, t, "", map, 0);
        return result;
    }
    //TODO need rework
    private boolean result;

    private boolean helper(String s, String t, String temp, boolean[] map, int startIndex) {
        if(startIndex == s.length()) {
            if (temp == t) {
                result = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[i]) {
                continue;
            }
            String ls = temp.add(s.charAt(i));
            map[i] = true;
            helper(s, t, temp, map, startIndex + 1);
            map[i] = false;
            temp.remove(temp.length()-1);
        }
    }

    public boolean anagrams(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            map[(int)s.charAt(i)] += 1;
        }

        for(int j = 0; j < t.length(); j++) {
            map[(int)t.charAt(j)] -= 1;
            if (map[(int)t.charAt(j)] < 0) {
                return false;
            }
        }
        return true;
    }
}
