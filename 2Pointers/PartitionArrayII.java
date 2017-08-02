/**
 * Prob: partition-array-ii No: 625
 * 
 * Partition an unsorted integer array into three parts:
 * The front part < low
 * The middle part >= low & <= high
 * The tail part > high
 * low <= high in all testcases.
 
 * Given [4,3,4,1,2,3,1,2], and low = 2 and high = 3.
 * Change to [1,1,2,3,2,3,4,4].
 * ([1,1,2,2,3,3,4,4] is also a correct answer, but [1,2,1,2,3,3,4,4] is not)
 ×　思路：
 * 1.这里不能直接用快排的方式去partition，因为不单单的是不在left就在right的问题，因为中间是个区间，还可能是在中间
 ×　2. 如果从right换过的数还可能在right或者可能在left
 * 3. 反之如果从left换过来的数就只可能是中间区间的数
 */ 
public class Solution {
    /**
     * @param nums an integer array
     * @param low an integer
     * @param high an integer
     * @return nothing
     */
    public void partition2(int[] nums, int low, int high) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i <= right) {
			if (nums[i] > high) {
				swap(nums, i, right);
				//2. 如果从right换过的数还可能在right或者可能在left,因此对换过来的数i还要再做一次比对
				right--;
			} else if (nums[i] >= low && nums[i] <= high) {
				i++;
			} else {
				swap(nums, i, left);
				left++;
				// 3. 反之如果从left换过来的数就只可能是中间区间的数，因为i++
				i++;
			}
		}
    }
	private void swap(int[] nums, int i , int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}