/** 
 * Prob: zigzag-iterator-ii No: 541
 * Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases? The "Zigzag" order * is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
 * Given k = 3 1d vectors:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * Return [1,4,8,2,5,9,3,6,7].
 * 思路：用一个计数器turn记录现在在第几个iterator, 拿到next的同时，如果当前iterator为空，拿掉当前iterator,那么下一个iterator是turn%newsize, newsize=(currsize-1),否则则是(turn+1) % size
 */
public class ZigzagIterator2 {
    private List<Iterator<Integer>> iterators = null;
    int turn = 0;
    /*
    * @param vecs: a list of 1d vectors
    */
    public ZigzagIterator2(List<List<Integer>> vecs) {
        this.iterators = new ArrayList<Iterator<Integer>>();
        for (List<Integer> vec: vecs) {
            if (vec.size() > 0) {
                iterators.add(vec.iterator());
            }
        }
    }
    /*
     * @return: An integer
     */
    public int next() {
        Iterator<Integer> iter = iterators.get(turn);
        int ret = iter.next();
        if (iter.hasNext()) {
            turn = (turn + 1) % iterators.size();
        } else {
            iterators.remove(turn);
            if (iterators.size() != 0) {
                turn = turn % iterators.size();
            }
        }
        return ret;
    }
    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        if (iterators.size() > 0) {
            return true;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
