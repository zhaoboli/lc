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
