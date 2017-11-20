Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.

Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.
/**
 * Prob: search-a-2d-matrix-ii No: 38
 * 
 */

public class Solution {

    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int start = 0;
        int end = matrix.length - 1;
        int rowEnd = 0;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (matrix[end][0] <= target) {
            rowEnd = end;
        } else {
            if (matrix[start][0] <= target) {
                rowEnd = start;
            } else {
                rowEnd = -1;
            }
        }
        
        if (rowEnd == -1) {
            return 0;
        }
        
        start = 0;
        end = rowEnd;

        int last = matrix[0].length - 1;
        int rowStart = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][last] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start][last] >= target) {
            rowStart = start;
        } else {
            if (matrix[end][last] >= target) {
                rowStart = end;
            } else {
                rowStart = -1;
            }
        }

        if (rowStart == -1) {
            return 0;
        }
        int occurCt = 0;

        for(int i = rowStart; i <= rowEnd; i++) {
            if (find(matrix, i, target)) {
                occurCt++;
            }
        }
        return occurCt;
    }

    private boolean find(int[][] matrix, int row,  int target) {
        int start = 0;
        int end = matrix[row].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }

    [[1, 3, 5, 7]
    [2, 4, 7, 8]
    [3, 5, 9, 10]]

    //From Bottom left to top rigtht
    public int searchMatrixImpvd(int[][] matrix, int target) {
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length - 1;
        int col = matrix[0].length;

        int x = row;
        int y = 0;
        int occurCt = 0;

        while (x >= 0 && y < col) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else { 
                occurCt++;
                x--;
                y++;
            }
        }
        return occurCt;
    }
}
