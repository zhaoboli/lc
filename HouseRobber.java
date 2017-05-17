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

		long[] holder = new long[A.length + 1];
		holder[0] = 0;
		holder[1] = A[0];

		for( int i = 2; i <= A.length; i++) {
			holder[i] = Math.max(holder[i - 1], holder[i - 2] + A[i - 1]);
		}
		return holder[A.length];
    }
    //O(1) extra space
	public long houseRobberOn(int[] A) {
        // write your code here
      if (A == null || A.length == 0) {
   			return 0;
   		}
   		if (A.length == 1) {
   		    return A[0];
   		}
   		long[] holder = new long[2];
   		holder[0] = 0;
   		holder[1] = A[0];

   		for( int i = 2; i <= A.length; i++) {
   			holder[i%2] = Math.max(holder[(i - 1)%2], holder[(i - 2)%2] + A[i-1]);
   		}
   		return holder[A.length%2];
    }

}
