/**
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

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
        // write your code here
        if (lists == null || lists.size() == 0) {
			return null;
		}
		
		Queue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {
				return n1.val - n2.val;
			}
		});
		
		for (int i = 0; i < lists.size(); i++) {
			ListNode node = lists.get(i);
			while(node != null) {
				queue.offer(node);
				node = node.next;
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(!queue.isEmpty()) {
			ListNode node = queue.poll();
			head.next = node;
			head = head.next;
		}
		head.next = null;
		
		return dummy.next;
    }
}