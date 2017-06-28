/**
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 *
 */

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */

    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String st = String.valueOf(charArr);
            if (!map.containsKey(st)) {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                map.put(st, temp);
            } else {
                map.get(st).add(strs[i]);
            }
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.addAll(entry.getValue());
            }
        }
        return res;
    }
}
