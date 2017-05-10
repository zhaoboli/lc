public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
		if(board == null || board.length == 0) {
			return false;
		}
		boolean found = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
			    found = find(board, word, i, j, 0);
			    if (found) {
			        return true;
			    }
			}
		}
		return found;
    }
	
	private boolean find(char[][] board, String word, int x, int y, int start) {
		if (start == word.length()) {
			return true;
		}
		if ( x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(start)) {
		    return false;
		}
		char temp = board[x][y];
		board[x][y] = '*';
		boolean found = find(board, word, x - 1, y, start + 1) || 
							find(board, word, x, y - 1, start + 1) ||
								find(board, word, x + 1, y, start + 1) ||
								    find(board, word, x, y + 1, start + 1);
		board[x][y] = temp;
		return found;
	}
}