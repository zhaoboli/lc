Given a list of numbers with duplicate number in it. Find all unique permutations.
For numbers [1,2,2] the unique permutations are:
组合=permutation
[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
/**
 * Prob: permutations-ii No: 16
 * /
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);  
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        helper(nums, used, path, result);
        return result;
    }
    
    private void helper(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //take [1,2,2] for example,如果第一个２和第二个２在结果中互换，我们认为他还是一个方案，所以对于两个２，强制如果之前就在前面，结果还应该在前面，这样保证唯一性．当前面的２还未被used,不应该让后面的2被use
            if (used[i] ||((i > 0) && (nums[i] == nums[i-1]) && (!used[i-1]))) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            helper(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null)  {
            return  result;
        }
        Arrays.sort(nums);
        ArrayList<Integer> initialPath = new ArrayList<Integer>();
        boolean[] isVisited = new boolean[nums.length];
        permuteUniqueHelper(nums, isVisited, initialPath, result);
        return result;
    }

    private void permuteUniqueHelper(int[] nums, boolean[] isVisited, ArrayList<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            ArrayList<Integer> combination = new ArrayList<Integer>(path);
            result.add(combination);
            return;
        }

        int counter = 0;
        int preValue = 0;
        for (int index = 0; index < nums.length; index++) {
            if (isVisited[index]) {
                continue;
            } 
            if (counter > 0 && nums[index] == preValue) {
                continue;
            }
            preValue = nums[index];
            path.add(nums[index]);
            isVisited[index] = true;
            permuteUniqueHelper(nums, isVisited, path, result);
            isVisited[index] = false;
            path.remove(path.size() - 1);
            counter++;
        }
    }
}
