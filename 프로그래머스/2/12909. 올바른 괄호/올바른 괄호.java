import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (stack.isEmpty()) {
                stack.push(array[i]);
            } else {
                char peek = stack.peek();
                if (peek == '(' && array[i] == ')') {
                    stack.pop();
                } else {
                    stack.push(array[i]);
                }
            }
        }
        
        return stack.isEmpty();
    }
}