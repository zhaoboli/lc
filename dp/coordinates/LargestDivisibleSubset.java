public class Solution {
    /**
     * @param nums a set of distinct positive integers
     * @return the largest subset
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Arrays.sort(nums);
        int[] f = new int[nums.length];
        int[] cache = new int[nums.length];

        //接龙
        for(int i = 0; i < nums.length; i++) {
            f[i] = 1;
            cache[i] = -1;
            for (int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                    cache[i] = j;
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] > f[maxIndex]) {
                maxIndex = i;
            }
        }
                
        List<Integer> result = new ArrayList<Integer>();
        while(maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = cache[maxIndex];
        }

        return result;
    }
}
