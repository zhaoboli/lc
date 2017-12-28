/**
 * Prob: subsets No: 17
 * 思路：典型的深搜
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
            //注意此处是index+1,而非index+1, 例子是{1, 2}, {1, 3}反例{2, 2}
			helper(nums, path, index + 1, result);
			path.remove(path.size() - 1);
		}
	}
    /**
     * 集合中的每一个数只可能是出现或者不出现，那么所对应的二进制序列是0,或者1;
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        int n = nums.length;
        int num = 1 << n;
        Arrays.sort(nums);
        for (int i = 0; i < num; i++) {
            printSet(i, n, nums, result); 
        }
        return result;
    }

    private void printSet(int num, int n, int[] nums,  List<List<Integer>> result) {
        List<Integer> path = new ArrayList<Integer>();  
        for (int i = 0; i < n; i++) {
            if (((1 << i) & num) > 0) {
                path.add(nums[i]);
            }
        }
        result.add(path);
    }
}
