/** 
 * Prob: build-post-office No: 574
 * Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one), 
 * find the place to build a post office, the distance that post office to all the house sum is smallest. 
 * Return the smallest distance. Return -1 if it is not possible.
 *
 * Notice
 * You can pass through house and empty.
 * You only build post office on an empty.
 * Example
 * Given a grid:
 * 
 * 0 1 0 0
 * 1 0 1 1
 * 0 1 0 0
 * return 6. 
 * (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)
 */
public class Solution {
    //93% test cases passed. memory limit exceeded
    /*
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                shortest = Math.min(shortest, bfsDistance(grid, i, j)); 
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    private int bfsDistance(int[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;   
        boolean[][] flag = new boolean[n][m];
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};

        int sum = 0;
        int radius = 0;
        int currIndex = 0;
        flag[x][y] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            radius++;
            for (int index = 0; index < size; index++) {
                Point head = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newx = head.x + row[i];
                    int newy = head.y + col[i];
                    if (newx >= 0 && newy >=0 && newx < n && newy < m && !flag[newx][newy]) {
                        flag[newx][newy] = true;
                        queue.offer(new Point(newx, newy));        
                        if (grid[newx][newy] == 1) {
                            sum += radius;
                        }
                    }
                }
            }
        }
        return sum;
    }

    private class Point {
        public int x;
        public int y;
        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

public class Solution {

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[] rowsum = new int[row];
        int[] columnsum = new int[column];
        int[] rowPoint = new int[row];
        int[] columnPoint = new int[column];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    //rowPoint[i] = rowPoint[i]++;错点，要不rowPoint[i]+1
                    rowPoint[i]++;
                    columnPoint[j]++;
                }
            }
        }
        getDistanceSum(rowPoint, row, rowsum);
        getDistanceSum(columnPoint, column, columnsum);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0 && min > rowsum[i] + columnsum[j]) {
                    min = rowsum[i] + columnsum[j];
                }
            }
        }
        return min;
    }

    private void getDistanceSum(int[] arr, int n, int[] ans) {
        int[] prefixSum1 = new int[n];
        int[] prefixSum2 = new int[n];
        //到第ｉ位总共有多少个点,包括i位
        prefixSum1[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum1[i] = prefixSum1[i-1] + arr[i];
        }
        prefixSum2[0] = 0;
        //从最左开始，到第i位的所有点的距离和，不包括第i位
        for (int i = 1; i < n; i++) {
            prefixSum2[i] = prefixSum2[i-1] + prefixSum1[i-1];
        }
        //从最右开始往左，到第i位总共有几个点,包括i位
        prefixSum1[n-1] = arr[n-1]; 
        for (int i = n-2; i >= 0; i--) {
            prefixSum1[i] = prefixSum1[i+1] + arr[i];
        }
        //从最右开始往左,到第i为的所有点的距离和,不包括第i位
        ans[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            ans[i] = ans[i+1] + prefixSum1[i+1];
        }
        //左右(上下)相加
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i] + prefixSum2[i];
        }
    }
}
