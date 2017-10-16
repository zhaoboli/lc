/**
 * Prob: count-1-in-binary No: 365
 * Count how many 1 in binary representation of a 32-bit integer.
 * Example: Given 32, return 1
 * Given 5, return 2
 * Given 1023, return 9
 * 思路：
 * num & (num -1) 去掉最右边的一个1, 去到没有1为止
 */
public class Solution {
	/*
	 * @param num: An integer
	 * return: An integer
	 */
	public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }        
        return count;
	}
}
