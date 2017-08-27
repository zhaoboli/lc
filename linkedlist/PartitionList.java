/**
 * Prob: partition-list No: 96
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * Given 1->4->3->2->5->2->null and x = 3, return 1->2->2->4->3->5->null.
 * 思路：
 * dummy 指针，没啥特别
 *
 */
 /**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode dummyBig = new ListNode(0);
        ListNode big = dummyBig;

        ListNode dummy = new ListNode(0);
        ListNode previous = dummy;
        dummy.next = head;
        while (head != null) {
            if (head.val >= x) {
                big.next = head;
                big = big.next;
                head = head.next;
                big.next = null;
            } else {
                previous.next = head;
                previous =  previous.next;
                head = head.next;
            }
        }
        previous.next = dummyBig.next;
        return dummy.next;
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null) {
            if (head.val >= x) {
                right.next = head;
                right = right.next;
            } else {
                left.next = head;
                left = left.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
   }
}
