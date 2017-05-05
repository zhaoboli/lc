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
	int frequency;
	TreeNode[] childNodes;
	
    public TrieNode(Char nodeChar) {
		this.nodeChar = nodeChar;
        childNodes = new TreeNode[26];
    }
	
	public void insertNode(TreeNode root, String word) {
		if (word == null || word.length == 0) {
			return;
		}
		Char c = word.charAt(0);
		if (root.childNodes[c - 'a'] == nulL) {
			TreeNode node = new TreeNode(c);
			root.childNodes[c - 'a'] = node;
		}
		String nextWord = word.subString(1);
		insertNode(root.childNodes[c - 'a'], nextWord);
	}
	
	public boolean searchNode(TreeNode root, String word) {
		
	}
}

public class Trie {
    private TrieNode root;

    public Trie() {
		root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
		if (word == null || word.length == 0) {
			return;
		}
		root.insertNode(root, word); 
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
	        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        
    }
}