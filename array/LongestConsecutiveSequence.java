/**
 * Prob: longest-consecutive-sequence No: 124
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * 
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * 思路：
 * 把所有元素放到set里，然后对每一个元素:
 * 如果存在于set里，那么删掉
 *     往上加一next和往下减一pre的找，
 *     如果存在pre或next元素就把此元素从数组里删掉, 同时打擂台比大小即可
 */
public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<>();
        for (int i: num) {
            set.add(i);
        }
        int ans = 0;
        for (int i: num) {
            if (set.contains(i)) {
                set.remove(i);
                int pre = i - 1;
                while (set.contains(pre)) {
                    set.remove(pre);
                    pre--;
                }
                int next = i + 1;
                while (set.contains(next)) {
                    set.remove(next);
                    next++;
                }
                ans = Math.max(ans, next - pre - 1);
            }
        }
        return ans;
    }
}
