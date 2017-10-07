/**
 * Prob: binary-tree-serialization No: 7
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * 
 * 思路：
 * 这里用ArrayList<>而非用Queue<>,是因为前者可以放空元素，那么在序列化的时候就更简单点，这个因为Queue<>这里的实现是LinkedList
 * Integer.parseInt and Integer.valueOf区别, valueOf internally calls parseInt
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
public static String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode head = queue.get(i);
            if (head == null) {
                continue;
            }
            queue.add(head.left);
            queue.add(head.right);
        }
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append('#');
            } else {
                sb.append(queue.get(i).val);
            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == "{}") {
            return null;
        }
        String trimedData= data.substring(1, data.length() - 1);
        String[] source = trimedData.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(source[0]));
        TreeNode head = root;
        boolean isLeftChild = true;

        for (int curr = 1; curr < source.length; curr++) {
            String s = source[curr];
            TreeNode node = null;
            if (!s.equals("#")) {
                node = new TreeNode(Integer.parseInt(s));
                queue.offer(node);
            }
            if (isLeftChild) {
                head.left = node;
            } else {
                head.right = node;
            }
            isLeftChild = !isLeftChild;
            if (isLeftChild) {
                head = queue.poll();
            }
        }
        return root;
    }
}
