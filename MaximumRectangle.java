/**
[
  [1, 1, 0, 0, 1],
  [0, 1, 0, 0, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 1, 1, 1],
  [0, 0, 0, 0, 1]
]
*/
public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
		if(matrix == null || matrix.length == 0) {
			return 0;
		}
		int[] input = new int[matrix[0].length];
		int maxRectangle = 0;
		for(int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!matrix[i][j]) {
					input[j] = 0;
				} else {
					input[j] = input[j] + 1;
				}
			}
			maxRectangle = Math.max(maxRectangle, maxRecRow(input));
		}
		return maxRectangle;
    }
	private int maxRecRow(int[] row) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for(int i = 0; i <= row.length; i++) {
			int curr = (i == row.length) ? -1 : row[i];
			while(!stack.isEmpty() && curr < row[stack.peek()]) {
				int height = row[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() -1;
				max = Math.max(max, height * width);
			}
			stack.push(i);
		}
		return max;
	}
}