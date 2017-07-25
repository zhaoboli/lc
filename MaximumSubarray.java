package com.zhaobo;

/**
 * Created by Nate_Li on 4/25/2017.
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 *  Notice

 The subarray should contain at least one number.
 Example
 Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    int maxSum = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return maxSum;
        }
        maxSubArrayHelper(nums, 0, 0, maxSum);

        return maxSum;
    }

    private void maxSubArrayHelper(int[] nums, int start, int level, int currSum) {
        if (currSum > maxSum) {
            maxSum = currSum;
        }

        if (level > 0) {
            if (start < nums.length) {
                currSum += nums[start];
                maxSubArrayHelper(nums, start + 1, level + 1, currSum);
            }
        }
        if (level == 0) {
            currSum = 0;
            for (int index = start; index < nums.length; index++) {
                currSum += nums[index];
                maxSubArrayHelper(nums, index + 1, level + 1, currSum);
                currSum -= nums[index];
            }
        }
    }

    public int maxSubArrayPrefixSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        //注意 sum 和minArr的初始值 
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minArr = 0;
        //注意前缀和要比前缀的最小数组多一位，否则就会出现为0的情况，即使整个数组全是负数，因此, 先求前缀和，再累积求最小数组  
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minArr);
            minArr = Math.min(minArr, sum);
        }
        return maxSum;
    }
}
