class Solution {
    /**
     * @param nums an integer unsorted Array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */

    public int kthLargestElement2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k + 1);
        for(int i = 0; i < nums.length; i++) {
           minHeap.offer(nums[i]);
           //might be interesting to check when resize will happen
           if (minHeap.size() == k + 1) {
              minHeap.poll();
           }
        } 
        return minHeap.peek();
    }

}
