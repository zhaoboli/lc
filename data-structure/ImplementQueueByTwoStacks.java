/**
As the title described, you should only use two stacks to implement a queue's actions.
The queue should support 
push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
Both pop and top methods should return the value of first element.
*/

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
       // do initialization if necessary
	   stack1 = new Stack<Integer>();
	   stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
		stack1.push(element);
    }
	
	private void stack1ToStack2() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}

    public int pop() {
        // write your code here
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
		stack1ToStack2();
		return stack2.pop();
	}

    public int top() {
        // write your code here
		if (!stack2.isEmpty()) {
			return stack2.peek();
		}
		stack1ToStack2();
		return stack2.peek();
    }
}