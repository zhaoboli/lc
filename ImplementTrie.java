/**
 * Trie object will be instantiated and called:
 * Trie trie = new Trie();
 * trie.insert("foobar")
 * trie.search("foo")
 * trie.startWith("foo")
 */

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean hasWord = false;
    String word = "";
    public TrieNode() {
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
       root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                TrieNode node = new TrieNode();
                curr.children[word.charAt(i) - 'a']  = node;
                curr = curr.children[word.charAt(i) - 'a'];
            } else {
                curr = curr.children[word.charAt(i) - 'a'];
            }
        }
        curr.hasWord = true;
        curr.word = word;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] != null) {
                curr = curr.children[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return curr.hasWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.children[prefix.charAt(i) - 'a'] == null ) {
                return false;
            } else {
                curr = curr.children[prefix.charAt(i) - 'a'];
            }
        }
        return true;
    }
}
