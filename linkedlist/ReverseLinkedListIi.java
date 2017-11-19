/**
 * Prob: reverse-linked-list-ii No: 36
 * Reverse a linked list from position m to n
 * Given m, n satisfy the following condition: 1 <= m <=n <= length of list
 * example
 * given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 *
 * 思路：
 * 有一段需要reverse,那么如果找到是哪一段，那么对此段就行reverse,接下来的就是要拼接
 * 那么有四个点，在reverse之前的一点，在以下解法中就是 beforeReverse, 需要和reverse完之后的头(previous)点连接
 * reverse该段的尾点(tail点)要和 没有reverse完的第一个点(current)进行拼接
 *
 */
/**
 * Definition for ListNode
 * public class ListNode {
 *
 *  int val
 *  ListNode next;
 *  ListNode (int x) {
 *      val = x;
 *      next = null;
 *      }
 *  }
 */
public class Solution {
    /*
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null ) {
            return head;
        }         
        int currIndex = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode beforeReverse = dummy;
        while (currIndex < m) {
            beforeReverse = head;
            head = head.next;
            currIndex++;
        }
        //tail of the reversed section
        ListNode tail = head;
        ListNode previous = null;
        ListNode current = head;
        while (currIndex <= n) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
            currIndex++;
        } 
        tail.next = current;
        beforeReverse.next = previous;
        return dummy.next;
    }

    //official ans
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
    }
}
