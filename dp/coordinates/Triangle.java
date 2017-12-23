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
 * traverse:从顶点(0,0)开始向下走，那么可以走到x+1,y+1, 或者x+1, y,深搜
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

    //version: traverse
    int sum = Integer.MAX_VALUE;
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int n = triangle.length;
        traverse(triangle, 0, 0, 0);
        return sum;
    }

    private void traverse(int[][] triangle, int x, int y, int total) {
        if (x == triangle.length) {
            if (total < sum) {
                sum = total;
            }
            return;
        }
        traverse(triangle, x+1, y, total + triangle[x][y]);
        traverse(triangle, x+1, y+1, total + triangle[x][y]);
    }

    //version: devide & conqure
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        return miniHelper(triangle, 0, 0);
    }
    
    private int miniHelper(int[][] triangle, int x, int y) {
        if (x == triangle.length) {
            return 0;
        }
        int left = miniHelper(triangle, x+1, y);
        int right = miniHelper(triangle, x+1, y+1);
        return triangle[x][y] + Math.min(left, right);
    }

    //version: devide & conqure with memorization
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int n = triangle.length;
        int[][] cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = Integer.MAX_VALUE;
            }
        }
        return minHelper(triangle, cache, 0, 0);
    }
    
    private int minHelper(int[][] triangle, int[][] cache, int x, int y) {
        if (x == triangle.length) {
            return 0;
        }
        if (cache[x][y] != Integer.MAX_VALUE) {
            return cache[x][y];
        }
        int left = minHelper(triangle, cache, x+1, y);
        int right = minHelper(triangle, cache, x+1, y+1);
        cache[x][y] = Math.min(left, right) + triangle[x][y]; 
        return cache[x][y];
    } 
}
