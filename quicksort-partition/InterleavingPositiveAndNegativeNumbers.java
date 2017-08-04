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
 * 由上可见， 痛点是决定正和负，谁放第一, 然后还有其他边角问题很难考虑,这样看来原地排序很难解决这个问题
 
 * 既然如此，那么可以想到先把正负分开，（快排的partition）然后借助一个临时数组完成排序， 用类似归并排序的合并办法
 × 因为正多还是负多其实就是决定第一个先放谁，那么可以加一个判断逻辑，同时设计一个函数以“先” 和 “后” 的下标为参数
 */
class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
		if (A == null || A.length < 2) {
			return;
		}
		int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			while (left <= right && A[left] < 0) {
				left++;
			}
			while (left <= right && A[right] > 0) {
				right--;
			}
			if (left <= right) {
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
				left++;
				right--;
			}
		}
		//结束的时候left刚好过界，为第一个正数的下标
		if (left > (A.length - 1) / 2) {
			merge(A, 0, left, left, A.length);
		} else {
			merge(A, left, A.length, 0, left);
		}
    }
    private void merge(int[] A, int firstStart, int firstEnd, int secondStart, int secondEnd) {
	   int[] temp = new int[A.length];
	   int index = 0;
	   while (firstStart < firstEnd && secondStart < secondEnd) {
		   temp[index++] = A[firstStart++];
		   temp[index++] = A[secondStart++];
	   }
	   //此时至多还剩下一个数， 因此if即可
	   if (firstStart < firstEnd) {
		   temp[index] = A[firstStart++];
	   }
	   if (secondStart < secondEnd) {
		   temp[index] = A[secondStart++];
	   }
	   for (int i = 0; i < A.length; i++) {
		   A[i] = temp[i];
	   }
   }    
}