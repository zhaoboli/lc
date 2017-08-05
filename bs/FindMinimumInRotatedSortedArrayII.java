/**
 * Prob: find-minimum-in-rotated-sorted-array-ii No: 160
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * The array may contain duplicates.
 * Given [4,4,5,6,7,0,1,2] return 0.
 *
 * 思路：
 * 这里如果能想到最坏情况，即一堆１里有一个０就可知此题并不能用二分法
 *
 */
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            min = Math.min(min, num[i]);
        }
        return min;
    }
}
