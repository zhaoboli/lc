/**
 * Prob: partition-array-by-odd-and-even No: 373
 * Partition an integers array into odd number first and even number second.
 * Given [1, 2, 3, 4], return [1, 3, 2, 4]
 *　思路：
 × 这里可以用首尾两根指针的partition，也可以用快排的partition （因为只有两堆）
 */
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null || nums.length < 2) {
			return;
		}
		int odd = 0;
		int even = nums.length - 1;
		int index = 0;
		
		while (index < even) {
			if (nums[index] % 2 == 0) {
				swap(nums, index, even);
				even++;
			} else {
				swap(nums, index, odd);
				odd++;
				index++;
			}
		}
    }
	
	private void swap (int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	
    public void partitionArray(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			while (left <= right && nums[left] % 2 == 1) {
				left++;
			}
			while (left <= right && nums[right] % 2 == 0) {
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
    }
}