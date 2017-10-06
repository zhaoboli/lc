/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 * Prob: binary-tree-path-sum-iii No: 472
 * 思路：
 * 1.要拿到所有的解，想到用搜索，搜索的方向可能有三种，向上向左向右，
 * 因为可以向上那么有可能会绕回路，可以用一个from(表示当前搜索是从哪个节点来的),如果要去的节点跟来的点是同一个节点，就跳过
 * 2.因为可以从任一节点出发到任一节点结束，那么可以用分治自顶向上的开始初始化搜索 
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, target, result);
        return result;
    }
    //any node can be the starting point
    private void helper(ParentTreeNode root, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        List<Integer> path = new ArrayList<Integer>();
        findSum(root, null, target, path, result);
        //devide and conquer, top down, any node on the tree can be the starting node
        helper(root.left, target, result);
        helper(root.right, target, result);
    }
    //for any Node, path find can have 3 directions, parent, leftChild, rightChild
    private void findSum(ParentTreeNode root, ParentTreeNode from, int target, List<Integer> path, List<List<Integer>> result) {
        path.add(root.val);
        target -= root.val;
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
        }
        // to avoid going back
        if (root.parent != null && root.parent != from) {
            findSum(root.parent, root, target, path, result);
        }
        if (root.left != null && root.left != from) {
            findSum(root.left, root, target, path, result);
        }
        if (root.right != null && root.right != from) {
            findSum(root.right, root, target, path, result);
        }
        path.remove(path.size() - 1);
    }
}
