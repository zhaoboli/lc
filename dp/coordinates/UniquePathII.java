/**
 * Prob: unique-paths-ii No: 115
 * 思路：
 * 跟unique-path类似，只需判断有障碍情况即可
 * 
 */
public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] f = new int[n][m];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        f[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                f[i][0] = 0;
                break;
            } 
            f[i][0] = 1;
        }
        
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[0][j] == 1) {
                f[0][j] = 0;
                break;
            }
            f[0][j] = 1;
        }
        
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[n-1][m-1];
    }
}
