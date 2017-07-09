/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode (int x) { val = x;}
 * }
 */
public class Solution {
    //dc on july 9th
    private class ResultType {
        int fromRoot;
        int fromSub;
        public ResultType (int root, int sub) {
            this.fromRoot = root;
            this.fromSub = sub;
        }
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ResultType res = helper(root);
        return Math.max(res.fromRoot, res.fromSub);
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        int rootConsecutive = 1;
        int subConsecutive = 0;
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (root.left != null && root.val + 1 == root.left.val) {
            rootConsecutive = left.fromRoot + 1;
        }
        subConsecutive = Math.max(left.fromRoot, left.fromSub);

        if (root.right != null && root.val + 1 == root.right.val) {
            rootConsecutive = Math.max(rootConsecutive, right.fromRoot + 1);
        }
        subConsecutive = Math.max(subConsecutive, Math.max(right.fromRoot, right.fromSub));
        return new ResultType(rootConsecutive, subConsecutive);
    }

    // first time solution version
    private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        helper(root);
        return maxLength;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int consecutiveCount = 1;
        int left = helper(root.left);
        int right = helper(root.right);

        if (root.left != null && ((root.val + 1) == root.left.val)) {
            consecutiveCount = left + 1;
        }

        if (root.right != null && ((root.val + 1) == root.right.val)) {
            consecutiveCount = right + 1;
        }

        if (consecutiveCount > maxLength) {
            maxLength = consecutiveCount;
        }
        return consecutiveCount;
    }
}
