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

	// O(n*2) 
	// Easier to understand version
	// 0: State: From any number prior go to number i, the max increasing subsequence.
	// 1: Initialize all f(i) to 1. 
	// 2: For f(i), for all postions smaller than f(i), check if there is
	public int longestIncreasingSubsequenceIMPD(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] seqCache = new int[nums.length];
		int maxSeq = 1;
		
		for (int index = 0; index < nums.length; index++) {
			seqCache[index] = 1;
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					seqCache[i] = Math.max(seqCache[j] + 1, seqCache[i]);
				}
			}
			if (seqCache[i] > maxSeq) {
				maxSeq = seqCache[i];
			}
		}
		return maxSeq;
	}
    //O(nlogn) using binary search TODO
}    
