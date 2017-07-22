class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.lenghth == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            while (nums[left] < 1 && left < right) {
                left++;
            }
            while (nums[right] > 1 && left < right) {
                right--;
            }
            if ( 
        }
    }
}
