Given a sequence of integers, find the longest increasing subsequence (LIS).
You code should return the length of the LIS.

Clarification
What's the definition of longest increasing subsequence?
The longest increasing subsequence problem is to find a subsequence of a given sequence 
in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
https://en.wikipedia.org/wiki/Longest_increasing_subsequence

Example:
For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

/**
 * Prob: longest-increasing-subsequence No: 76
 *
 */
public class Solution {
	/*
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] lis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }
        
        int max = 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[j] +1, lis[i]);
                }
            }
        }
        
        for (int i = 0; i < lis.length; i++) {
            max = Math.max(max, lis[i]);
        }
        
        return max;
    }	
}