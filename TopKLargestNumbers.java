class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
       /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        int[] topK = new int[k];
		if (nums == null || nums.length == 0 ) {
			return topK;
		}
		if (k > nums.length){
			return topK;
		}
		Queue<Integer> queue = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return -(x - y);
			}});
			
		for (int i = 0; i < nums.length; i++) {
			queue.offer(nums[i]);
		}

		int i = 0;
		
		while (i < k) {
			topK[i++] = queue.poll();
		}
		
		return topK;
    }
};

