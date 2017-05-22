public class Solution {
    /**
     * @param nums: The Integer array
     * @return: The length of LIS(longest increasing subsequence)
     */
    //O(n*2)
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] seqCache = new int[nums.length];
        int maxSeq = 1;
        
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, seqCache[j]);
                }
            }
            seqCache[i] = max + 1;
            maxSeq = Math.max(seqCache[i], maxSeq);
        }
        return maxSeq;
    }

    //O(nlogn) using binary search TODO
}    
