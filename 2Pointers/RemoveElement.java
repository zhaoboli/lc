/**
 * Prob: remove-element No: 172
 * Given an array and a value, remove all occurrences of that value in place and return the new length
 * The order of elements can be changed, and the elements after the new length don't matter.
 * Given an array [0,4,4,0,0,2,4,4], value=4
 * return 4 and front four elements of the array is [0,0,0,2]
 * 思路：
 × 跟movezeros 相似， 因此用movezeros的方法可以做，会不会超时要另说
 *　优化的思路，因为不讲究order，可以两根指针partition
 */
public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
		int slow = 0;
		int fast = 0;
		while (fast < A.length) {
			if (A[fast] != elem) {
				int temp = A[fast];
				A[fast] = A[slow];
				A[slow] = temp;
				//错点，fast已经在外加过
				//fast++;
				slow++;
			}
			fast++;
		}
		return slow;
    }
	
	public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
		int right = A.length - 1;
		while (left <= right) {
			while (left <= right && A[right] == elem) {
				right--;
			}
			while (left <= right && A[left] != elem) {
				left++;
			}
			if (left <= right) {
				int temp = A[right];
				A[right] = A[left];
				A[left] = temp;
				left++;
				right--;
			}
		}
		return left;
    }
	
	public int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int left = 0;
		int right = A.length - 1;
		//注意此时<=, 比如[0, 0, 0, 4]
		while (left <= right) {
			if (A[left] == elem) {
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
				right--;
			} else {
				left++;
			}
		}
		return right + 1;
	}
}
