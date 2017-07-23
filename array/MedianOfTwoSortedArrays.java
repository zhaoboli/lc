class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        if ((lenA + lenB) % 2 == 0) {
            return (findKth(A, 0, B, 0, (lenA + lenB) / 2) + findKth(A, 0, B, 0, (lenA + lenB) / 2 + 1 )) / 2.0;
        } else {
            return findKth(A, 0, B, 0,  (lenA + lenB) / 2 + 1) / 1.0;
        }
    }

    private int findKth(int [] A, int aStart, int[] B, int bStart, int k) {
        // if A or B is empty, and also when A or B has crossed the last element
        if (aStart == A.length) {
            return B[bStart + k - 1];
        }

        if (bStart == B.length) {
            return A[aStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        // when A or B is not big enough to remove k /2
        if (aStart + k / 2 > A.length) {
            return findKth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
        if (bStart + k / 2 > B.length) {
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
        }

        //normal case
        if (A[aStart + k / 2 - 1] < B[bStart + k / 2 - 1]) {
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
        } else {
            return findKth(A, aStart, B, bStart + k / 2, k - k /2);
        }
    }
}
