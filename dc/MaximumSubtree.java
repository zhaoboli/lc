/**
 * Prob: maximum-subtree No: 628
 * Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.
 * Notice: it's guranteed that there is only one subtree with maximum sum and the given binary tree is not an empty tree
 * Example:
 * Given a binary tree:
 *        1
 *      /   \
 *    -5     2
 *    / \   /  \
 *   0   3 -4  -5
 *return the node with value 3.
 * 思路：
 * 二叉数，想到分治，那么一个节点的maxSubTreeNode可以是root(左子树sum + 右子树sum + root.val), Math.max(左子树maxSubTreeNode, 右子树maxSubtreeNode))
 * 如果这样设计分治的话,返回resultType(root.sum, maxSubTreeNode), 就会发现会写的很麻烦，细想下来其实我们只关心当前节点的sum是不是比maxSubTreeNode大，想到这里就简单了
 *　
 */
public class Solution {
    private TreeNode maxNode = null;
    pirvate maxSum = Integer.MIN_VALUE;
    /**
     * @param root the root of binary tree
     * @return the maxium weight node
     */
    public TreeNode findSubTree(TreeNode root) {
        if (root == null) {
            return root;
        } 
        helper(root);
        return maxNode;
    } 
    private int helper(TreeNode node) {
        if (root == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if (root.val + left + right > maxSum) {
            maxSum = root.val + left + right;
            maxNode = node;
        }
        return left + root.val + right;
    }
    
}

