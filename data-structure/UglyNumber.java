class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description
     */
    // O(nlogn) Hash + Heap
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<Long>(n);
        HashSet<Long> hash = new HashSet<Long>();
        int[] base = {2, 3, 5};
        queue.offer(Long.valueOf(1));
        long cur = 0;
        for(int i = 1; i <=n; i++) {
            cur = queue.poll();
            for (Integer in: base) {
                if(!hash.contains(in * cur)) {
                    hash.add(cur * in);
                    queue.offer(cur * in);
                }
            }
        }
        return (int)cur;
    }

    public int nthUglyNumberOn(int n) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        queue.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0; 

        for (int i = 0; i < n - 1; i++) {
            int cur = queue.get(i);
            while(queue.get(p2) * 2 <= cur) {
                p2++;
            }
            while(queue.get(p3) * 3 <= cur) {
                p3++;
            }
            while(queue.get(p5) * 5 <= cur) {
                p5++;
            }
            queue.add(Math.min(queue.get(p2) * 2, Math.min(queue.get(p3) * 3, queue.get(p5) * 5)));
        }
        return queue.get(n - 1);
    }

};
