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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
     public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
         if (root == null) {
             return result;
         }
         ArrayList<Integer> path = new ArrayList<Integer>();
         int level = 0;
         //因为此处要求寻找所有解，联想到搜索
         helper(root, path, 0, target, result);
         return result;
     }
     private void helper(TreeNode root, List<Integer> path, int level, int target, List<List<Integer>> result) {  if (root == null) {
             return;
         }
         path.add(root.val);
         int sum = target;
         for (int i = level; i >= 0; i--) {
             //向后翻看
             sum -= path.get(i);
             if (sum == 0) {
                 ArrayList<Integer> answer = new ArrayList<Integer>();
                 for (int j = i; j <= level; j++) {
                     answer.add(path.get(j));
                 }
                 result.add(answer);
                 //注意此处不能break,否则可能会漏解
             }
         }
         helper(root.left, path, level + 1, target, result);
         helper(root.right, path, level + 1, target, result);
         //此处清理当前节点, 搜索处理手法
         path.remove(path.size() - 1);
     }  }
