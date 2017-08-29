/**
 * Prob: remove-duplicates-from-sorted-array-ii No: 101
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 思路：
 *　可以调优，１和２都可以调优
 * 
 */
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
			return 0;
		}
		int index = 0;
		int counter = 1;
		int previous = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == previous) {
				if (counter >= 2) {
					counter++;
				} else {
					counter++;
					nums[++index] = nums[i];
				}
			} else {
				previous = nums[i];
				nums[++index] = nums[i];
				counter = 1;
			}
		}
		return index + 1;
    }
}