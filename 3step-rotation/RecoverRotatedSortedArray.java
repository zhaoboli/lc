/*
 * Prob: recover-rotated-sorted-array No: 39
 * Given a rotated sorted array, recover it to sorted array in-place.
 * What is rotated array?
 * For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 */
public class Solution {
    /*
     * @param nums: An integer
     * @return:
     */

    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return;
        }
        int rotate = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) > nums.get(i)) {
                rotate = i;
                break;
            }
        }
        int start = 0;
        int end = nums.size() - 1;

        reverse(nums, start, rotate - 1);
        reverse(nums, rotate, end);
        reverse(nums, start, end);
    }

    private void reverse(List<Integer> nums, int left, int right) {
        if (left == right) {
            return;
        }
        while (left <= right){
            int temp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, temp); 
            left++;
            right--;
        }
    }

};
