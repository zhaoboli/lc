public class Solution {
    /**
     * Prob: two-sum-closest-to-target No: 533
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        while (left < right) {
            int diff = (nums[left] + nums[right]) - target;
            min = Math.min(Math.abs(diff), min);
            if (diff > 0) {
                right--; 
            } else if (diff == 0) {
                return 0;
            } else {
                left++;
            }
        } 
        return min;
    }
}
