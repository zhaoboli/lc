/**
Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, 
find the median of the element inside the window at each moving. 
(If there are even numbers in the array, return the N/2-th number after sorting the element in the window. )
Example
For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]
At first the window is at the start of the array like this
[ | 1,2,7 | ,8,5] , return the median 2;
then the window move one step forward.
[1, | 2,7,8 | ,5], return the median 7;
then the window move one step forward again.
[1,2, | 7,8,5 | ], return the median 7;
*/

public class Solution {
	TreeSet<Node> minHeap;
	TreeSet<Node> maxHeap;
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length ==0) {
            return result;    
        }
		this.minHeap = new TreeSet<Node>();
		this.maxHeap = new TreeSet<Node>();
		int halfK = (k + 1) / 2;
		for (int i = 0; i < k -1; i++) {
			Node node = new Node(i, nums[i]);
			add(node, halfK);
		}
		for (int j = k - 1; j < nums.length; j++) {
			Node nd = new Node(j, nums[j]);
			add(nd, halfK);
			result.add(maxHeap.last().value);
			remove(new Node(j - k + 1, nums[j - k + 1]), minHeap, maxHeap);
		}		
		return result;
    }
	
	private void remove(Node node, TreeSet<Node> minHeap, TreeSet<Node> maxHeap) {
		if (minHeap.contains(node)) {
			minHeap.remove(node);
		}
		if (maxHeap.contains(node)) {
			maxHeap.remove(node);
		}
	}
	
	private void add(Node node, int half) {
		if (maxHeap.size() < half) {
			maxHeap.add(node);
		} else {
			minHeap.add(node);
		}
		//这里不只能单纯靠单双来判断，因remove的元素可以在minHeap也可以在maxHeap，
		//可以先把maxHeap放满，然后依次向minHeap放置，放的同时调配错位元素。
		if(maxHeap.size() == half && minHeap.size() > 0 && maxHeap.last().value > minHeap.first().value) {
			Node maxTop = maxHeap.last();
			Node minTop = minHeap.first();
			if (maxTop.value > minTop.value) {
				maxHeap.remove(maxTop);
				minHeap.remove(minTop);
				maxHeap.add(minTop);
				minHeap.add(maxTop);
			}
		}
	}
	
	private class Node implements Comparable<Node>{
		public int id;
		public int value;
		
		public Node(int id, int val) {
			this.id = id;
			this.value = val;
		}
		
		public int compareTo(Node other) {
			Node a = (Node)other;
			if (this.value == other.value) {
				return this.id - other.id;
			}
			return this.value - other.value;
		}
	}		
}
