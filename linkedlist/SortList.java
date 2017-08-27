/**
 * Prob: sort-list No: 98
 * sort a linked list in O(nlogn) time using constant space complexity
 * Example:
 * Given 1->3->2->null, sort it to 1->2->3->null.
 * 思路：
 * 这里用到归并排序的思想
 * 首先找到链表的中点，用快慢指针来做
 * 然后归并排链表的左右两边
 * 有几点需要注意：
 * 快排指针的初始化
 * 归并排序左和右的时候注意左边最后一个节点的next置空,这里有讨巧,和快慢指针的结合实现
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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        //左边最后一个节点的下指针放空
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if (left != null) {
            curr.next = left;
        }
        if (right != null) {
            curr.next = right;
        }
        return dummy.next;
    }
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        //快指针的初始化fast = head.next
        //这样的好处是慢指针偏左,这样在设置左边的尾指针为空更为方便,在单链表这种单向结构尤其方便
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //分割线 first tried version
    public ListNode sortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMidlle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left, right);
    }

    private ListNode findMidlle(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
                head = head.next;
            } else {
                head.next = right;
                right = right.next;
                head = head.next;
            }
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return dummy.next;
    }
}
