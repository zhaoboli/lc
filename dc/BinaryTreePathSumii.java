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
 *思路：
 * 要找到所有解，想到搜索，写法跟深搜类似, 
 * 记录到达当前结点的路径，然后从后往前加/减，知道等于target，跟搜索的处理类似的点是完了之后也要从path里拿掉
 * 加进来的那个元素
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
     private void helper(TreeNode root, List<Integer> path, int level, int target, List<List<Integer>> result) {  
        if (root == null) {
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
     }  
 }

 /**
  * 2nd version, ugly
  */
public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        helper(root, 0, target, path, result);
        return result;
    }


    private void helper(TreeNode root, int level, int target, List<Integer> path, List<List<Integer>> result) {
        int sum = target;
        for (int i = level; i >= 0; i--) {
            sum -= path.get(i);
            if (sum == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                for (int j = i; j <= level; j++) {
                    ans.add(path.get(j));
                }
                result.add(ans);
            }
        }
        if (root.left != null) {
            path.add(root.left.val);
            helper(root.left, level + 1, target, path, result);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.right.val);
            helper(root.right, level + 1, target, path, result); 
            path.remove(path.size() - 1);
        }
    }

}

/** 
 * 3rd version, remove level, as it's same with path.size
 */
public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> path = new ArrayList<Integer>();
        helper(root, target, path, result);
        return result;
    }


    private void helper(TreeNode root, int target, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int sum = target;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum -= path.get(i);
            if (sum == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                for (int j = i; j < path.size(); j++) {
                    ans.add(path.get(j));
                }
                result.add(ans);
            }
        }
        helper(root.left, target, path, result);
        helper(root.right, target, path, result);
        path.remove(path.size() - 1);
    }

}
