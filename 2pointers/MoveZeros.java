/**
 * Prob: move-zeros No: 539
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Notice: 1. You must do this in-place without making a copy of the array. 2. Minimize the total number of operations
 * Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 思路:
 * 假如存在0，那么这样如果碰到0， 那么前指针会往前走但后指针不动，
 * 如果碰到非0， 前后指针元素互换，那么本来的第一个0被被置换到最后一位， 同时0位换成非0位
 * 两指针同向
 */
public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
		int left = 0;
		int right = 0;
		while (right < nums.length) {
			if (nums[right] != 0) {
				int temp = nums[right];
				nums[right] = nums[left];
				nums[left] = temp;
				left++;
			}
			right++;
		}
	}		
}