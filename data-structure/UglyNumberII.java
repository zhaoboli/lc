/**
 * Prob: ugly-number-ii No: 4
 * Ugly number is a number that only have factors 2, 3 and 5.
 * Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * Note that 1 is typically treated as an ugly number.
 * If n=9, return 10.
 * 思路：
 * 注意overflow
 */
class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<Long>();
        queue.offer(Long.valueOf(1));
        HashSet<Long> hash = new HashSet<Long>();
        hash.add(Long.valueOf(1));
        Long[] source = new Long[3];
        source[0] = Long.valueOf(2);
        source[1] = Long.valueOf(3);
        source[2] = Long.valueOf(5);
        int index = 0;
        while (index < n - 1) {
            long min = queue.poll();
            index++;
            for (long l : source) {
                if (!hash.contains(l * min)) {
                    hash.add(l * min);
                    queue.offer(l * min); 
                }
            }
        }
        return queue.poll().intValue();
    }
}
