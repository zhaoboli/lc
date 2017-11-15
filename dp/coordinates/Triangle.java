/**
 * Prob: triangle No: 109
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * [
 *[2],
 *[3,4],
 *[6,5,7],
 *[4,1,8,3]
 *]
 * the minimum path sum from top to bottom is 11(i.e 2 + 3 + 1 = 11) 
 * 思路：
 * 经典的动规，对空间优化的话可以用i%2
 *
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    
    //version Nov15th_2017
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int len = triangle.length;
        if (len == 1) {
            return triangle[0][0];
        }
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        int minTotal = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                if (i == len - 1) {
                    minTotal = Math.min(dp[i][j], minTotal);
                }
            }
        }
        return minTotal;
    }
    
    //version: try to get O(n) space
    public int minimumTotal (int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int len = triangle.length;
        if (len == 1) {
            return triangle[0][0];
        }
        int[][] dp = new int[2][len];
        dp[0][0] = triangle[0][0];
        int minTotal = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i%2][j] = dp[(i-1)%2][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i%2][j] = dp[(i-1)%2][j-1] + triangle[i][j];
                } else {
                    dp[i%2][j] = Math.min(dp[(i-1)%2][j-1], dp[(i-1)%2][j]) + triangle[i][j];
                }
                if (i == len - 1) {
                    minTotal = Math.min(dp[i%2][j], minTotal);
                }
            }
        }
        return minTotal;
    }
}
