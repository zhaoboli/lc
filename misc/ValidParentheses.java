public class Solution {
    /**
     * @param s A string
     * @return whether the string is valid parentheses
     */
    public boolean isValidParentheses(String s) {
        if (s == null) {
            return false;
        }

        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character c : input) {
            if ("{[(".contains(String.valueof(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isValid(Character c1, Character c2) {
        return (c1 == '{' && c2 == '}') || (c1 == '(' && c2 == ')') 
            || (c1 == '[' && c2 == ']');
    }
}
