/**
 * Prob: implement-stack-by-two-queues No: 494
 * Implement a stack by two queues. 
 * The queue is first in first out (FIFO). That means you can not directly poll the last element in a queue.
 
 * push(1)
 * pop()
 * push(2)
 * isEmpty() // return false
   top() // return 2
 * pop()
   isEmpty() // return true
  思路：
 　即使把一个队的搬到另外一个队，还是fifo，关键点还是最后插入的那个元素，那么可以把队里的元素扔到另外一个队里
 　直到还剩一个元素，pop把此元素弹出，top把此元素返回并放回另外一个队列，然后两队列互换，注意这里是引用互换
 */
public class Stack {
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    /*
     * @param x: An integer
     * @return: nothing
     */
    public void push(int x) {
        q1.offer(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        while (q1.size() >1) {
            q2.offer(q1.poll());
        }
        q1.poll();
        swap();
    }

    private void swap() {
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
    }

    /*
     * @return: An integer
     */
    public int top() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int ret = q1.poll();
        q2.offer(ret);
        swap();
        return ret; 
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
