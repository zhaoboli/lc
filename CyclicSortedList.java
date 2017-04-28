package com.zhaobo;

/**
 * Created by Nate_Li on 4/28/2017.
 * Given a list, and insert a value 4:
 * 3->5->1 is a cyclic list, so 3 is next node of 1.
 3->5->1 is same with 5->1->3

 3->5->1
 Return 5->1->3->4
 */

public class CyclicSortedList {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            ListNode newNode = new ListNode(x);
            newNode.next= newNode;
            return newNode;
        }
        if (node.next == null) {
            ListNode newNode = new ListNode(x);
            node.next = newNode;
            newNode.next = node;
            return newNode;
        }
        ListNode head = node;
        // 1->3 first break
        // 5->1 -> 3  second break
        // 10->9->9->10 or 2->2->2 third break
        while (node.next != head) {
            if ((x > node.val && x < node.next.val) ||
                    (x > node.val && node.val > node.next.val && x > node.next.val) ||
                    (x == node.val )) {
                break;
            }
            node = node.next;
        }
        ListNode newNode = new ListNode(x);
        newNode.next = node.next;
        node.next = newNode;
        return newNode;
    }
}
