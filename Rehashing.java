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
 * TestCase: [null,null,42->32->null,-7->null,null]
 * [null,null,29->5->null]
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
     public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        int capacity = 2 * hashTable.length;
        ListNode[] newTable = new ListNode[capacity];

        for(int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while(node != null) {
                ListNode curr = node;
                node = node.next;
                curr.next = null;
                int newIndex = mod(curr.val, capacity);
                if(newTable[newIndex] != null) {
                    ListNode dummy = newTable[newIndex];
                    //Missed point
                    while(dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = curr;
                } else {
                    newTable[newIndex] = curr;
                }
            }
        }
        return newTable;
    }

    private int mod(int a, int b) {
        return (a % b + b) % b;
    }
};
