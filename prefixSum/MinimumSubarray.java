public class Solution {
    /**
     * @param nums: a list of integers;
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return Integer.MAX_VALUE;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(Integer i: nums) {
            temp.add(-1 * i);
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int min = 0;
        for(int index = 0; index < temp.size(); index++) {
            sum += temp.get(index);
            max = Math.max(sum - min, max);
            min = Math.min(min, sum);
        }
        return -1 * max;
    }
}
