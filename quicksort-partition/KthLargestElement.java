/**
 * Prob: kth-largest-element No: 5
 * Find K-th largest element in an array.
 * Notice: You can swap elements in the array
 * Example:
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest element is 3 and etc.
 * Test case: 3, [9,3,2,4,8]
 */
class Solution {
    /*
     * @param k: description of k
     * @param nums: array of nums
     * @return: descrition of retrun
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        return quickselect(nums, 0, n-1, k);
    }

    private int quickselect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while (left <= right) {
            while (nums[left] > pivot && left <= right) {
                left++;
            }
            while (nums[right] < pivot && left <= right) {
                right--;
            }
            if (left <= right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
        if (start + k - 1 <= right) {
            return quickselect(nums, start, right, k);
        } else if (start + k - 1 >= left) {
            return quickselect(nums, left, end, start + k - left);
        } else {
            return nums[right+1];
        }
    }

}
