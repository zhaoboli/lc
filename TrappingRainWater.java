public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
		int left = 0;
		int right = heights.length - 1;
		if (left >= right) {
			return 0;
		}
		int trappedWater = 0;
		int leftHeight = heights[left];
		int rightHeight = heights[right];
		
		while (left < right) {
			while (left < right && leftHeight <= rightHeight) {
				if (heights[left] < leftHeight) {
					trappedWater += leftHeight - heights[left];
				} else {
					leftHeight = heights[left];
                    if (leftHeight > rightHeight) {
                        break;
                    }
				}
				left++;
			}
			while (left < right && rightHeight <= leftHeight) {
				if (heights[right] < rightHeight) {
					trappedWater += rightHeight - heights[right];
				} else {
					rightHeight = heights[right];
                    if (rightHeight > leftHeight) {
                        break;
                    }
				}
				right--;
			}
		}
		return trappedWater;
    }
}
