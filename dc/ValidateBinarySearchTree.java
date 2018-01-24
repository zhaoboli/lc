Prob: validate-binary-search-tree No: 95

Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST

Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

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

//version: 思路：中序遍历之后应该是递增的
public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (previous != null && previous.val >= root.val) {
            return false;
        }
        previous = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
    private TreeNode previous;
}
//version: 对于某一个点来讲，当前节点的值总是大于左子树的最大值，小于右子树的最小值
public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root).isValid; 
    }

    private ResultType isValid(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultType left = isValid(root.left);
        ResultType right = isValid(root.right);
        if (!left.isValid || !right.isValid) {
            return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        if ((root.left != null && root.val <= left.maxValue) || (root.right != null && root.val >= right.minValue)) {
            return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
    }
    
    private class ResultType {
        public boolean isValid;
        public int maxValue;
        public int minValue;
        public ResultType(boolean isValid, int maxValue, int minValue) {
           this.isValid = isValid;
           this.maxValue = maxValue;
           this.minValue = minValue;
        }
    }
}
