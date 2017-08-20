/**
 * Prob: permutation-index No: 197
 * Given a permutation which contains no repeated number,
 * find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.
 * Given [1,2,4], return 1.
 * 思路：
 * 以 [２, １, 4]为例：　那么在[２, １, 4]之前的排列有
 *  x * 2! + y * 1! + z * 0!, 这里x, y, z分别表示在下标０, 1, 2右边比它小的元素的个数．
 * 拿２为例，2右边比２小的元素有１一个，那么假如把此元素和２互换，那么剩下的元素［２，４］的排列有２！个.
 */
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    private long counter = 0;
    private long index = 0;

    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int[] clone = A.clone();
        boolean[] map = new boolean[A.length];
        ArrayList<Integer> permute = new ArrayList<Integer>();
        Arrays.sort(A);
        helper(A, clone, map, permute, 0);
        return index;
    }

    private boolean matched(int[] origin, List<Integer> permute) {
        int matchedCt = 0;
        while (matchedCt < origin.length) {
            if (origin[matchedCt] == permute.get(matchedCt)) {
                matchedCt++;
            } else {
                break;
            }
        }
        if (matchedCt == origin.length) {
            return true;
        }
        return false;
    }

    private void helper(int[] A, int[] origin, boolean[] map, List<Integer> permute, int start) {
        if (start == origin.length) {
            counter++;
            if (matched(origin, permute)) {
                index = counter;
            }
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (map[i]) {
                continue;
            } else {
                permute.add(A[i]);
                map[i] = true;
                helper(A, origin, map, permute, start + 1);
                permute.remove(A[i]);
                map[i] = false;
            }
        }
    }

    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        long smallCt = 0;
        long fact = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            int ct = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    ct++;
                }
            }
            fact *= (A.length - 1 - i);
            smallCt += fact * ct;
        }
        return smallCt + 1;
    }
}
