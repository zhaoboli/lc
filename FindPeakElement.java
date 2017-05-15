class Solution {
    public int findPeak(int[] A) {
        if (A == null || A.length ==0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid -1] && A[mid + 1] > A[mid]) {
                start = mid;
            }
            if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1] ) {
                end = mid;
            }
            if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid;
            }
            if (A[mid] > A[mid - 1] && A[mid] > A[mid +1]) {
                return mid;
            }
        }
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }

    public int findPeakSlow(int[] A) {
        if (A == null || A.length <= 2) {
            return -1;
        }

        int start = 0;
        int mid = start + 1;
        int end = mid + 1;
        for (int i = 0; i + end < A.length; i++) {
            if(A[mid + i] > A[start + i] && A[mid + i] > A[end + i]) {
                return mid + i;
            }
        }
        return -1;
    }
}
