/**
There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until there are no more coins left. 
The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
           return false;
        } 
        int n = values.length; 
        //when n coins left, the max value of first player can get
        if(n <= 2) {
            return true;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += values[i];
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = values[n-1];
        dp[2] = values[n-1] + values[n-2];
        dp[3] = values[n-3] + values[n-2];
        //error at: values[n-i]
        //from right to left
        for (int i = 4; i <= n; i++)  {
            dp[i] = Math.max(values[n-i] + Math.min(dp[i-2], dp[i-3]), 
                    values[n-i] + values[n-i+1] + Math.min(dp[i-3], dp[i-4]));
        }

        if (dp[n] > sum / 2) {
            return true;
        }
        return false;
    }
}
