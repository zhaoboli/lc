/**
 * Prob: largest-rectangle-in-histogram No: 122
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * [2,1,5,6,2,3]. return 10
 * 思路：
 * 求某一点的矩形面积转化成求当前点左边的第一个比它小的点，和当前点右边第一个比它小的点，然后两者之间宽度即为这个矩形的宽度，
 * 长即为当前点的高度
 * 此时可以用单调栈来做，
 * 假使从左到右为例，单调栈在压栈之前先检查当前点是不是比栈顶的元素小，如果是那么就弹栈，此时当前点就是被弹栈的点的右边第一个比它小的点
 */
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i++) {
			int curr = (i == height.length) ? -1 : height[i];
			while (!stack.isEmpty() && curr < height[stack.peek()]) {
				int h = height[stack.pop()];
				int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.push(i);
		}
		return max;
    }


    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i <= height.length; i++) {
            int currHeight = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] > currHeight) {
                right[stack.pop()] = i;
            }
            if (i != height.length) {
                stack.push(i);
            }
        }

        for (int i = height.length -1; i >= -1; i--) {
            int currHeight = i == -1 ? -1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] > currHeight) {
                left[stack.pop()] = i;
            }
            if (i != -1) {
                stack.push(i);
            }
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i] * (right[i] - left[i] - 1));
        }
        return max;
    }
}
