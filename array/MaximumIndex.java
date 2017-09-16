/**Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4) 
**/
public class Solution {
    /**
     * While traversing LMin[] and RMax[] if we see that LMin[i] is greater than RMax[j],
     * then we must move ahead in LMin[] because all elements on left of LMin[i] are greater than or equal to LMin[i].
     * Otherwise we must move ahead in RMax[j] to look for a greater j – i value.
     */
    public int maxIndexDiff(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int len = arr.length;
        int[] leftMin = new int[len];
        leftMin[0] = arr[0];
        for (int m = 1; m < len; m++) {
            leftMin[m] = Math.min(leftMin[m-1], arr[m]);
        }

        int[] rightMax = new int[len];
        rightMax[len-1] = arr[len-1];
        for (int n = len -2; n >= 0; n--) {
            rightMax[n] = Math.max(rightMax[n+1], arr[n]);
        }
        int maxDiff = -1;
        int i = 0, j = 0;
        while (i < len && j < len) {
            if (rightMax[j] - leftMin[i] >= 0) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
} 
