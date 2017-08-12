/**
 * Prob: top-k-largest-numbers No: 544
 * Given an integer array, find the top k largest numbers in it.
 * Given [3,10,1000,-99,4,100] and k = 3 Return [1000, 100, 10].
 * 思路：
 * 很容易联想到用堆
 */
class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        int[] res = new int[k];
        while (--k >= 0) {
            res[k] = minHeap.poll();
        }
        return res;
    }

    //based on quick-sort
    public int[] topK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        quicksort(nums, 0, nums.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    private void quicksort(int[] nums, int start, int end, int k) {
        //刚好越界，因此不用排
        if (start >= k) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start; 
        int right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        quicksort(nums, start, right, k);
        quicksort(nums, left, end, k);
    }
};

