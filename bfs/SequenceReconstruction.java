public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (seqs == null || seqs.length == 0) {
            return false;
        }
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (Integer in : org) {
            map.put(in, new HashSet<Integer>());
        }
        HashMap<Integer, Integer> indegree = new HashMap<>();
        int total = 0;
        int n = org.length;
        for (int i = 0; i < seqs.length; i++) {
            total += seqs[i].length;
            //if an item is bigger than n 
            if (seqs[i].length >= 1 && (seqs[i][0] < 1 || seqs[i][0] > n)) {
                return false;
            }
            for (int j = 1; j < seqs[i].length; j++) {
                if (seqs[i][j] < 1 || seqs[i][j] > n) {
                    return false;
                }
                if (map.get(seqs[i][j-1]).add(seqs[i][j])) {
                    if (indegree.containsKey(seqs[i][j])) {
                        indegree.put(seqs[i][j], indegree.get(seqs[i][j]) + 1);
                    } else {
                        indegree.put(seqs[i][j], 1);
                    }
                }
            }
        }
        // case [1], [[],[]]
        if (total < org.length) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Integer o: org) {
            if (!indegree.containsKey(o)) {
                queue.offer(o);
            }
        }
        int count = org.length;
        int index = 0;

        while (queue.size() == 1) {
            Integer i = queue.poll();
            if (org[index++] != i) {
                return false;
            }
            for (Integer j : map.get(i)) {
                indegree.put(j, indegree.get(j) - 1);
                if (indegree.get(j) == 0) {
                    queue.offer(j);
                }
            }
        }
        return index == count;
    }
}
