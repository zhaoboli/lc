/**
 * Prob: remove-duplicates-from-sorted-list No: 113
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 思路：
 * 如果出现 1-> 1> -> 1，那么就是null, 因此除了比上两个数，还有记录上一次指针prev,
 * 像本题中的情况，自然想到再加一层循环去重
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //因为去重要往前看两位，而甚至头也不能保留 
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev  = dummy;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                int val = curr.val;    
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
