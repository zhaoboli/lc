/**
 * given two 32-bit numbers, N and M, and two bit positions, i and j. 
 * Write a method to set all bits between i and j in N equal to M 
 * (e g , M becomes a substring of N located at i and starting at j)
 * In the function, the numbers N and M will given in decimal, you should also return a decimal number.
 * Clarification
 * You can assume that the bits j through i have enough space to fit all of M. That is, if M=10011，
 * you can assume that there are at least 5 bits between j and i. 
 * You would not, for example, have j=3 and i=2, because M could not fully fit between bit 3 and bit 2.
 * Example
 * Given N=(10000000000)2, M=(10101)2, i=2, j=6
 * return N=(10001010100)2
 *
 * 思路：
 * 1.首先把ｎ的第i到第j位设置为０, 
 * 2. 然后和 M << i 做或运算即可
 * 把n的第i到第j置0, 直观的想法，一个i到j都为0,其他都为1的数,然后和n做与运算 
 * 那么可以把一个i到j都为1的数取反就能得到, 那么可以先把(-1)向左移(31-j)，那么从j+1 到31就都被干掉了
 * 然后再逻辑右移31-j+i,这样就把前i位干掉， 然后再左移i位就完成这个数的组建
 * 把这个数取反就得到一个i到j都为0，其他都为1的数, 和n做与运算，就把n的i到j设置为0
 *
 **/
 class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        return ((m << i) | (~(((-1 << (31-j)) >>> (31-j+i)) << i) & n));
    }
}
