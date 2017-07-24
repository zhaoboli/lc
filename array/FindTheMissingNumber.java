public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
      //映射法
      //就是拿当前数 和以当前数作为下标的数组元素交换，那么当前数肯定入正位。 然后后再循环一遍，如果当前数所对应的数不等于下标，那么就是当前数，否则就是N
        int n = nums.length;
        int i = 0;
        while (i < n) {
            while (nums[i] != i && nums[i] < n){
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
            i++;
        }
        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    public int findMissing(int[] nums) {
        Arrays.sort(nums);
        int start = 0; 
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] != start) {
            return start;
        }
        if (nums[end] != end) {
            return end;
        }
        return nums.length;
    }
}
