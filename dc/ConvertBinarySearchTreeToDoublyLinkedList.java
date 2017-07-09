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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        DoublyListNode node = new DoublyListNode(root.val);
        DoublyListNode left = bstToDoublyList(root.left);
        DoublyListNode right = bstToDoublyList(root.right); 
        if (left != null) {
            while(left.next != null) {
                left = left.next;
            }
            left.next = node;
        }
        node.prev = left;

        if (right != null) {
            while (right.prev != null) {
                right = right.prev;
            }
            right.prev = node;
        }
        node.next = right;
        while (node.prev != null) {
           node = node.prev;
        } 
        return node;
    }
}
