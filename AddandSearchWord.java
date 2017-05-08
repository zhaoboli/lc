public class WordDictionary {
    // Your WordDictionary object will be instantiated and called as such:
    // WordDictionary wordDictionary = new WordDictionary();
    // wordDictionary.addWord("word");
    // wordDictionary.search("pattern");
    private class TrieNode {
        public TrieNode[] children;
        public boolean hasWord;
       
        public TrieNode() {
            children = new TrieNode[26];
        } 
    }
    private TrieNode root;
   
    public WordDictionary() {
        this.root = new TrieNode();
    } 

    // adds a word into the data structure
    public void addWord(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.hasWord = true;
    }
    
    private boolean find(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.hasWord;
        }

        char c = word.charAt(index); 
        if (c == '.') {
            for ( int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (find(word, index + 1, node.children[i])) {
                        return true;
                    }
                } 
            }
            return false;
        } else {
            TrieNode child = node.children[c - 'a'];
            if (child != null) {
                return find(word, index + 1, child);
            }
            return false;
        }
    }

    //Returns if the word is in the structure, A word could 
    //contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return this.find(word, 0, root);
    }

}
