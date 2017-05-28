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
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    //solution one:
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int a = 0;
        int b = 0;

        while(nodeA.next != null) {
            nodeA = nodeA.next;
            a++;
        }

        while(nodeB.next != null) {
            nodeB = nodeB.next;
            b++;
        }
        
        if (nodeA != nodeB) {
            return null; 
        }

        if(a < b) {
            for (int i =0; i< b -a; i++) {
                headB = headB.next;
            }
        } else {
            for (int j = 0; j < a -b; j++) {
                headA = headA.next;
            }
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    //TODO Solution two:
}
