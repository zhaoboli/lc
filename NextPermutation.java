public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
        if (nums == null) {
            return nums;
        }
        int len = nums.length;
        if (len <= 1) {
            return nums;
        }

        //find the last number before keep "increasing from reverse"
        int index = len - 2;
        //4321
        //5643
        while (nums[index + 1] <= nums[index] && index > 0) {
            index--;
        }
        int bigger = len -1;

        while (nums[bigger] <= nums[index] && bigger > 0) {
            bigger--;
        }

        swapItem(nums, bigger, index);
        int left = 0;
        int right = len - 1;
        if (bigger == index) {
            // reverse the whole array when index == bigger == 0
            left = index;
        } else {
            // else reverse the right section so that it's the smallest number
            left = index + 1;
        }

        while(left < right) {
            swapItem(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }

    private void swapItem(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
