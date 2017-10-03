/**
 * Prob: wiggle-sort No: 508
 * Given an unsorted array nums, reorder it in-place such that
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * Notice: please complete the problem in place
 * Example:
 * Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4]
 * 思路：遍历一遍，如果出现不满足的情况，那么对换就可
 */
public class Solution {
    //O(n)
	/*
     * @param nums: A list of integers
     * @return: nothing
     */
	public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i-1]) || 
                (i % 2 == 0 && nums[i] > nums[i-1])) {
                swap(nums, i, i-1);
                }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp; 
    }

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i+=2) {
            swap(nums, i, i-1);        
        }
    }
}
