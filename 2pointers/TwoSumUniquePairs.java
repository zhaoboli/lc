/**
 * Prob: two-sum-unique-pairs No: 587
 * Given an array of integers, 
 * find how many unique pairs in the array such that their sum is equal to a specific target number. 
 * Please return the number of pairs.
 * Given nums = [1,1,2,45,46,46], target = 47
 * return 2
 *
 *	1 + 46 = 47
 *	2 + 45 = 47
 *	问：是否可以先去重，答案是否定的，如果target=12,有两个６
 */
public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
			return 0;
		}
		int n = nums.length;
		int left = 0;
		int right = n - 1;
		int ct = 0;
		//去重技巧， 这时候不能用hash去重，因为如果相等，那么无法判断向左增还是向右减
		//所以说有两种想法，
		//一种是先记录合法解，然后看当前的元素是不是重复的合法解。
		//但在这里行不通，因为不知道向左还是向右，可以想到的做法是设置上次移动指针的标志位，
		//但是如果上来的两组解就等与target，就无从谈起
		//二是就是一旦出现合法解，再看有没有重复解，如果再出现合法解，那么有以下几种情况
		//那么直接往中间各缩进一位就能可以，如果任何一边出现重复，就一直走到那边不重复的为止
		//1 1 1 2 3 10 11 12 12 12
		//1 1 2 3 10 11 12
		//1 2 3 10 11 12
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				ct++;
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return ct;
    }
}
