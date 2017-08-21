/**
 * Prob: combination-sum-ii No: 153
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 *
 * Given candidate set [10,1,6,7,2,1,5] and target 8,
 * A solution set is:
 * [
 * [1,7],
 * [1,2,5],
 * [2,6],
 * [1,1,6]
 * ]
 * 思路：
 * 去重， 当前层如果一个数已经被取过一次就不用再取一次了
*/
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(num, path, 0, target, 0, result);
        return result;
    }

    private void helper(int[] num, List<Integer> path, int index, int target, int sum, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < num.length; i++) {
            if (i > index && num[i] == num[i-1]) {
                continue;
            }
            path.add(num[i]);
            //error made - used"index + 1"
            helper(num, path, i + 1, target, sum + num[i], result);
            path.remove(path.size() - 1);
        }
    }
}
