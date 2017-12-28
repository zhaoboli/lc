/**
 * Prob: subsets-ii No: 18
 * 跟subsets类似，用到的去重技巧：当前层的当前数如果跟当前层之前的一个数有重复，那么跳过此数
 */
Given a list of numbers that may has duplicate numbers, return all possible subsets
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.

If S = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();     	
        if (nums == null) {
            return result;
        }
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums); 
        helper(nums, 0, result, path);
        return result;
    }

    private void helper(int[] nums, int startIndex, List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<Integer>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            helper(nums, i + 1, result, path);
            path.remove(path.size() - 1);
        }
    }
}

