Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
Example:
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

/**
 * Prob: jump-game-ii No: 117
 * 思路：f[i]：跳到第i个位置，最少需要几步
 *
 */
public class Solution {
    /*
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int n = A.length;
        int[] f = new int[n];
        if (n == 1) {
            return 0;
        }
        
        for (int i = 0; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        f[0] = 0;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        return f[n-1];
    }
}
