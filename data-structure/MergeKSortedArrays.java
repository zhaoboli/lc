/**
 * Prob: merge-k-sorted-arrays No: 486
 * Given k sorted integer arrays, merge them into one sorted array.
 * Given 3 sorted arrays:

 * [
   [1, 3, 5, 7],
   [2, 4, 6],
   [0, 8, 9, 10, 11]
 * ]
 * return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
 * 思路：
 * 无脑用堆 
 */

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return result;
        }
        Queue<Item> queue = new PriorityQueue<Item>(arrays.length, new Comparator<Item>() {
            @Override
            public int compare (Item i1, Item i2) {
                return i1.val - i2.val;
            }
        });
        for (int i = 0; i < arrays.length; i++) {
            Item it = new Item(i, 0, arrays[i][0]);
            queue.offer(it);
        }

        while (!queue.isEmpty()) {
            Item itm = queue.poll();
            result.add(itm.val);
            if (itm.y < arrays[itm.x].length - 1) {
                queue.offer(new Item(itm.x, itm.y + 1, arrays[itm.x][itm.y+1]));
            }
        }
        return result;
    }
    private class Item {
        int x;
        int y;
        int val;
        public Item(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
