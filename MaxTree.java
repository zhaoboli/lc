/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * [2, 5, 6, 0, 3, 1]
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree./
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
		if (A.length == 0 && A == null) {
			return null;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i <= A.length; i++) {
			TreeNode right = (i == A.length) ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
			while (!stack.isEmpty() && A[i] > stack.peek().val) {
				TreeNode curr = new TreeNode(A[i]);
			}
			stack.push(new TreeNode(A[i]));
		}
    }
}