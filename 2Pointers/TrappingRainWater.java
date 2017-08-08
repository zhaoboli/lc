/**
 * Prob: trapping-rain-water No: 363
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 思路：
 * 两头指针，从矮的一边开始找，短板效应,如果碰到比当前边的指针要小，当前边设为此值，同时比较另外一边，决定下一次从左还是从右
 */
public class Solution {
    /*
     * @param : a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int leftHeight = heights[left];
        int rightHeight = heights[right];
        int trappedWater = 0;
        while (left < right) {
            if (leftHeight < rightHeight) {
                if (heights[left] - leftHeight <= 0) {
                    trappedWater += leftHeight - heights[left];
                    left++;
                } else {
                    leftHeight = heights[left];
                }
            } else {
                if (heights[right] - rightHeight <= 0) {
                    trappedWater += rightHeight - heights[right];
                    right--;
                } else {
                    rightHeight = heights[right];
                }
            }
        }
        return trappedWater;
    }
};
