/**
 * Prob: interleaving-positive-and-negative-numbers No: 144
 *
 * Given an array with positive and negative integers. 
 * Re-range it to interleaving with positive and negative integers.
 * You are not necessary to keep the original order of positive integers or negative integers.
 * Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] 
 * or any other reasonable answer.
 *
 * 思路：
 * 第一反应是用快排的partition， 因为只需二分， 但是有两个问题，以以下数据为例：
 * {28,2,-22,-27,2,9,-33,-4,-18,26,25,34,-35,-17,2,-2,32,35,-8}
 *　１： 如果第一个为负， 第二个为正。 那么快排partition过后会出现以下情况，那么负数标还只是指向３２，但正数已经结束，
 *　这个可以通过再加一个循环，看哪个指针还没到头来解决
 *　[-27,2,-22,28,-4,9,-33,2,-18,26,-17,34,-35,25,-2,2,32,35,-8]
 *　２：　但是，　即使换过来,会出现以下情况，那么也就是说这个输入起始是正数多，那么应该先排正数第一位
 * [-27,2,-22,28,-4,9,-33,2,-18,26,-17,34,-35,25,-2,2,-8,35,32]
 * 由上可见， 痛点是决定正和负，谁放第一, 然后还有其他边角问题很难考虑
 */
class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {

   }
}