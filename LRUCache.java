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
        // write your code here
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
        // write your code here
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
        // write your code here
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