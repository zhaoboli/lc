/**
Given a list of numbers, return all possible permutations.
Notice
You can assume that there is no duplicate numbers in the list.

For nums = [1,2,3], the permutations are:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null) {
            return result;   
        }
		HashSet<Integer> permutation = new LinkedHashSet<Integer>();
		helper(nums, permutation, result);
		return result;
	}
	
	private void helper(int[] nums, HashSet<Integer> permutation, List<List<Integer>> result) {
		if (permutation.size() == nums.length) {
			result.add(new ArrayList<Integer>(permutation));
			return;
		}
		for (int index = 0; index < nums.length; index++) {
			if (!permutation.contains(nums[index])) {
				permutation.add(nums[index]);
				helper(nums, permutation, result);
				permutation.remove(nums[index]);
			}
		}
	}
}
