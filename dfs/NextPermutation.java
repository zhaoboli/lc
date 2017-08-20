/**
 * Given a list of integers, which denote a permutation.
 * Find the next permutation in ascending order.
 * Prob: next-permutation No: 52
 *
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 *
 * 思路： 
 * 先找到从右往左的第一个降序的元素 nums[index]
 * 然后再在其右边找第一个比它大的元素，二者交换位置
 * 然后再对 index +1 到最右的元素进行反序 
 *
 *
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     * 数学和coding基本功
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
