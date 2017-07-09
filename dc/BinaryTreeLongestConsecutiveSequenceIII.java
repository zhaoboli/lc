/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root).longestLen;
    }

    private ResultType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        int fromRoot = 1;
        int toRoot = 1;
        int longestLen = 1;

        if (root.children == null || root.children.size() == 0) {
            return new ResultType(fromRoot, toRoot, longestLen);
        }

        for (MultiTreeNode node: root.children) {
            ResultType res = helper(node);
            if (root.val + 1 == node.val) {
                fromRoot = Math.max(fromRoot, res.fromRoot + 1);
            }
            if(root.val == node.val + 1) {
                toRoot = Math.max(toRoot, res.toRoot + 1);
            }
            longestLen = Math.max(longestLen, res.longestLen);
        }
        longestLen = Math.max(fromRoot + toRoot - 1, longestLen);
        return new ResultType (fromRoot, toRoot, longestLen);
    }


    private class ResultType {
        int fromRoot;
        int toRoot;
        int longestLen;

        public ResultType (int fromRoot, int toRoot, int longestLen) {
            this.fromRoot = fromRoot;
            this.toRoot = toRoot;
            this.longestLen = longestLen;
        }
    }
}
