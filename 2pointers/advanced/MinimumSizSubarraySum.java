public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */

    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int j = 0;
        int len = Integer.MAX_VALUE;
        
        //单调向前
        for (int i = 0; i < nums.length; i++) {
            while (sum < s && j < nums.length) {
                sum += nums[j++];
            }
            if ((j - i) < len && sum >= s) {
                len = j - i;
            }
            sum -= nums[i];
        }

        if(len == Integer.MAX_VALUE) {
            return -1;
        }
        return len;
    }
  }
