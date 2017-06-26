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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        // if both A and B are found under one child of root, then lca is the child
        // A is found under left child and B is found under right child, then root
        // if root is A or B, if the other exists in one of the child, then root
        if (root == null) {
            return null;
        }
        return helper(root, A, B).node;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        ResultType res = new ResultType(false, false, null);
        if (root == null) {
            return res;
        }
        if (root == A) {
            res.isAFound = true;
        }
        if (root == B) {
            res.isBFound = true;
        }
        if (res.isAFound && res.isBFound) {
            return new ResultType(true, true, root);
        }

        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        if (left.isAFound && left.isBFound) {
            return left;
        }
        if (right.isAFound && right.isBFound) {
            return right;
        }
        res.isAFound = left.isAFound || right.isAFound || res.isAFound;
        res.isBFound = left.isBFound || right.isBFound || res.isBFound;
        if (res.isAFound && res.isBFound) {
            return new ResultType(true, true, root);
        }
        return res;
    }
    private class ResultType {
        public boolean isAFound;
        public boolean isBFound;
        public TreeNode node;
        public ResultType (boolean isAFound, boolean isBFound, TreeNode node) {
            this.isAFound = isAFound;
            this.isBFound = isBFound;
            this.node = node;
        }
    }
}
