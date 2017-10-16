/** 
 * Prob: a-b-problem No: 1
 * Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
 * There is no need to read data from standard input stream. 
 * Both parameters are given in function aplusb, you job is to calculate the sum and return it.
 * 
 * Are a and b both 32-bit integers?
 * Yes.
 * Can I use bit operation?
 * Sure you can.
 * Example
 * Given a=1 and b=2 return 3
 */
public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;        
            a = _a;
            b = _b;
        }
        return a;
    }
};
