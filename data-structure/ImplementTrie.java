/**
Implement a trie with insert, search, and startsWith methods.
You may assume that all inputs are consist of lowercase letters a-z.

Example
insert("lintcode")
search("code")
>>> false
startsWith("lint")
>>> true
startsWith("linterror")
>>> false
insert("linterror")
search("lintcode)
>>> true
startsWith("linterror")
>>> true
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
	char nodeChar;
    boolean hasWord;
	TrieNode[] childNodes;

    public TrieNode(char nodeChar) {
		this.nodeChar = nodeChar;
        childNodes = new TrieNode[26];
    }

	public TrieNode() {
        childNodes = new TrieNode[26];
    }

	public void insertNode(TrieNode root, String word) {
		if (word == null || word.length() == 0) {
            root.hasWord = true;
			return;
		}
		char c = word.charAt(0);
		if (root.childNodes[c - 'a'] == null) {
			TrieNode node = new TrieNode(c);
			root.childNodes[c - 'a'] = node;
		}
		insertNode(root.childNodes[c - 'a'], word.substring(1));
	}

	public TrieNode searchNode(TrieNode root, String word) {
        if (word == null || word.length() == 0) {
            return root;
        }
	    char c = word.charAt(0);
        if (root.childNodes[c - 'a'] != null) {
            return root.searchNode(root.childNodes[c - 'a'], word.substring(1));
        } else {
            return null;
        }
	}
}

public class Trie {
    private TrieNode root;

    public Trie() {
		root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
	    if (word == null || word.length() == 0) {
			return;
		}
		root.insertNode(root, word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() ==0) {
            return false;
        }
        TrieNode res = root.searchNode(root, word);
        if (res != null && res.hasWord) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() ==0) {
            return false;
        }
        TrieNode res = root.searchNode(root, prefix);
        return res != null;
    }
}

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
