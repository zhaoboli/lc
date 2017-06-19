public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equal to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }

        int len = values.length;
        int[][] dp = new int[len][len];

        int sum = 0;
        for (int num : values) {
            sum += num;
        }

        for (int i = 0; i < len; i++) {
            dp[i][i] = values[i];
        }

        return 2 * memorizedSearch(0, len-1, dp, values) > sum; 
    }

    //from values[left] to values[right], the max score the first move players can get
    private int memorizedSearch(int left, int right, int[][] dp, int[] values) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        if (right -left == 1) {
            //memorization
            dp[left][right] = Math.max(values[left], values[right]);
            return dp[left][right];
        }
        //memorization
        dp[left][right] =  Math.max(values[left] + Math.min(memorizedSearch(left+2, right, dp, values), memorizedSearch(left+1, right -1, dp, values)),
                values[right] + Math.min(memorizedSearch(left+1, right -1, dp, values), memorizedSearch(left, right -2, dp, values)));

        return dp[left][right];
    }
}
