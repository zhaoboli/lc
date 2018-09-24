Given two arrays, write a function to compute their intersection.
Each element in the result must be unique.
The result can be in any order.
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
/**
 * Prob: intersection-of-two-arrays No: 547
 * 起源：当搜索引擎找到(hello + world)时，假如是分别基于hello和world来找的话，那么第一步结果
 * 应该是两个url 的topk的数组，分别对应于hello和world，因为要查询的结果是(hello + world),那么此时
 * 应该把两个url的数组合并 
 */
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Time: O(nlogn)  Space: O(1)
        if (nums1 == null || nums2 == null) {
            return null;
        } 
        int n = nums1.length;
        int m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<Integer>();
        int a = 0;
        int b = 0;
        int previous = Integer.MIN_VALUE;
        while (a < n && b < m) {
            if (nums1[a] < nums2[b]) {
                a++;
            } else if (nums1[a] > nums2[b]) {
                b++;
            } else {
                if (nums1[a] != previous) {
                    result.add(nums1[a]);
                    previous = nums1[a];
                }
                a++;
                b++;
            }
        }
        int ct = result.size();
        int[] res = new int[ct];
        for (int i = 0; i < ct; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    // Space: O(n) Time: O((n+m)logm) m: smaller array's length
    public int[] intersection(int[] nums1, int[] nums) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int n = nums1.length;
        int m = nums2.length;
        int[] sortnums = null;
        int[] searchnums = null;
        if (n >= m) {
            sortnums = nums2;
            searchnums = nums1;
        } else {
            sortnums = nums1;
            searchnums = nums2;
        }
        Arrays.sort(sortnums);
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < searchnums.length; i++) {
            if (result.contains(searchnums[i])) {
                continue;
            }
            if (binarySearch(sortnums, searchnums[i])) {
                result.add(searchnums[i]);
            }
        }
        int[] res = new int[result.size()];
        int index = 0;
        for (Integer i : result) {
            res[index++] = i;
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return true;
        }
        if (nums[end] == target) {
            return true;
        }
        return false;
    }
    
    //HashTable version Space: O(n) Time: O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> resultSet = new HashSet<Integer>();
        for (int j = 0; j < nums2.length; j++) {
            if (set.contains(nums2[j]) && !resultSet.contains(nums2[j])) {
                resultSet.add(nums2[j]);
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer i : resultSet) {
            result[index++] = i;
        }
        return result;
    }

    // Space: O(n) Time: O(n) optimized HashTable version
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int j : nums2) {
            if (set.contains(j)) {
                result.add(j);
                set.remove(j);
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }
}
