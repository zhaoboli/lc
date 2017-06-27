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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        ReturnType res = helper(root);
        return res.isBalanced;
    }

    private ReturnType helper(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        int depth = Math.max(left.depth, right.depth) + 1;
        return new ReturnType(left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <=1, depth);
    }

    private class ReturnType {
        private boolean isBalanced;
        private int depth;
        public ReturnType(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }
}
