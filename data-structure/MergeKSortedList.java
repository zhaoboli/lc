/**
 * Prob: merge-k-sorted-lists No: 104
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.

Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
			return null;
		}
		
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});
        
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        //假如总共有n个点的话，那么复杂度是nlogk
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            tail.next = min;
            if (min.next != null) {
                queue.offer(min.next);
            }
            tail = tail.next;
        }
        return dummy.next;
    }
}
