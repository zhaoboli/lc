public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
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
