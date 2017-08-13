/**
 * Prob: top-k-frequent-words No: 471
 * Given a list of words and an integer k, return the top k frequent words in the list.
 * You should order the words by the frequency of them in the return list, the most frequent one comes first. 
 * If two words has the same frequency, the one with lower alphabetical order come first.
 *
 * [
 *     "yes", "lint", "code",
 *         "yes", "code", "baby",
 *             "you", "baby", "chrome",
 *                 "safari", "lint", "code",
 *                     "body", "lint", "code"
 *                     ]
 *                     for k = 3, return ["code", "lint", "baby"].
 *
 *                     for k = 4, return ["code", "lint", "baby", "yes"],
 *　思路：
 * 无脑想到用堆, 有几个犯错的点: String1.compareTo(String2), if String1 precedes String2, return -1; 这里要求其实precedes被认为是大的，注意重写comparator
 * (语法错误)Map.Entry<k, v> , map.EntrySet(); word.txt = string, not word, 这里private class命名为word其实是不对的，以至于这里犯错了,以后有机会再改吧 
 */

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        if (words == null || words.length == 0) {
            return null;
        }
        String[] ans = new String[k];
        if (k == 0) {
            return ans;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        Queue<Word> queue = new PriorityQueue<Word>(k, new Comparator<Word>() {
            @Override
            public int compare (Word w1, Word w2) {
                int diff = w1.occurCt - w2.occurCt;
                if (diff == 0) {
                    diff = w2.txt.compareTo(w1.txt);
                }
                return diff;
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(new Word((String)entry.getKey(), (int)entry.getValue()));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            ans[--k] = queue.poll().txt;
        }
        return ans;
    }
    //not a good idea to use name Word here
    private class Word {
        public String txt;
        public int occurCt;
        public Word (String txt, int occurCt) {
            this.txt = txt;
            this.occurCt = occurCt;
        }
    }
}
