class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		quickSort(nums, 0, nums.length - 1, k);
		int[] res = new int[k];
		for(int i = 0; i < k; i++) {
			res[i] = nums[i];
		}
		return res;
	}
	
	private void quickSort(int[] nums, int start, int end, int k) {
		 if (start >= k)
            return;

		if(start >= end) {
			return;
		}
		int pivot = (start + end) / 2;
		int left = start;
		int right = end;
		while(left <= right) {
			while(nums[left] > nums[pivot] && left <= right) {
				left++;
			}
			while(nums[right] < nums[pivot] && left <= right) {
				right--;
			}
			if(nums[left] < nums[right]) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}
		quickSort(nums, start, right, k);
		quickSort(nums, left, end, k);
	}
}