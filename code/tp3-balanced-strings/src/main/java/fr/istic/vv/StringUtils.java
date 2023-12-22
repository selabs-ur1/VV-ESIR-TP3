package fr.istic.vv;

import java.util.Stack;

public class StringUtils {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing symbol
                }

                char openSymbol = stack.pop();
                if (!isMatching(openSymbol, ch)) {
                    return false; // Mismatched opening and closing symbols
                }
            }
        }

        return stack.isEmpty(); // Check if all opening symbols have a matching closing symbol
    }

    private static boolean isMatching(char openSymbol, char closeSymbol) {
        return (openSymbol == '{' && closeSymbol == '}') ||
               (openSymbol == '[' && closeSymbol == ']') ||
               (openSymbol == '(' && closeSymbol == ')');
    }
}
