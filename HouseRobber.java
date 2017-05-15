public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    

	//O(n) space complexity
	public long houseRobberOn(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
			return 0;
		}
		if (A.length == 1) {
		    return A[0];
		}
		if (A.length == 2){
		    return Math.max(A[0], A[1]);
		}
		
		long[] holder = new long[A.length];		
		holder[0] = A[0];
		holder[1] = Math.max(A[0], A[1]);
		
		for( int i = 2; i < A.length; i++) {
			holder[i] = Math.max(holder[i - 1], holder[i - 2] + A[i]);
		}
		return holder[A.length - 1];
    }	
}