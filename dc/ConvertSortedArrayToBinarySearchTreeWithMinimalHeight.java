Prob: convert-sorted-array-to-binary-search-tree-with-minimal-height No: 177

Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height


Given [1,2,3,4,5,6,7], return

     4
   /   \
  2     6
 / \    / \
1   3  5   7

Use Array to represent a binary tree: 
i as the index of the element in the array, parent: (i - 1) / 2; left child: i * 2 + 1, right child: i * 2 + 2;

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
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        return helper(A, 0, A.length - 1);
    }
    
    private TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = helper(A, start, mid -1);
        node.right = helper(A, mid + 1, end);
        return node;
    }
}