public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        if (heights == null) {
            return 0;
        }
        
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(heights.length * heights[0].length, new Comparator<Cell>() {
            @Override
            public int compare(Cell left, Cell right) {
                return left.height - right.height;
            }
        });

        boolean[][] bitMap = new boolean[heights.length][heights[0].length];

        for ( int i = 0; i < heights.length; i++) {
           for (int j = 0; j < heights[0].length; j++) {
              if (i == 0 || j == 0 || i == (heights.length - 1) || j == (heights[0].length - 1)) {
                  queue.offer(new Cell(i, j, heights[i][j]));
                  bitMap[i][j] = true;
              }
           }
        }
        int[] dX = {-1, 1, 0, 0};
        int[] dY = {0, 0, -1, 1}; 
        int trappedWater = 0;

        while (!queue.isEmpty()) {
            Cell ce = queue.poll();
            for ( int i = 0; i < 4; i++) {
                int row = ce.x + dX[i];
                int col = ce.y + dY[i];
                if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || bitMap[row][col]) {
                    continue;
                }
                if (heights[row][col] < ce.height) {
                    trappedWater += ce.height - heights[row][col];
                    heights[row][col] = ce.height;
                }
                queue.offer(new Cell(row, col, heights[row][col]));
                bitMap[row][col] = true;
            }    
        }
        return trappedWater;
    }

    private class Cell {
        public int height;
        public int x; 
        public int y;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
