Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

This problem have two method which is Greedy and Dynamic Programming.
The time complexity of Greedy method is O(n).
The time complexity of Dynamic Programming method is O(n^2).
We manually set the small data set to allow you pass the test in both ways. 
This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, 
you can try greedy method to make it accept again.

Example
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
/**
 * Prob: jump-game No: 116
 * 思路：坐标型dp, 不说
 */
public class Solution {
    /*
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        //f[n], 此点能不能跳到
        if (A== null && A.length == 0) {
            return false;
        }
        
        int n = A.length;
        boolean[] f = new boolean[n];
        f[0] = true;
        
        for (int i = 1; i < n; i++) {
            for (int j = i -1; j >= 0; j--) {
                if (f[j] && (j + A[j]) >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n-1];
    }
}
