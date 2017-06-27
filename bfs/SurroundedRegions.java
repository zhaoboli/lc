public class Solution {
    /**
     * @param board a 2D board containning 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;
        Queue<Node> queue = new LinkedList<Node>();

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = 'D';
                queue.offer(new Node(i, 0));
            }
            if (board[i][m-1] == 'O') {
                board[i][m-1] = 'D';
                queue.offer(new Node(i, m-1));
            }
        }

        for (int j = 1; j < m - 1; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = 'D';
                queue.offer(new Node(0, j));
            }
            if (board[n-1][j] == 'O') {
                board[n-1][j] = 'D';
                queue.offer(new Node(n-1, j));
            }
        }
        
        int[] dX = {0, 0, 1, -1};
        int[] dY = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Node head = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = head.x + dX[i];
                int y = head.y + dY[i];
                if (isInBound(x, y, n, m) && board[x][y] == 'O') {
                    board[x][y] = 'D';
                    queue.offer(new Node(x, y));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }

    private boolean isInBound(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
    
    private class Node {
        public int x;
        public int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
