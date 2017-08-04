/**
 * Prob: two-sum-difference-equals-to-target No: 610
 * Given an array of integers, find two numbers that their difference equals to a target value.
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are NOT zero-based.
 * It's guaranteed there is only one available solution
 * Given nums = [2, 7, 15, 24], target = 5
 * return [1, 2] (7 - 2 = 5)
 *
 * 思路： 
 * 要用两根指针的问题， 先决条件， 如果和target比较过大小，得能确定往哪个方向走
 *　a - b = target, 假若数组从小到大，用最大减最小，　假若目标是正数，如果结果小于target，则无解，
 * 如果结果大于target，此时会出现无法抉择的情况，因为左移和右移均可
 *　因此要想到要固定一个，虽然牺牲掉一定的时间，但是应该可以找到解
 × 那么接下来如果target为负数，那么可以 a - b = -7, b - a = 7， 因此我们只需把-7换成7 即可
 */
 
public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        int[] ans = new int[2];
		if (nums == null || nums.length <= 2) {
			return ans;
		}
		if (target < 0) {
			target = -target;
		}
		
		Pair[] arr = new Pair[nums.length];
		for (int i = 0; i < nums.length; i++) {
			arr[i] = new Pair(i, nums[i]);
		}
		
		Arrays.sort(arr, new Comparator<Pair> () {
			@Override
			public int compare(Pair left, Pair right) {
				return left.value - right.value;
			}
		});
		
		for (int i = 0; i < arr.length; i++) {
			int j = i + 1;
			while (j < arr.length) {
				if (arr[j].value - arr[i].value < target) {
					j++;
				} else if (arr[j].value - arr[i].value == target) {
					ans[0] = Math.min(arr[i].index, arr[j].index) + 1;
					ans[1] = Math.max(arr[i].index, arr[j].index) + 1;
					return ans;
				} else {
					break;
				}
			}
		}
		return ans;
    }
	
	private class Pair {
		int index;
		int value;
		public Pair (int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}