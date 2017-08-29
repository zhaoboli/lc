/**
* Prob: two-sum-input-array-is-sorted No: 608

* Given an array of integers that is already sorted in ascending order, 
* find two numbers such that they add up to a specific target number.
* The function twoSum should return indices of the two numbers such that they add up to the target, 
* where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
*/
public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
		if (nums == null || nums.length < 2) {
			return result;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if ((nums[left] + nums[right]) < target) {
				left++;
			} else if ((nums[left] + nums[right]) > target) {
				right--;
			} else {
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			}
		}
		return result;
    }
}