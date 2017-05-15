/**
* [2,1,5,6,2,3].
*/
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
		
		if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for (int i = 0; i <= height.length; i++) {
			int curr = (i == height.length) ? -1 : height[i];
			while(!stack.isEmpty() && curr < height[stack.peek()]) {
				int h = height[stack.pop()];
				//choose i is interesting
				int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
				max = Math.max(max, h * w);
			}
			stack.push(i);
		}
		
		return max;
    }
}
