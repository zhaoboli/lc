public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] negNums = new int[len];
        for (int i = 0; i < len; i++) {
            negNums[i] = -1 * nums[i];
        }
        int[] leftPrefixMax = new int[len];
        int[] leftPrefixMin = new int[len];
        int[] rightPrefixMax = new int[len];
        int[] rightPrefixMin = new int[len];

        int max = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            leftPrefixMax[i] = max;
        }

        sum = 0; max = Integer.MIN_VALUE; min = 0;
        for (int i = 0; i < len; i++) {
            sum += negNums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            leftPrefixMin[i] = -1 * max;
        }

        sum = 0; max = Integer.MIN_VALUE; min = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            rightPrefixMax[i] = max;
        }

        sum = 0; max = Integer.MIN_VALUE; min = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += negNums[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            rightPrefixMin[i] = -1 * max;
        }

        max = 0;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, leftPrefixMax[i] - rightPrefixMin[i + 1]);
            max = Math.max(max, rightPrefixMax[i + 1] - leftPrefixMin[i]);
        }
        return max;
    }
}
