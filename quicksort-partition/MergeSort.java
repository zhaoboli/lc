public class Solution {
    /*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int[] cache = new int[A.length];
        mergeSort(A, cache, 0, A.length - 1);    
    }
    
    private void mergeSort(int[] A, int[] cache, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A, cache, start, mid);
        mergeSort(A, cache, mid + 1, end);
        merge(A, cache, start, end);
    }
    
    private void merge(int[] A, int[] cache, int start, int end) {
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                cache[index++] = A[left++];
            } else {
                cache[index++] = A[right++];
            }
        }
        
        while (left <= mid) {
            cache[index++] = A[left++];
        }
        while (right <= end) {
            cache[index++] = A[right++];
        }
        
        for (int i = start; i <= end; i++) {
            A[i] = cache[i];
        }
    }
    
}