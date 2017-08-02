/**
 * Prob: 3sum-closest No: 59
 * Given an array S of n integers, 
 * find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers.
 * Notice: You may assume that each input would have exactly one solution.
 * For example, given array S = [-1 2 1 -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
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
		int min = Integer.MAX_VALUE;
		int sum = -1;
		for (int i = 0; i < numbers.length - 2; i++) {
			int currtar = target - numbers[i];
			int left = i + 1;
			int right = numbers.length - 1;
			while (left < right) {
				if ((numbers[left] + numbers[right]) > currtar) {
					if (Math.abs(numbers[left] + numbers[right] - currtar) < min) {
						min = Math.abs(numbers[left] + numbers[right] - currtar);
						sum = numbers[i] + numbers[left] + numbers[right];
					}
					right--;
				} else if ((numbers[left] + numbers[right]) == currtar){
					return target;
				} else {
					if (Math.abs(numbers[left] + numbers[right] - currtar) < min) {
						min = Math.abs(numbers[left] + numbers[right] - currtar);
						sum = numbers[i] + numbers[left] + numbers[right];
					}
					left++;
				}
			}
		}
		return sum;
    }
}
