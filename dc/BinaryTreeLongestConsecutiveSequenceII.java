/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
     public int longestConsecutive2(TreeNode root) {
          if (root == null) {
              return 0;
          }
          ResultType res = helper(root);
          return longest;
      }

      private ResultType helper(TreeNode root) {
          if (root == null) {
              return new ResultType(0, 0);
          }
          int fromRoot = 1;
          int toRoot = 1;
          ResultType left = helper(root.left);
          ResultType right = helper(root.right);
          if (root.left != null) {
              if (root.left.val == root.val + 1) {
                  fromRoot = left.fromRoot + 1;
              }
              if (root.left.val + 1 == root.val) {
                  toRoot = left.toRoot + 1;
              }
          }
          if (root.right != null) {
              if (root.right.val == root.val + 1) {
                  fromRoot = Math.max(fromRoot, right.fromRoot + 1);
              }
              if (root.right.val + 1 == root.val) {
                  toRoot = Math.max(toRoot, right.toRoot + 1);
              }
          }
          longest = Math.max(longest, fromRoot + toRoot - 1);
          return new ResultType(fromRoot, toRoot);
      }

      private int longest;
      private class ResultType {
          public int fromRoot;
          public int toRoot;
          public ResultType (int fromRoot, int toRoot) {
              this.fromRoot = fromRoot;
              this.toRoot = toRoot;
          }
      }
}
