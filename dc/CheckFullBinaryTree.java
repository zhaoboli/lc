A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes. 
Conversely, there is no node in a full binary tree, which has one child node. 

For example:
Given tree {1,2,3}, return true
Given tree {1,2,3,4}, return false
Given tree {1,2,3,4,5} return true

Full Binary Tree
      1
     / \
    2   3
   / \
  4   5

Not a Full Binary Tree
      1
     / \
    2   3
   / 
  4   
/**
 * Prob: check-full-binary-tree No: 726
 *
 */  
public class Solution {
    /*
     * @param : the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        // when it's leaf node, of only a root node, then by definination: it's a full binary tree
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return isFullTree(root.left) && isFullTree(root.right);
        }
        // when a node left has only one child
        return false;
    }
}