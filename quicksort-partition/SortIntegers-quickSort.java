public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    //quick sort
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    private void quickSort(int[] A, int start, int end) {
        if( start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = A[(start + end) /2];

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }
        quickSort(A, start, left);
        quickSort(A, right, end);
    }
	
	
	//merge sort
	public void sortIntegers2(int[] A) {
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
		int mid = start + (end - start) / 2;
		// error made: mergeSort(A, cache, 0, mid);
		mergeSort(A, cache, start, mid);
		mergeSort(A, cache, mid + 1, end);
		merge(A, cache, start, end);
	}
	
	private void merge(int[] A, int[] cache, int start, int end) {
		int left = start;
		int mid = (start + end) / 2;
		
		int right = mid + 1;
		int index = start;
		
		//merge sorted partition first
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
