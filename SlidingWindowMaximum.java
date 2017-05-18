public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		for (int i = 0; i < k -1; i++) {
			enQueue(nums, deque, i);
		}
		
		for (int i = k-1; i < nums.length; i++) {
			outQueue(deque, i, k);
			enQueue(nums, deque, i);
			result.add(nums[deque.peekLast()]);
		}
		return result;
	}
	
	private void enQueue(int[] nums, Deque<Integer> deque, int index) {
		while (deque.peekFirst() != null && nums[deque.peekFirst()] < nums[index]) {
			deque.pollFirst();
		}
		deque.addFirst(index);
	}
	
	private void outQueue(Deque<Integer> deque, int index, int k) {
		if (deque.peekLast() != null && index - deque.peekLast() >= k) {
			deque.pollLast();
		}
	}
}
