/**
* Given a sorted linked list, delete all duplicates such that each element appear only once
* Given 1->1->2, return 1->2.
*

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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val == pre.val) {
                curr = curr.next;
            } else {
                pre.next = curr;
                pre = pre.next;
                curr = curr.next;
            }
        }
        pre.next = curr;
        return dummy.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
