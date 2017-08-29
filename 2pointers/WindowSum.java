public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }

        //initialization
        int[] sum = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sum[0] += nums[i];
        }

        for (int j = 1; j < sum.length; j++) {
            sum[j] -= nums[j - 1];
            sum[j] += sum[j - 1];
            sum[j] += nums[j + k -1];
        }
        return sum;
        }

}
