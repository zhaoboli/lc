/** 
 * Prob: nested-list-weight-sum No: 551
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an  integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10)
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 42 + 63 = 27)
 * /
 /**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    Stack<NestedIntegerWithDepth> stack = null;
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        if (nestedList == null || nestedList.size() == 0) {
            return sum;
        }
        stack = new Stack<NestedIntegerWithDepth>();
        addListToStack(nestedList, 1);
        while (!stack.isEmpty()) {
            NestedIntegerWithDepth head = stack.pop();
            if (head.nestedInteger.isInteger()) {
                sum += head.nestedInteger.getInteger() * head.depth ;
            } else{
                addListToStack(head.nestedInteger.getList(), head.depth + 1);
            }
        }
        return sum;
    }
    
    private void addListToStack(List<NestedInteger> list, int Depth) {
        for (NestedInteger ni: list) {
            stack.push(new NestedIntegerWithDepth(ni, Depth));
        }
    }
    
    private class NestedIntegerWithDepth {
        public NestedInteger nestedInteger = null;
        public int depth = 0;
        public NestedIntegerWithDepth(NestedInteger ni, int depth) {
            this.nestedInteger = ni;
            this.depth = depth;
        }
    }
}