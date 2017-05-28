class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description
     */
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
};
