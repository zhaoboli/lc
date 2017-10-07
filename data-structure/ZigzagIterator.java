/** 
 * Prob: zigzag-iterator No: 540
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * Given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 */
public class ZigzagIterator {
    //version without using iterator
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */
    int index1 = 0;
    int index2 = 0;
    int total = 0;
    int curr = 0;
    boolean v1turn = true;
    List<Integer> v1 = null;
    List<Integer> v2 = null;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        total = v1.size() + v2.size();
        this.v1 = v1;
        this.v2 = v2;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (v1turn && index1 < v1.size()) {
            curr++;
            v1turn = !v1turn;
            return v1.get(index1++);
        }
        if (!v1turn && index2 < v2.size()) {
            curr++;
            v1turn = !v1turn;
            return v2.get(index2++);
        }
        if (index1 < v1.size()) {
            curr++;
            return v1.get(index1++);
        } else {
            curr++;
            return v2.get(index2++);
        }
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return curr < total;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
