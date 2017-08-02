/**
 * Prob: 3sum-closest No: 59
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers.
 * Notice: You may assume that each input would have exactly one solution.
 * For example, given array S = [-1 2 1 -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 思路还比较好顺，如果３个数大于target则左移，反之右移
 */

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
			return -1;
		}
		Arrays.sort(numbers);
        //初始化
        int bestSum = numbers[0] + numbers[1] + numbers[2];
		for (int i = 0; i < numbers.length - 2; i++) {
			int left = i + 1;
			int right = numbers.length - 1;
			while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                //此处有犯错
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
                    bestSum = sum; 
                }
                if (sum - target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
		}
		return bestSum;
    }
}
