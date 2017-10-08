/** 
 * Prob: flatten-nested-list-iterator No: 528
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Given the list [[1,1],2,[1,1]], 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,4,6].
 * 思路：
 * 这里有嵌套(递归)，用两个栈来实现，每次如果栈头是个list就把它弹出，拆解之后再入栈，直到栈头是个integer为止
 */
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
public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        pushElementToStack(nestedList);
    }
    
    private void pushElementToStack(List<NestedInteger> list) {
        Stack<NestedInteger> temp = new Stack<NestedInteger>();
        Iterator<NestedInteger> iterator = list.iterator();
        while (iterator.hasNext()) {
            NestedInteger ni = iterator.next();
            if (!ni.isInteger() && ni.getList().size() == 0) {
                continue;
            }
            temp.push(ni);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushElementToStack(stack.pop().getList());
        } 
        return !stack.isEmpty();
    }
}
 
