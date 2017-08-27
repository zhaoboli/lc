/**
 * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
 * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * 思路： 
 * find the mid 找到中点 
 * reverse the right 反转右边
 * merge 两个链表合并
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
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; 
        int index = 0;
        while (head != null && right != null) {
            if (index % 2 == 0) {
                curr.next = head;
                head = head.next; 
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
            index++;
        }
        if (head != null) {
            curr.next = head;
        }
        if (right != null) {
            curr.next = right;
        }
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head; 
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
