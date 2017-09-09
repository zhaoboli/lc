/**
 * Prob: copy-list-with-random-pointer No: 105
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * 思路：
 * 联想到用hashmap,关键要用已有的listnode做key,映射新的listnode
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
    //correct version
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curr = dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        while (head != null) {
            RandomListNode node = map.get(head);
            if (node == null) {
                node = new RandomListNode(head.label);
                map.put(head, node);
            }
            if (head.random != null) {
                RandomListNode random = map.get(head.random);
                if (random == null) {
                    random = new RandomListNode(head.random.label);
                    map.put(head.random, random);
                }
                node.random = random;
            }
            curr.next = node;
            curr = curr.next;
            head = head.next;
        }
        return dummy.next;
    }
}
