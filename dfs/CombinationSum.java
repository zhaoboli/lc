/**
 * Prob: combination-sum No: 135
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * Example:
 * Given candidate set [2,3,6,7] and target 7, a solution set is:
 * [7]
 * [2, 2, 3]
 * 思路：
 * 深搜常见写法，注意去重的逻辑
 */
 public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, path, 0, result, 0);
        return result;
    }

    private void helper(int[] candidates, int target, ArrayList<Integer> path, int index, List<List<Integer>> result, int sum) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(path));
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target, path, i, result, sum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
  }
