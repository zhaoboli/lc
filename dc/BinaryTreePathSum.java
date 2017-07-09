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
    //July 9th version
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        helper(root, path, 0, target, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> path, int cur, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        cur = cur + root.val;
        //因为要找到叶子节点，此处未考虑到
        if (cur == target && root.left == null && root.right == null) {
            //忘掉深拷贝 
            ArrayList<Integer> answer = new ArrayList<Integer>();
            answer.addAll(path);
            result.add(answer);
        }
        helper(root.left, path, cur, target, result);
        helper(root.right, path, cur, target, result);
        path.remove(path.size() - 1);
    }

    //first version
    /**
         * @param root the root of binary tree
         * @param target an integer
         * @return all valid paths
         */
        private List<List<Integer>> result = new ArrayList();

        public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
            // Write your code here
            if (root == null) {
                return result;
            }

            ArrayList<Integer> holder = new ArrayList<Integer>();

            helper(root, holder, 0, target);
            return result;

        }

        private void helper(TreeNode root, ArrayList<Integer> holder, int sum, int target) {
            if (root == null) {
                return;
            }

            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(holder);
            temp.add(root.val);
            sum = sum + root.val;

            if (root.left == null && root.right == null && sum == target) {
                result.add(temp);
            }

            helper(root.left, temp, sum, target);
            helper(root.right, temp, sum, target);

        }

  }
