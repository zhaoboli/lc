/**
 * Prob: lru-cache No: 134
 */

public class Solution {

    private class Node {
		public int key;
		public int value;
		public Node previous;
		public Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private HashMap<Integer, Node> map;
	private int max_capacity;
	private int cur_capacity;
	Node head;
	Node tail;

    // @param capacity, an integer
    public Solution(int capacity) {
		map = new HashMap<Integer, Node>();
		this.max_capacity = capacity;
		this.cur_capacity = 0;
		head = new Node(-1, -1);
		tail = new Node(-1, -1);

		head.next = tail;
		tail.previous = head;
    }

    // @return an integer
    public int get(int key) {
		// every get, we need to prmote the node to the head unless it's the head
		if (head.next == map.get(key)) {
			return head.next.value;
		}
	    if (map.get(key) == null) {
	        return -1;
	    }
		//relink the cut spot
		Node target = map.get(key);
		target.previous.next = target.next;
		target.next.previous = target.previous;

		moveToHead(target);
		return target.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
		//if key is found, update the value
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
		cur_capacity++;
		Node newNode = new Node(key, value);
		if (cur_capacity > max_capacity) {
			//evict the least used node, relink the tail part and delete from map
			Node last = tail.previous;
			tail.previous.previous.next = tail;
			tail.previous = tail.previous.previous;
			map.remove(last.key);
		}
		moveToHead(newNode);
		map.put(key, newNode);
    }

    private void moveToHead(Node node) {
        node.next = head.next;
		node.next.previous = node;
		head.next = node;
		node.previous = head;
    }
}
//Aug-12 version
//犯的错误: evict　尾部元素的时候忘了删hash表, 忘了update counter, 同时也发现声明Node的时候刚开始漏掉了key
public class LRUCache {
    private class DoublyLinkedListNode {
        int val;
        int key;
        DoublyLinkedListNode previous;
        DoublyLinkedListNode next;
        public DoublyLinkedListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.previous = null;
            this.next = null;
        }
    }
    Map<Integer, DoublyLinkedListNode> map = null;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int capacity;
    private int counter;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, DoublyLinkedListNode>();
        this.head = new DoublyLinkedListNode(0, 0);
        this.tail = new DoublyLinkedListNode(0, 0);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        moveToHead(key);
        return map.get(key).val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            moveToHead(key);
            return;
        }
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
        map.put(key, newNode);
        if (counter == capacity) {
            int rmkey = tail.previous.key;
            tail.previous.previous.next = tail;
            tail.previous = tail.previous.previous;
            map.remove(rmkey);
            counter--;
        }
        newNode.next = head.next;
        head.next.previous = newNode;
        newNode.previous = head;
        head.next = newNode;
        counter++;
    }

    private void moveToHead(int key) {
        DoublyLinkedListNode targetNode = map.get(key);
        if (targetNode.previous == head) {
            return;
        }
        targetNode.previous.next = targetNode.next;
        targetNode.next.previous = targetNode.previous;
        targetNode.next = head.next;
        head.next.previous = targetNode;
        targetNode.previous = head;
        head.next = targetNode;
    }
}
