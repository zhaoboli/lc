/*
 *
 *  Prob: o1-check-power-of-2 No: 
 *   Using O(1) time to check whether an integer n is a power of 2.
 *   Example:
 *   for n=4, return true;
 *   for n=5, return false;
 * 思路：
 * 如果一个数是2的m次幂，那么这个数n必须
 * 1. n > 0 
 * 2. 并且(n & (n-1)) == 0
 * 此处2.的作用是去掉数n的最右边的一个1
 * 比如12, 二进制的表示是(1100) 2
 * x =     1100
 * x - 1 = 1011
 * x & (x - 1) = 1000
 **/
public class Solution {
    /**
     * @param an integer
     * @return: True of False
     */
    public boolean checkPowerOf2(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
