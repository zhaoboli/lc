public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (!minStack.isEmpty()) {
            minStack.push(Math.min(minStack.peek(), number));
        } else {
            minStack.push(number);
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
