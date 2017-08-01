public class Solution {
    /**
     * Prob: 3sum No:21 
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null) {
            return null;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            //第一层去重
            if (i >= 1 && numbers[i] == numbers[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;            
            int target = numbers[i] * -1;
            //3sum转换成2sum == nums[i]的问题，算法时间复杂度n*2 + nlog(n)
            //接下来就是去重的问题了，有两种重复要去掉，如果target:nums[i]取过一次，则下次跳过,此为第一层去重
            //同时在剩下的右边数中取2sum 
            //如果选定一个nums[i],但是右边剩下的数中扔有重复，这时候就采取跟2sum unique pairs一样的去重办法,此为第二层去重
            while (left < right) {
                if ((numbers[left] + numbers[right]) == target) {
                    //第二层去重
                    ArrayList<Integer> ans = new ArrayList<Integer>();
                    ans.add(numbers[i]);
                    ans.add(numbers[left]);
                    ans.add(numbers[right]);
                    result.add(ans);
                    left++;
                    right--;
                    while (left < right && (numbers[left] == numbers[left-1])) {
                        left++;
                    }
                    while (left < right && (numbers[right] == numbers[right+1])) {
                        right--;
                    }
                } else if ((numbers[left] + numbers[right]) > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
