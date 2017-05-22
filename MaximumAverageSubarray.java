public class Solution {
    /**
     * @param nums an array with postive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
     public double maxAverage(int[] nums, int k) {
         // Write your code here
         if (nums == null || nums.length == 0) {
             return 0;
         }

         double left = Integer.MAX_VALUE;
         double right = Integer.MIN_VALUE;
         for (int i = 0; i < nums.length; i++) {
             if (nums[i] < left) {
                 left = nums[i];
             }
             if (nums[i] > right) {
                 right = nums[i];
             }
         }
 
         while (right - left >= 1e-6) {
             double mid = left + (right - left) / 2;
             if (checkValid(nums, k, mid)) {
                 left = mid;
             } else {
                 right = mid;
             }
         }
         if (checkValid(nums, k, right)) {
             return right;
         }
         return left;
     }

     private boolean checkValid(int[] nums, int k, double mid) {
         double[] sums = new double[nums.length + 1];
         sums[0] = 0;
         double minPre = 0;
         for (int i = 1; i <= nums.length; i++) {
             sums[i] = sums[i - 1] + nums[i - 1] - mid;
             if (i >= k) {
                 minPre = Math.min(minPre, sums[i - k]);
             }
             if (i >= k && (sums[i] - minPre >= 0)) {
                 return true;
             }
         }
         return false;
     }
   }
