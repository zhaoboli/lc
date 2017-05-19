public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
	 
	//O(n) space && O(n) time
    public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int width = matrix[0].length;
        int depth = matrix.length;

        int[][] cache = new int[depth][width];

        int max = 0;
        for (int i = 0; i < depth; i++) {
            for(int j = 0; j < width; j++) {
                if(i - 1 >= 0 && j - 1 >= 0 && cache[i-1][j-1] != 0 && matrix[i][j] != 0) {
                    cache[i][j] = Math.min(cache[i - 1][j - 1], Math.min(cache[i - 1][j], cache[i][j - 1])) + 1;
                } else {
                    cache[i][j] = matrix[i][j];
                }
                max = Math.max(max, cache[i][j]);
            }
        }
        return max * max;
    }
}