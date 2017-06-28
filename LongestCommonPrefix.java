public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
     public String longestCommonPrefix(String[] strs) {
         if (strs == null) {
             return null;
         }
         if (strs.length == 0) {
             return "";
         }
         int n = strs.length;
         int longest = 0;
         int m = strs[0].length();
         while (longest < m) {
             char c = strs[0].charAt(longest);
             boolean contd = true;
             for (int i = 1; i < n; i++) {
                 if (longest + 1 > strs[i].length() || strs[i].charAt(longest) != c) {
                     contd = false;
                     break;
                 }
             }
             if (!contd) {
                 break;
             }
             longest++;
         }
         return strs[0].substring(0, longest);
     }
}
