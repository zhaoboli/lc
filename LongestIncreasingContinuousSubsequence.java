public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
			return 1;
		}
		
		int max = 0;
		int length = 1;		
		for (int i = 1 ; i < A.length; i++) {
			if (A[i] > A[i-1]) {
				length++;
			} else {
				length = 1;
			}
			max = Math.max(max, length);
		}
		for (int i = A.length - 2; i >= 0; i--) {
			if (A[i] > A[i+1]) {
				length++;
			} else {
				length = 1;
			}
			max = Math.max(max, length);
		}
		return max;
    }
}