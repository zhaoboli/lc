/**
 * Prob: subtree-with-maximum-average No: 597
 *
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 * LintCode will print the subtree which root is your return node.
 * It's guaranteed that there is only one subtree with maximum average.
 * Example: 
 * Given a binary tree:
 *
 *         1
 *       /   \
 *     -5     11
 *     / \   /  \
 *    1   2 4    -2 
 *   return the node 11.
 * 思路：
 * 分治，那么自顶向下,如果当前结点的avg大于最大值，那么此节点就是拥有最大平均值的子数
 */
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
    private class ResultType {
        public int sum;
        public int size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
    private TreeNode maxNode = null;
    private ResultType max = null;
	public TreeNode findSubtree2(TreeNode root) {
	    helper(root);
        return maxNode;
	}

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(left.sum + right.sum + root.val, 
        left.size + right.size + 1);
        if (max == null || max.sum * result.size < max.size * result.sum) {
            max = result;
            maxNode = root;
        }
        return result;
    }
}

