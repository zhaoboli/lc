public class Solution {
    /**
     * @param nums an array of integers
     * @param k an integer
     * @return the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;

        int minPrefixSum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
            if (i >= k) {
                minPrefixSum = Math.min(minPrefixSum, prefixSum[i - k]); 
                result = Math.max(result, prefixSum[i] - minPrefixSum);
            }
        }
        if (result == Integer.MIN_VALUE) {
            return 0;
        }
        return result;
    }
}
