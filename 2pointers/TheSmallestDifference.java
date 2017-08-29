/**
 * Prob: the-smallest-difference No: 387
 *
 * Given two array of integers(the first array is array A, the second array is array B), 
 * now we are going to find a element in array A which is A[i], 
 * and another element in array B which is B[j], 
 * so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, 
 * return their smallest difference.
 * For example, given array A = [3,6,7,4], B = [2,8,9,3], return 0
 * 
 * 思路：
 × 把 A,B 排序， 然后 比较a[i], b[j], 如果a[i]大，增b，同理
 */
 public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
			return -1;
		}
		Arrays.sort(A);
		Arrays.sort(B);
		int ai = 0;
		int bi = 0;
		int min = Integer.MAX_VALUE;
		while (ai < A.length && bi < B.length) {
			min = Math.min(min, Math.abs(A[ai] - B[bi]));
			if (A[ai] - B[bi] > 0) {
				bi++;
			} else {
				ai++;
			}
		}
		return min;
    }
}