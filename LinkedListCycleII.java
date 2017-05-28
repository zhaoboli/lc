/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * Given -21->10->4->5, tail connects to node index 1，return 10

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
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        HashSet<ListNode> hash = new HashSet<ListNode>();
        ListNode pointer = head;
        while(pointer != null) {
            if (!hash.contains(pointer)) {
                hash.add(pointer);
                pointer = pointer.next;
            } else {
                return pointer;
            }
        }
        return null;
    }

    public ListNode dectectCycleImpd(ListNOde head) {
        //slow = x + k + my; fast = x + k + ny -1
        //when meets: 2 * slow = fast, so x = (n-m)*y -(k+1) 
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        while (slow.next != head) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
