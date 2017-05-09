/**
Given an expression s includes numbers, letters and brackets. 
Number represents the number of repetitions inside the brackets(can be a string or another expression)．
Please expand expression to be a string.

Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
*/

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        char[] input = s.toCharArray();
        Stack<Object> stack = new Stack<Object>();
        
        int num = 0;
        for (int i = 0; i < input.length; i++) {
            if (Character.isLetter(input[i])) {
                stack.push(Character.toString(input[i]));
            } else if (input[i] == '[') {
                stack.push(num);
                num = 0;
            } else if (Character.isDigit(input[i])) {
                num = num * 10 + input[i] - '0';
            } else if (input[i] == ']') {
                String str = popStack(stack);
                int times = (Integer) stack.pop();
                for (int index = 0; index < times; index++) {
                    stack.push(str);
                }
            }
        }
        return popStack(stack);
    }

    private String popStack(Stack<Object> stack) {
        Stack<String> buffer = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() instanceof String) {
            buffer.push((String) stack.pop());
        }
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
}