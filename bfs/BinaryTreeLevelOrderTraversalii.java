/**
 * Prob: binary-tree-level-order-traversal-ii No: 70
 * Given a binary tree, 
 * return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 return its bottom-up level order traversal as:
 *
 *[
 *  [15,7],
 *  [9,20],
 *  [3]
 *]
 * 思路：
 * bfs，插入的时候add(index, list)
 * 或者，全部插入完之后Collections.reverse()
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
    /*
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null ) {
            return result;
        }
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int curr = 0;
        while (curr < queue.size()) {
            int size = queue.size();
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = curr; i < size; i++) {
                TreeNode head = queue.get(curr++);
                ans.add(head.val);
                if (head.left != null) {
                    queue.add(head.left);
                }
                if (head.right != null) {
                    queue.add(head.right);
                }
            }
            result.add(0, ans);
        }
        return result;
    }
}
