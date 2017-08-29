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

    //归并排序的做法，分治
    //top down 自顶向下
    //logk 层， 每层合并耗费N, O(Nlogk)
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.size() - 1);
    }
    private ListNode mergeList(List<ListNode> lists, int start, int end) {
        if (start >= end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeList(lists, start, mid);
        ListNode right = mergeList(lists, mid + 1, end);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left != null & right != null) {
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
}
