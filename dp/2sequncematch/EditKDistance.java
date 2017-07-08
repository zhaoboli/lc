public class Solution {
    private class TrieNode {
        String word;
        HashMap<Character, TrieNode> children;
        boolean hasWord;
        public TrieNode () {
            this.children = new HashMap<Character, TrieNode>();
        }
    }

    private class TrieTree {
        TrieNode root;

        public TrieTree() {
            this.root = new TrieNode();
        }
        
        public void insert(String word) {
            if (word == null) {
                return;
            }
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children.get(word.charAt(i)) == null ) {
                    TrieNode node = new TrieNode();
                    curr.children.put(word.charAt(i), node);
                }
                curr = curr.children.get(word.charAt(i));             
            }
            curr.word = word;
            curr.hasWord = true;
        }
                
    }
    /**
     * @param words a set of strings
     * @param target a target string
     * @param k an integer
     * @return output all the strings that meet the requirements
     */
    public List<String> kDistance(String[] words, String target, int k) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return result;
        }
        TrieTree trie = new TrieTree();
        int n = target.length();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);     
        }
        int[] dp = new int[n+1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        search(target, trie.root, k, result, dp);
        return result;
    }
    // target的长度是n，words中最长的长度是m
    // 每个结点内都花费了O(n)的时间，结点最多26 ^ m , 所以时间复杂度是O(n * 26 ^ m) 
    //dp[j],from trie root to current node, the prefix word, the minimum edit distance to first j characters of target
    //dp[i]是当前结点对应的单词到target第i位第最小花费
    //find与dp一个含义，接下来的查找如果还用dp，那么会对上一层有影响，所以需要另一个数组
    private void search (String target, TrieNode node, int k, List<String> result, int[] dp ) {
        int n = target.length(); 
        if (node.hasWord && dp[n] <= k) {
            result.add(node.word);
        }
        int[] next = new int[n+1];
        
        for(Map.Entry<Character, TrieNode> entry: node.children.entrySet()) {
            next[0] = dp[0] + 1;    
            for(int j = 1; j <= n; j++) {
                if (entry.getKey() == target.charAt(j-1)) {
                    next[j] = Math.min(dp[j-1], Math.min(next[j-1] +1, dp[j] + 1));
                } else {
                    next[j] = Math.min(dp[j-1] + 1, Math.min(next[j-1] + 1, dp[j] + 1));
                }
            }
            search(target, (TrieNode)entry.getValue(), k, result, next);
        } 
    }


    /**
     * @param words a set of stirngs
     * @param target a target string
     * @param k an integer
     * @return output all the strings that meet the requirements:this will timeout
     */
    public List<String> kDistance(String[] words, String target, int k) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            if (minDistance(words[i], target) <= k) {
                result.add(words[i]);
            }
        }
        return result;
    }

    private int minDistance(String source, String target) {
        int n = source.length();
        int m = target.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                if (source.charAt(i-1) == target.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));
                }
            }
        }
        return dp[n][m];
    }
}
