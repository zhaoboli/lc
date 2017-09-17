/**
 * Prob: number-of-islands No: 433
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island.
 * If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * Find the number of islands
 * [
 *    [1, 1, 0, 0, 0],
 *    [0, 1, 0, 0, 1],
 *    [0, 0, 0, 1, 1],
 *    [0, 0, 0, 0, 0],
 *    [0, 0, 0, 0, 1]
 * ]
 */
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
 * 思路：bfs很容易想到,uf的时候用到uf.connect的特性，如果a,b connect,那么再尝试b,a, 这时候uf不会再操作一次
 * 犯错点:
 */
public class Solution {
    //BFS
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] arrX = {1, 0, -1, 0};
        int[] arrY = {0, 1, 0, -1};
        int ct = 0;
        Queue<Point> queue = new LinkedList<Point>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j]) {
                    continue;
                }
                ct++;
                grid[i][j] = false;
                queue.offer(new Point(i, j));
                while (!queue.isEmpty()) {
                    Point head = queue.poll();
                    for (int m = 0; m < 4; m++) {
                        int x = head.x + arrX[m];
                        int y = head.y + arrY[m];
                        if (!isInBound(x, y, grid)) {
                            continue;
                        }
                        if (grid[x][y]) {
                            grid[x][y] = false;
                            queue.offer(new Point(x, y));
                        }
                    }
                }
            }
        }
        return ct;
    }

    private boolean isInBound(int x, int y, int[][] grid) {
        return !(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length);
    }

    private class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

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

        public void connect(int i1, int i2) {
            if (find(i1) != find(i2)) {
                //犯错点,这时候是father[find(i2)],因为可能还有其他点和i2是一个father, 如果只是father[i2]就把这些点漏掉了
                father[find(i2)] = find(i1);
                count--;
            }
        }
        
        public int find(int index) {
            if (father[index] != index) {
                return father[index] = find(father[index]);
            }
            return index;
        }

        public int query() {
            return count;
        }

        public void setCount(int ct) {
            this.count = ct;
        }
    }
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length; 
        int m = grid[0].length;    
        UnionFind uf = new UnionFind(n * m);
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                   count++;
                } 
            }
        }
        uf.setCount(count);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i-1][j]) {
                        uf.connect(i * m + j, (i-1) * m +j);
                    }
                    if (i < (n - 1) && grid[i+1][j]) {
                        uf.connect(i * m + j, (i+1) * m + j);
                    }
                    if (j > 0 && grid[i][j-1]) {
                        uf.connect(i * m + j, i * m + j - 1);
                    }
                    if (j < (m -1) && grid[i][j+1]) {
                        uf.connect(i * m + j, i * m + j + 1);
                    }
                }
            }
        }
        return uf.query();
    }
}
