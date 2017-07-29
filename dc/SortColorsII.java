/**
 * Given an array of n objects with k different colors (numbered from 1 to k),
 * sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
 * You are not suppose to use the library's sort function for this problem. k <= n
 * Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4]
 */

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        if (colors == null) {
            return;
        }
        sort(colors, 0, colors.length - 1, 1, k);
    }

    private void sort(int[] colors, int start, int end, int fromColor, int toColor) {
        if (fromColor >= toColor) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int midColor = (fromColor + toColor) / 2;
        while (left <= right) {
            while (left <= right && colors[left] <= midColor) {
                left++;
            }
            while (left <= right && colors[right] > midColor) {
                right--;
            }
            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }
        sort(colors, start, right, fromColor, midColor);
        sort(colors, left, end, midColor + 1, toColor);
    }
}
