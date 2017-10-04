/**
 * Prob: spiral-matrix-ii No: 381
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * Example: 
 * Given n = 3,
 * should return the follwing matrix:
 * [
 * 	[1, 2, 3],
 * 	[8, 9, 4],
 *  [7, 6, 5] 
 * ]
 * 思路:
 * 从外到里的遍历,如果碰到只有一个元素,那么此元素肯定为中心点，
 * matrix[(n-1)/2][(n-1)/2] = total
 */
public class Solution {
    /*
     * @param n: An integer
     * @return: a square matrix
     */
    public int[][] generateMatrix(int n) {
        int total = n * n;
        int[][] matrix = new int[n][n];
        int index = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            if (index == total) {
                matrix[i][i] = total;
            }
            for (int j = i; j < (n - 1 - i); j++) {
                matrix[i][j] = index++;
            }
            for (int j = i; j < (n - 1 - i); j++) {
                matrix[j][n-1-i] = index++;
            }
            for (int j = (n - 1- i); j > i; j--) {
                matrix[n-1-i][j] = index++;
            }
            for (int j = (n - 1 - i); j > i; j--) {
                matrix[j][i] = index++;
            }
        }
        return matrix;
    }
}
