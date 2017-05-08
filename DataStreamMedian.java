/**
* Numbers keep coming, return the median of numbers at every time a new number added.
* What's the definition of Median?
* Median is the number that in the middle of a sorted array. 
* If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
* For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
* For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
* For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
* For numbers coming list: [2, 20, 100], return [2, 2, 20]

*/

public class Solution {
    PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
		int size = nums.length;
		int numCount = 0;
		int[] result = new int[size];
		minHeap = new PriorityQueue<Integer>(size);
		maxHeap = new PriorityQueue<Integer>(size, new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return -(left - right);
			}
		});
		
		for (int i = 0; i < nums.length; i++) {
			add(nums[i], i);
			result[i] = maxHeap.peek();
		}
		return result;
    }
	//return the count of numbers already added
	private void add(int number, int numCount) {
		maxHeap.offer(number);
		if (numCount%2 == 0) {
			if(numCount == 0) {
				return;
			}
			if(maxHeap.peek() > minHeap.peek()) {
				int maxTop = maxHeap.poll();
				int minTop = minHeap.poll();
				maxHeap.offer(minTop);
				minHeap.offer(maxTop);
			}
		} else {
			minHeap.offer(maxHeap.poll());
		}
	}
}