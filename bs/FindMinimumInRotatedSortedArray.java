public class Solution {
    /**
     * Prob: find-minimum-in-rotated-sorted-array No: 159
     *
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     * 思路：
     * 二分法：满足某个条件的第一个值
     * 转化为满足小于end的第一个值，此处不能用start，因为如果是未打断顺序的序列，会出现无解的情况
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        
        int start = 0;
        int end = nums.length - 1;
        //find the smallest number which is less than target, note nums[start] should not be selected
        int target = nums[end];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                end = mid;
            } else (nums[mid] >= target) {
                start = mid;
            } 
        }

        return Math.min(nums[start], nums[end]);
    }
  }
