public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        TrieTree tree = new TrieTree(new TrieNode());
		HashSet<String> found = new HashSet<String>();
		
		for (String word:words) {
			tree.insertWord(word);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				search(board, tree.root, i, j, found);		
			}
		}
		return new ArrayList<String>(found);
    }
    
    private void search(char[][] board, TrieNode root, int x, int y, HashSet<String> words) {
		TrieNode node = root.children[board[x][y] - 'a'];
		if (node == null) {
			return;
		}
		if (node.hasWord) {
			words.add(node.word);
		}
		
		int[] dX = {0, 0, -1, 1};
		int[] dY = {-1,1, 0, 0};
		
		char cache = board[x][y];
		board[x][y] = 0;
		
		for (int index = 0; index < 4; index++) {
		    int row = x + dX[index];
		    int col = y + dY[index];
		    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||board[row][col] == 0) {
		        continue;
		    }
			search(board, node, row, col, words);	
		}
		board[x][y] = cache;
	}
    
    private class TrieTree {
		public TrieNode root;
		public TrieTree(TrieNode root) {
			this.root = root;
		}
		
		private void insertWord(String word) {
			TrieNode curr = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (curr.children[c - 'a'] == null) {
					curr.children[c - 'a'] = new TrieNode();
				}
				curr = curr.children[c - 'a'];
			}
			curr.hasWord = true;
			curr.word = word;			
		}
		
		private boolean find(String word) {
			TrieNode curr = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(curr.children[c - 'a'] == null) {
					return false;
				}
			}
			return curr.hasWord;
		}
	}
	
	private class TrieNode {
		private TrieNode[] children;
		private boolean hasWord;
		private String word;
		
		public TrieNode() {
			this.children = new TrieNode[26];
			this.hasWord = false;
		}
	}
}
