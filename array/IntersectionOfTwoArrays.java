public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // O(nlogn + mlogm + min(m, n)); O(1) space
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
    //O min(m,n)log min(m,n) + max(m,n) log min(m,n) 
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
}
