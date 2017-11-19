/*
 * Prob: insert-into-a-cyclic-sorted-list No:
 * 插入一个新的节点到一个sorted cyclic linkedlist (升序），返回新的节点. 所给定的节点不一定是最小节点
 * 思路：
 * 两种情况，1. 如果x正好能放在curr和next之间
 * 2.如果x正好能放在链表的首尾相接处
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
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        if (node == null) {
            ListNode newNode = new ListNode(x);
            newnode.next = newnode;
            return newNode;
        }

        ListNode head = node;
        ListNode next = node.next;
        do {
            //如果x正好>= curr && <= next
            if (x >= node.val && x <= next.val) {
                break;
            } 
            //如果x正好能放在链表的首尾连接处, 即是x>最大的，或者说x<最小的
            if (node.val > next.val && (x > node.val || x < next.val) {
                break;
            }
            node = node.next;
            next = next.next;
        } while (node != head)

        //涵盖了如果正好只有一个元素
        ListNode newnode = new ListNode(x);
        node.next = newnode;
        newnode.next = next;
        return newnode;
    }
}
