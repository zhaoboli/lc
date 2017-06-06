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
}
