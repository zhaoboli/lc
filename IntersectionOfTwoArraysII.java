package com.zhaobo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Example
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 */
public class IntersectionOfTwoArraysII {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] temp = new int[nums1.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length ) {
            if (nums1[i] == nums2[j]) {
                temp[index++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }
        return result;
    }

    public int[] intersectionHash(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (hash.containsKey(nums1[i])) {
                hash.put(nums1[i], hash.get(nums1[i]) +1);
            } else {
                hash.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int j = 0; j < nums2.length; j++) {
            if (hash.containsKey(nums2[j]) && hash.get(nums2[j]) > 0) {
                result.add(nums2[j]);
                hash.put(nums2[j], hash.get(nums2[j]) - 1);
            }
        }

        int[] res = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            res[index] = result.get(index);
        }
        return res;
    }
}
