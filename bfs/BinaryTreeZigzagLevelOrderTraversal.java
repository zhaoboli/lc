/**
 * Prob: binary-tree-zigzag-level-order-traversal No: 71
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for  * the next level and alternate between).
 * Given binary tree {3,9,20,#,#,15,7},

 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 *  return its zigzag level order traversal as:
 *
 *   [
 *     [3],
 *     [20,9],
 *     [15,7]
 *   ]
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
 * 思路：
 * bfs,设置一个是否翻转的标识位
 */
public class Solution {
    /*
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
           return result;
        } 
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                ans.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null ) {
                    queue.offer(head.right);
                }
            }
            if (reverse) {
                Collections.reverse(ans);
            }
            reverse = !reverse;
            result.add(ans);
        }
        return result;
    }
}
