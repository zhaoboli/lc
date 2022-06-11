/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
geeks for geeks solution
https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/?currentPage=1&orderBy=recent_activity&query=

https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments

https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/1577794/Java-100-faster-solution
 */

public class Solution {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int curr = 0;

    }

    private ListNode reverseNodes(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;

        int i = 0;
        ListNode prev = null;
        while (head != null && i < n) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return head;
    }
}
