class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
	public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
		
		while (index <= right) {
			if (nums[index] == 2) {
				swap(nums, index, right--);
			} else if (nums[index] == 1) {
				index++;
			} else {
				swap(nums, index++, left++);
			}
		}
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
