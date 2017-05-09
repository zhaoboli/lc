public class Solution {

    /**

     * @param arrays a list of array

     * @param k an integer

     * @return an integer, K-th largest element in N arrays

     */

    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
        if (arrays == null) {
            return 0;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer left, Integer right) {
                return -(left - right);
                } 
        });
        //space complexity O(m * n), time complexity O(m*nlogm*n)
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                heap.offer(arrays[i][j]);
            }
        }

        int counter = 0;
        int res = 0;
        while (counter < k) {
            res = heap.poll();
            counter++;
        }
        return res;
    }

}
