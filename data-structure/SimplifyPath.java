/**
 * Prob: Simplify Path No: 421
 * Given an absolute path for a file (Unix-style), simplify it.
 * "/home/", => "/home"
 * "/a/./b/../../c/", => "/c"
 * "/" => "/"
 * 思路：
 * 想到用栈，碰到..栈弹掉元素
 * 然后在recompose的时候发现其实还想从栈底先，这时候应该想到用ArrayList代替stack,因为可以用下标循环
 * 比较容易错的case "/.."
 */
 public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] input = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < input.length; i++) {
            if(input[i].isEmpty() || input[i].equals(".")) {
                continue;
            } else if (input[i].equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push("/" + input[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.size() == 0) {
            sb.append("/");
        }
        while (stack.size() > 0) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] input = path.split("/");
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].isEmpty() || input[i].equals(".")) {
                continue;
            } else if (input[i].equals("..")) {
                if (temp.size() > 0) {
                    temp.remove(temp.size() - 1);
                }
            } else {
                temp.add("/" + input[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (temp.size() == 0) {
            sb.append("/");
        }
        for (int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i));
        }
        return sb.toString();
    }
}
