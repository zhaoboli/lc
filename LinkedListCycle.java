/**
 * Given a linked list, determine if it has a cycle in it.
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle (ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean res = false;
        while(fast != null) {
            if(fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast != null) {
                    res = (fast.val == slow.val);
                    if(res) {
                       return true;
                    } else {
                       continue;
                    } 
                    //error: return fast.val == slow.val;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public boolean hasCycleImpd(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != slow) {
            if(fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
