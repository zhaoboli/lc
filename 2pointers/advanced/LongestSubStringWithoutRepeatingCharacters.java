public class Solution {
    /**Jun-10
     * @param s: a string
     * @return: integer
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        //Character
        HashSet<Character> hash = new HashSet<Character>();
        int j = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (hash.contains(s.charAt(j))) {
                    break;
                } else {
                    hash.add(s.charAt(j));
                    j++;
                }
            }
            len = Math.max(len, hash.size());
            hash.remove(s.charAt(i));
        }
        return len;
    }

    /** May-12
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
