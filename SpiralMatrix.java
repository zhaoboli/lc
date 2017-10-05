/** 
 * Prob: spiral-matrix No: 374
 * Given a matrix of m * n elements(m rows, n columns, return all
 * elements of the matrix in spiral order.
 * Given the following matrix:
 * [
 *  [1, 2, 3],
 *  [4, 5, 6],
 *  [7, 8, 9]
 *  ]
 * return [1, 2, 3, 4, 5, 6, 7, 8, 9]
 */
public class Solution {
    /*
     * @param matrix: a matrix of m x n elements
     * @return: an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int n = matrix.length;
        int m= matrix[0].length;
        int total = n * m;
        int counter = 1;
        for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
            if (counter == total) {
                result.add(matrix[i][i]);
                counter++;
            }
            //first row
            for (int j = i; j < (m-1-i); j++) {
                 if (counter > total) {
                    break;
                }
                result.add(matrix[i][j]); 
                counter++;
            }
            //last col
            for (int j = i; j < (n-1-i); j++) {
                if (counter > total) {
                    break;
                }
                result.add(matrix[j][m-1-i]);
                counter++;
            }
            //last row
            for (int j = (m-1-i); j > i; j--) {
                if (counter > total) {
                    break;
                }
                result.add(matrix[n-1-i][j]);
                counter++;
            }
            //first col
            for (int j = (n-1-i); j > i; j--) {
                if (counter > total) {
                    break;
                }
                result.add(matrix[j][i]);
                counter++;
            }
        }
        return result;
    }
}
