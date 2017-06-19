public class Solution {
    /**
     * @param nums: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[2];
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return 0;
        }

        dp[0] = 0;
        dp[1] = nums[0];
        int max = 0;
        for (int i = 2; i < n; i++) {
           dp[i%2] = Math.max(dp[(i-1)%2], dp[(i-2)%2] + nums[i-1]);
        }
        max = dp[(n-1)%2];
        //remember to reset dp[0]
        //TODO code is ugly, to abstract hourserobber section and get the max of 0 -> n-2 and 1 -> n-1
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i%2] = Math.max(dp[(i-1)%2] , dp[(i-2)%2] + nums[i]);
        }
        max = Math.max(max, dp[(n-1)%2]);

        return max;
    }
}
