/**
 * Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 * Given an integer array, sort it in ascending order. 
 * Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
 */

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int[] memo = new int[A.length];
        mergeSort(A, 0, A.length - 1, memo);  
    }

    private void mergeSort(int[] A, int start, int end, int[] memo) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int mid = (start + end) / 2;
        mergeSort(A, start, mid, memo);
        mergeSort(A, mid + 1, end, memo);
        mergeHelper(A, start, end, memo);
    }

    private void mergeHelper(int[] A, int start, int end, int[] memo) {
        int mid = (start + end) / 2; 
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                memo[index++] = A[left++];
            } else {
                memo[index++] = A[right++];
            }
        }
        while (left <= mid) {
            memo[index++] = A[left++];
        }
        while (right <= end) {
            memo[index++] = A[right++];
        }

        for (int i = start; i <= end; i++) {
            A[i] = memo[i];
        }
    }
}
