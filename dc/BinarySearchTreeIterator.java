/**
 * Prob: binary-search-tree-iterator No: 86
 * Design an iterator over a binary search tree with the following rules:
 * Elements are visited in ascending order (i.e. an in-order traversal)
 * next() and hasNext() queries run in O(1) time in average.
 *
 * For the following binary search tree, in-order traversal by using iterator is 
 * [1, 6, 10, 11, 12]
 *    10
 *	/    \
 *	1      11
 *	 \       \
 *	  6       12
 *
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    private TreeNode next = null;
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    /*
    * @param root: The root of binary tree.
    */
    public BSTIterator(TreeNode root) {
        next = root; 
    }
    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        if (next != null ) {
            addNodeToStack(next);
        }
        return !stack.isEmpty();
    }

    private void addNodeToStack(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        next = node;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        if (!hasNext()) {
            return null;
        }
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            next = curr.right;
        }
        return curr; 
    }
}
