/**
 * Prob: heapify No: 130
 * Given an integer array, heapify it into a min-heap array.
 *
 * For a heap array A, A[0] is the root of heap,
 * and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * What is heap?
 * Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap,
 * "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.
 * Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 * Return any of the solution
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * 思路:
 * 父节点 = （i - 1）/ 2; 左右孩子 = (2 * i + 1) 或者 (2 * i + 2) 
 */
public class Solution {
    /**
      * @param A: Given an integer array
      * @return: void
      */
    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            shiftDown(A, i);
        }
    }

    private void shiftDown(int[] A, int i) {
        while (i < A.length) {
            int smallest = i;
            if (2 * i + 1 < A.length && A[smallest] > A[2 * i + 1]) {
                smallest = 2 * i + 1;
            }
            if (2 * i + 2 < A.length && A[smallest] > A[2 * i + 2]) {
                smallest = 2 * i + 2;
            }
            if (smallest == i) {
                break;
            }
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            i = smallest;
        }
    }
 }
