/**
 * Prob: search-in-rotated-sorted-array-ii No: 63
 * 
 * Follow up for Search in Rotated Sorted Array:
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * Example:
 * Given [1, 1, 0, 1, 1, 1] and target = 0, return true.
 * Given [1, 1, 1, 1, 1, 1] and target = 0, return false.
 * 思路：
 * 显然这里通过跟target比大小并不能确定去左还是右
*/
public class Solution {
    /*
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length ==0) {
            return false;
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return true;
            }    
        }
        return false;
    }
}
