/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 *
 * Knight can move in below pattern
 *
 * (x + 1, y + 2)
 * (x + 1, y - 2)
 * (x - 1, y + 2)
 * (x - 1, y - 2)
 * (x + 2, y + 1)
 * (x + 2, y - 1)
 * (x - 2, y + 1)
 * (x - 2, y - 1)
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid[0].length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[] dX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dY = {2, -2, 2, -2, 1, -1, 1, -2};
       
        int n = grid.length;
        int m = grid[0].length;
        //boolean[][] map = new boolean[n][m]; this space can be saved on original grid

        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(source);
        int path = 0;
        while (!queue.isEmpty()) {
            path++;
            //cache current size
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                Point head = queue.poll();
                for (int i = 0; i < dX.length; i++) {
                    int x = dX[i] + head.x;
                    int y = dY[i] + head.y;
                    if (x == destination.x && y == destination.y) {
                        return path;
                    }
                    if (isInBound(grid, x, y) && !grid[x][y]) {
                        queue.offer(new Point(x, y));
                        grid[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isInBound(boolean[][] grid, int n, int m) {
        return  n >= 0 && m >= 0 && n < grid.length && m < grid[0].length;
    }
}
