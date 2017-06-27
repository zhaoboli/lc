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
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		//as the problems alreay indicates that Assume two nodes are exist in tree.
		//The above assumption is quite strong, hence this way to implement it, as otherwise this 
		//implementation will not be correct, and we need to consider both A and B are found or not
		if (root == null) {
			return null;
		}
		if (root == A || root == B) {
			return root;
		}
		TreeNode leftRes = lowestCommonAncestor(root.left, A, B);
		TreeNode rightRes = lowestCommonAncestor(root.right, A, B);
		
		if (leftRes != null && rightRes != null) {
			return root;
		}
		if (leftRes != null) {
			return leftRes;
		}
		if (rightRes != null) {
			return rightRes;
		}
		return null;
    }
}