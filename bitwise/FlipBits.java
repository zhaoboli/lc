/**
 * Prob: flip-bits No: 181
 * Determine the number of bits required to flip if you want to convert integer n to integer m
 * Note: both n and m are 32-bit integers
 * Given n = 31 (11111), m = 14 (01110), return 2.
 * 思路：
 * 如果两个位不一样，需要换，首先联想到xor，那么只需要xor后count bits就好
 */
public class Solution {
    /*
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public int bitSwapRequired(int a, int b) {
        return bitCount(a ^ b);
    }

    private int bitCount(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
