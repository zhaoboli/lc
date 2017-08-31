/**
 * Prob: add-two-numbers-ii No: 221
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in forward order,
 * such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * Example
 * Given 6->1->7 + 2->9->5. That is, 617 + 295.
 * Return 9->1->2. That is, 912.
 * 思路：
 * 先把链表反转，然后相加，让sum/10, 剩下的数放当前节点，sum/10往前进
 */

/**
 * Definition for singly-linked list.
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
    /*
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode tail1 = reverseLinkedList(l1);
        ListNode tail2 = reverseLinkedList(l2);
        int next = 0;
        int remainder = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (tail1 != null && tail2 != null) {
            int sum = tail1.val + tail2.val + next;
            remainder = sum % 10;
            next = sum / 10; 
            ListNode node = new ListNode(remainder);
            tail.next = node;
            tail = tail.next;
            tail1 = tail1.next;
            tail2 = tail2.next;
        }
        while (tail1 != null) {
            int sum = tail1.val + next;
            remainder = sum % 10;
            next = sum / 10;
            ListNode node = new ListNode(remainder);
            tail.next = node;
            tail = tail.next;
            tail1 = tail1.next;
        }
        while (tail2 != null) {
            int sum = tail2.val + next;
            remainder = sum % 10;
            next = sum / 10;
            ListNode node = new ListNode(remainder);
            tail.next = node;     
            tail = tail.next;
            tail2 = tail2.next;
        }
        if (next > 0) {
            ListNode node = new ListNode(next); 
            tail.next = node;
        }
        return reverseLinkedList(dummy.next);
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
