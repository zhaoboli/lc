/**
* Prob: partition-array No: 31
* Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

* All elements < k are moved to the left
* All elements >= k are moved to the right
* Return the partitioning index, i.e the first index i nums[i] >= k.
*
* You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
* If all elements in nums are smaller than k, then return nums.length
*/

public class Solution {
	/**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //left, right 碰头过后还要继续向前走，这个时候right肯定已经是在比k小的元素
            //可能还是倒数第二个比k小的元素,(此时已不满足left <= right) 反观之left碰头的时候肯定刚到比k大的元素
            while (left <= right && nums[left] < k) {
                left++;
            }
            while (left <= right && nums[right] >= k) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
