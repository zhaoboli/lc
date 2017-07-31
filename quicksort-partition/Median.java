/**
 * Prob: Median No: 80
 * Given a unsorted array with integers, find the median of it.
 * A median is the middle number of the array after it is sorted.
 * If there are even numbers in the array, return the N/2-th number after sorted.
 *
 * Example
 * Given [4, 5, 1, 2, 3], return 3.
 * Given [7, 9, 4, 5], return 5.
 * Test case: [4,5,1,2,3], return 3
 */
public class Solution {
    /**
     * @param nums: A list of integers
     * @return : An integer denotes the middle nums of the array
     */
    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int median = (n - 1) / 2;
        return helper(nums, 0, n - 1, median);
    }

    private int helper(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        //left <= right, avoid redaudant, so that left, right crosses after O(n) traverse
        while (left <= right) {
            while (nums[left] < pivot && left <= right) {
                left++;
            }
            while (nums[right] > pivot && left <= right) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (start + k <= right) {
            return helper(nums, start, right, k);
        } else if (start + k >= left) {
            return helper(nums, left, end, start + k - left);
        } else {
            return nums[right+1];
        }
    }
}
