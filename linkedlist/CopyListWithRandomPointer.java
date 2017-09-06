/**
 * Prob: copy-list-with-random-pointer No: 105
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode existingDummy = new RandomListNode(0);
        existingDummy.next = head;

        RandomListNode newDummy = new RandomListNode(0);
        RandomListNode curr = newDummy;
        HashMap<Integer, RandomListNode> hash = new HashMap<Integer, RandomListNode>();

        while (head != null) {
            RandomListNode node = new RandomListNode(head.label);
            if(newDummy.next == null) {
                newDummy.next = node;
            }
            hash.put(node.label,node);
            curr.next = node;
            curr = curr.next;
            head = head.next;
        }

        head = existingDummy.next;
        curr = newDummy.next;

        while (head !=null) {
            if (head.random != null) {
                curr.random = hash.get(head.random.label);
            }
            head = head.next;
            curr = curr.next;
        }
        return newDummy.next;
    }
}
