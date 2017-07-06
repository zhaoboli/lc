public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] newnums = new int[n+2];
        for(int i = 0; i < newnums.length; i++) {
            if (i == 0 || i == n + 1) {
                newnums[i] = 1;
                continue;
            }
            newnums[i] = nums[i-1];
        }
        
        int[][] dp = new int[n+1][n+1];
        return search(newnums, 1, n, dp);    
    }

    private int search(int[] nums, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        if (i == j) {
            dp[i][j] = nums[i-1] * nums[i] * nums[i+1];
            return dp[i][j];
        }
        int max = 0; 
        for (int k = i; k <= j; k++) {
            max = Math.max(max, search(nums, i, k-1, dp)  + nums[i-1] * nums[k] * nums[j+1] + search(nums, k+1, j, dp));
        }
        dp[i][j] = max;
        return max;
    }
}
