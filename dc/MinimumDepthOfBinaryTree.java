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
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftMin = 0;
        int rightMin = 0;

        if (root.left != null) {
            leftMin = minDepth(root.left) + 1;
        }
        if (root.right != null) {
            rightMin = minDepth(root.right) + 1;
        }

        if (leftMin > 0 & rightMin > 0) {
            return Math.min(leftMin, rightMin);
        } else {
            return Math.max(leftMin, rightMin);
        }
    }
}
