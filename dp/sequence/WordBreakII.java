public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        int max = maxLen(wordDict);
        int currIndex = s.length();
        String temp = "";
        boolean[] nf = new boolean[s.length() + 1];
        boolean found = search(s, temp, wordDict, result, currIndex, max, nf);
        return result;
    }

    private boolean search(String target, String temp, Set<String> wordDict, List<String> result, int currIndex, int max, boolean[] nf) {
        if (nf[currIndex]) {
            return false;
        }
        if (currIndex == 0) {
            result.add(temp.substring(1, temp.length()));
            return true;
        }
        boolean levelFound = false;
        for (int i = currIndex -1; i >= 0 && currIndex - i <= max; i--) {
            if (wordDict.contains(target.substring(i, currIndex))) {
                StringBuilder sb = new StringBuilder(temp);
                sb.insert(0, target.substring(i, currIndex));
                sb.insert(0," ");
                if (search(target, sb.toString(), wordDict, result, i, max, nf)) {
                    levelFound = true;
                }
            }
        }
        if (!levelFound) {
            nf[currIndex] = true;
        }
        return levelFound;
    }

    private int maxLen(Set<String> dict) {
        int max = Integer.MIN_VALUE;
        for(String s: dict) {
            max = Math.max(max, s.length());
        }
        return max;
    }
}
