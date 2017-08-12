/**
 * Prob: rehashing No: 129
 *	The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:
 *	size=3, capacity=4
 *	[null, 21, 14, null]
 *	       ↓    ↓
 *	       9   null
 *	       ↓
 *	      null
 *	The hash function is:
 *	int hashcode(int key, int capacity) {
 *	    return key % capacity;
 *	}
 *	here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.
 *	rehashing this hash table, double the capacity, you will get:
 *	size=3, capacity=8
 *	index:   0    1    2    3     4    5    6   7
 *	hash : [null, 9, null, null, null, 21, 14, null]
 *	Given the original hash table, return the new hash table after rehashing .
 *	For negative integer in hash table, the position can be calculated as follow:
 *	C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
 *	Python: you can directly use -1 % 3, you will get 2 automatically.
 *	Example:
 *	Given [null, 21->9->null, 14->null, null],
 *	return [null, 9->null, null, null, null, 21->null, 14->null, null]
 * 思路：　
 * 把老表遍历一遍，然后根据元素的key % newcapacity 算出新的下标,有三点：
 *  1.老表上一点可能有多个元素相链
 *  2.新表要插的位置可能已有元素，这时候应插到新表这个位置的末端
 *  3. new node 要比直接挪现有的元素要简单些
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
 * TestCase: [null,null,42->32->null,-7->null,null]
 * [null,null,29->5->null]
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
     public ListNode[] rehashing(ListNode[] hashTable) {
        if(hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        int capacity = 2 * hashTable.length;
        ListNode[] newTable = new ListNode[capacity];
        //这样其实不如直接new新的ListNode来的直观
        for(int i = 0; i < hashTable.length; i++) {
            ListNode node = hashTable[i];
            while(node != null) {
                //声明一个临时的指针curr来暂存从老表拿出来的当前Node
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

    //这里用新ListNode, 而不是尝试改变老链表的结构
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        ListNode[] result = new ListNode[2 * hashTable.length];
        for (int i = 0; i < hashTable.length; i++) {
            //这里也开以不用curr,直接 hashTable[i]　= hashTable[i].next,反正没人care老的链表变成什么鬼
            ListNode curr = hashTable[i];
            while (curr != null) {
                int index = hash(curr.val, result.length);
                if (result[index] == null) {
                    result[index] = new ListNode(curr.val);
                } else {
                    ListNode top = result[index];
                    while (top.next != null) {
                        top = top.next;
                    }
                    top.next = new ListNode(curr.val);
                }
                curr = curr.next;
            }
        }
        return result;
    }
    private int hash(int key, int capacity) {
        return (key % capacity + capacity) % capacity;
    }
};
