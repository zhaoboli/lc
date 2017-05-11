/**
Given a set of distinct integers, return all possible subsets.
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> result = new ArrayList();
		ArrayList<Integer> path = new ArrayList<Integer>();
		Arrays.sort(nums);
		helper(nums, path, 0, result);
		return result;
	}
	
	private void helper(int[] nums, ArrayList<Integer> path, int startIndex, ArrayList<ArrayList<Integer>> result){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.addAll(path);
		result.add(ans);
		//result.add(new ArrayList<Intege>(path));
		for(int index = startIndex; index < nums.length; index++) {
			path.add(nums[index]);
			helper(nums, path, index + 1, result);
			path.remove(path.size() - 1);
		}
	}
}