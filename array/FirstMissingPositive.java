/**
 * Prob: first-missing-positive No: 189
 
 * Given an unsorted integer array, find the first missing positive integer.
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 × 思路：
 *　因为要求Ｏ(n)的时间，还有constant的space，那么快排和hash表都被否决掉了，如果是桶排序，空间又不满足
 *　因此想到原地排序，　这个时候可以用数组ｉｎｄｅｘ做ｈａｓｈ
 */
public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
        //First postion number for an empty array is 1
			return 1;
		}
		for (int i = 0; i < A.length; i++) {
		//如果当前数A[i]大于等于1，那么将它放置于index:A[i] -1; 
		//如果输入[0, 2, -1, 3]
		//放完之后就是[0, 2, 3, -1]
			while (A[i] > 0 && A[i] <= A.length && A[A[i] -1] != A[i] ) {
				swap(A, i, A[i] -1);
			}
		}
		for (int i = 0; i < A.length; i++) {
		//如果当前数不是当前数的index+1,那么它就是不合规则的数，第一个即为我们要找的数
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		//for array [1, 2, 3, 4], the first missing number is 5
		return A.length + 1;
    }
    
	private void swap(int[] A, int left, int right) {
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;		
	}
}