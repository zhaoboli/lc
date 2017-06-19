/*Find the contiguous subarray within an array (containing at least one number) 
* which has the largest product.

*For example, given the array [2,3,-2,4], 
*the contiguous subarray [2,3] has the largest product = 6.
*/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int n = nums.length;
		int[] min = new int[n];
		int[] max = new int[n];
		min[0] = max[0] = nums[0];
		
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				max[i] = Math.max(nums[i], max[i-1] * nums[i]);
				min[i] = Math.min(nums[i], min[i-1] * nums[i]);
			}
			if (nums[i] < 0) {
				max[i] = Math.max(nums[i], min[i-1] * nums[i]);
				min[i] = Math.min(nums[i], max[i-1] * nums[i]);
			}
			result = Math.max(result, max[i]);
		}
		return result;
    }
}