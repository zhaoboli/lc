/**
 *Given a boolean 2D matrix, 0 is represented as the sea, 
 *1 is represented as the island. 
 *If two 1 is adjacent, we consider them in the same island. 
 *We only consider up/down/left/right adjacent.
 *Find the number of islands.
 [
   [1, 1, 0, 0, 0],
    [0, 1, 0, 0, 1],
    [0, 0, 0, 1, 1],
    [0, 0, 0, 0, 0],
    [0, 0, 0, 0, 1]
    ]
    return 3.
 *
 */

public class Solution {
    private class UnionFind {
        private int[] father;
        private int count;

        public UnionFind(int size) {
            father = new int[size];
            for (int i = 0; i < size; i++) {
                father[i] = i;
            }
        }

        public int find(int a) {
            if (father[a] == a) {
                return a;
            }
            return father[a] = find(father[a]);
        }

        public void connect(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                return;
            }
            father[pa] = pb;
            count--;
        }

        public void setCount(int ct) {
            count = ct;
        }

        public int query() {
            return count;
        }
    }

    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length; 
        UnionFind uf = new UnionFind(m * n);

        int ct = 0;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                if (grid[i][j]) {
                    ct++;
                }
            }
        }
        uf.setCount(ct);

        for (int p = 0; p < m; p++) {
            for(int q = 0; q < n; q++) {
                if (grid[p][q]) {
                    if (p > 0 && grid[p - 1][q]) {
                        uf.connect(p * n + q, (p - 1) * n + q);
                    }
                    if (p + 1 < m && grid[p + 1][q]) {
                        uf.connect(p * n + q, (p + 1) * n + q);
                    }
                    if (q > 0 && grid[p][q - 1]) {
                        uf.connect(p * n + q, p * n + q - 1);
                    }
                    if (q + 1 < n && grid[p][q + 1]) {
                        uf.connect(p * n + q, p * n + q + 1);
                    }
                }
            }
        }
        return uf.query();
    } 

    //BFS
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length; 
        int num = 0;
        Queue<Point> queue = new LinkedList<Point>();
        int[] dX = {0, 1, 0, -1};
        int[] dY = {1, 0, -1, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!grid[i][j]) {
                    continue;
                }
                num++;
                grid[i][j] = false;
                queue.offer(new Point(i, j));
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int index = 0; index < size; index++) {
                        Point head = queue.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int x = head.x + dX[dir];
                            int y = head.y + dY[dir];
                            Point p = new Point(x, y)
                            if (isInBound(grid, p) && grid[x][y]) {
                                queue.offer(p);
                                grid[x][y] = false;
                            }
                        }
                    }
                }
            }
        }
        return num;
    }

    private boolean isInBound(boolean[][] grid, Point p) {
        return p.x >= 0 && p.y >= 0 && p.x < grid.length && p.y < grid[0].length;
    }

    private class Point{
        public int x;
        public int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

