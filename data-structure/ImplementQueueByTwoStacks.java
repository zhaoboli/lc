/**
 *  Prob: implement-queue-by-two-stacks No: 40
 *  As the title described, you should only use two stacks to implement a queue's actions.
 *  The queue should support 
 *  push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 *  Both pop and top methods should return the value of first element.
 * push(1)
 * pop()     // return 1
 * push(2)
 * push(3)
 * top()     // return 2
 * pop()     // return 2
 *
 *  思路：
 *  栈ａ放元素，栈ａ的元素放入栈ｂ,然后出栈，那么出的顺序就是fifo,
 *  栈ｂ作为缓存栈，如果栈ｂ有元素，那么这些元素
 *  肯定是先进来的，就要先出
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
		stack1.push(element);
    }
	
	private void stack1ToStack2() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}

    public int pop() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
		stack1ToStack2();
		return stack2.pop();
	}

    public int top() {
		if (!stack2.isEmpty()) {
			return stack2.peek();
		}
		stack1ToStack2();
		return stack2.peek();
    }
}
