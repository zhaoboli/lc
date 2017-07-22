public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] res = new int[k];
        int index = 0;
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > target) {
                right = mid;
            } else if (A[mid] == target && index < k) {
                left = mid;
                right = mid + 1;
                break;
            } else {
                left = mid;
            }
        }
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                res[index++] = A[right++];
            } else if (right >= A.length) {
                res[index++] = A[left--];
            } else {
                //if (target - A[start] <= A[end] - target)
                if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                    res[index++] = A[left--];
                } else {
                    res[index++] = A[right++];
                }
            }
        }
        return res;
    }
}
