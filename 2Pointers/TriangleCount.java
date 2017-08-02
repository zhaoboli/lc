/**
 * Prob: triangle-count No: 382
 * 三角形： 任意两数之和大于第三个数。 找一个数位target，然后剩下如果能找到两个数大于它
 * 那么就是最小的两条边之和要大于最大边，那么这时候就联想到先把数组排序，然后倒着来。
 * 同时，如果右边最大的和左边最左的都满足条件，那么就是从左边第一个到右边最大之前的一个都是满足条件的解，所以 count+= right - left
 * Given an array of integers, how many three numbers can be found in the array, 
 * so that we can build an triangle whose three edges length is the three numbers that we find? 
 * Given array S = [3,4,6,7], return 3. They are:

 * [3,4,6]
 * [3,6,7]
 * [4,6,7]
 * Given array S = [4,4,4,4], return 4. They are:

 * [4(1),4(2),4(3)]
 * [4(1),4(2),4(4)]
 * [4(1),4(3),4(4)]
 * [4(2),4(3),4(4)]
 */
public class Solution {
    /*
     * @param : A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        if (S == null || S.length < 3) {
			return 0;
		}
		int n = S.length - 1;
		Arrays.sort(S);
		int count = 0;
		for (int i = n; i >= 2; i--) {
			int target = S[i];
			int left = 0;
			int right = i - 1;
			while (left < right) {
				if ((S[left] + S[right]) <= target) {
					left++;
				} else {
					count += right - left;
					right--;
				}
			}
		}
		return count;
    }
};
