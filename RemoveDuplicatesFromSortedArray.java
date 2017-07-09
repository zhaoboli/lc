public class Solution {
    /**
     * @param A: a array of integers
     * @return: return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 1 ) {
            return nums.length;
        }

        int newIndex = 0;
        int currIndex = 1;
        int previous = nums[0];
        while (currIndex < nums.length) {
            if (nums[currIndex] == previous) {
                currIndex++;
            } else {
                previous = nums[currIndex];
                nums[++newIndex] = nums[currIndex++];
            }
        }
        return newIndex + 1;
    }
}
