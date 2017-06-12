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

    public int KthInArrays(int[][] arrays, int k) {
       if (arrays == null || arrays.length == 0) {
           return Integer.MIN_VALUE;
       }
       PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
           @Override
           public int compare(Integer left, Integer right) {
               return left - right;
           }
       });

       int n = arrays.length;
        //O(2m*nlogk) both offer and poll
       for (int i = 0; i < n; i++) {
           int m = arrays[i].length;
           for (int j = 0; j < m; j++) {
               heap.offer(arrays[i][j]);
               if (heap.size() > k) {
                   heap.poll();
               }
           }
       }

       return heap.peek();
   }

   private class Node {
       public int index;
       public int from_row;
       public int val;

       public Node (int index, int from_row, int val) {
           this.index = index;
           this.from_row = from_row;
           this.val = val;
       }
   }

    public int KthInArrays(int[][] arrays, int k) {
        if (arrays == null || arrays.length == 0) {
          return -1;
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new Comparator<Node>() {
          @Override
          public int compare(Node left, Node right) {
              return -(left.val - right.val);
            }
          });

    int n = arrays.length;
    //put the max number of each array
    for (int i = 0; i < n; i++) {
        int m = arrays[i].length;
        //O(n * m log m) + O(n * log n) + O(2 * k * log n)
        if (m > 0) {
            Arrays.sort(arrays[i]);
            queue.offer(new Node(m - 1, i, arrays[i][m-1]));
        }
    }

    for (int i = 0; i < k; i++) {
        if (i == k-1) {
            return queue.poll().val;
        }
        Node head = queue.poll();
        if (head.index > 0) {
            queue.offer(new Node(head.index-1, head.from_row, arrays[head.from_row][head.index-1]));
        }
    }
    return -1;
   }

   private class Node {
       public int index;
       public int from_row;
       public int val;

       public Node (int index, int from_row, int val) {
           this.index = index;
           this.from_row = from_row;
           this.val = val;
       }
   }

}
