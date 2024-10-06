package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    // If the stack is empty (no matching opening symbol), return false
                    return false; 
                }

                char open = stack.pop();

                // Check if the popped opening symbol matches the current closing symbol
                // If that is not the case, return false
                if ((c == ')' && open != '(') || 
                    (c == ']' && open != '[') || 
                    (c == '}' && open != '{')) {
                    return false;
                }
            }
        }

        // At this step, the stack should be empty if the expression is balanced
        return stack.isEmpty();
    }

}
