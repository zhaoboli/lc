class Solution {
    /**
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param B: sorted integer array B which has n elements,
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int index = m + n -1;
        int a = m - 1;
        int b = n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] >= B[b]) {
                A[index--] = A[a--];
            } else {
                A[index--] = B[b--];
            }
        }
        while (a >= 0) {
            A[index--] = A[a--];
        }
        while (b >= 0) {
            A[index--] = B[b--];
        }
    }
}
