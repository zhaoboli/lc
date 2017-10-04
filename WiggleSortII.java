/** 
 * Prob: wiggle-sort-ii No: 507
 * Given an unsorted array nums, reorder it such that
 * nums[0] < nums[1] > nums[2] < nums[3]....
 * Notice: you may assume all input has valid answer
 * Example: 
 * Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 思路：
 * 先排好序，然后一个从头一个从尾，隔着放
 * 但是这样处理就会有接下来的结果[1,3,2,2,3,1], [1,3,1,3,2,2]
 * 找到中位数偏右，然后从左到右，一小一大,但这样会有这样的结果: [4, 5, 5, 6] [4, 5, 5, 6]
 * 那从尾向头遍历
 *
 */
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: nothing
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);        
        int[] temp = new int[nums.length];
        int small = (nums.length - 1) / 2;
        int big = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                temp[i] = nums[small--];
            }
            if (i % 2 == 1) {
                temp[i] = nums[big--];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
}
