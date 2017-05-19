public class Solution {
    /**
     * @param nums an array containing n + 1 integers which is between 1 and n
     * @return the duplicate one

	 * Given nums = [5,5,4,3,2,1] return 5
		Given nums = [5,4,4,3,2,1] return 4
		[1,2,3,
     */
    //quick sort, shouldn't be used in interview
    public int findDuplicateI(int[] nums) {
        // Write your code here
		if(nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);

		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= mid) {
				end = mid;
			} else {
				start = mid;
			}
		}
		return nums[start];
    }

    public int findDuplicateII(int[] nums) {
      if (nums == null || nums.length == 0) {
           return 0;
        }

        int start = 1;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (smallerThan(nums, mid) <= mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (smallerThan(nums, start) <= start) {
            return end;
        }
        return start;
    }

    private int smallerThan(int[] nums, int m) {
        int ct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= m) {
                ct++;
            }
        }
        return ct;
    }
}
