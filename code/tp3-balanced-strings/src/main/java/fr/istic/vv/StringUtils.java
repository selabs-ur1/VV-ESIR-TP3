package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBalanced(String str) {
        Stack<Character> symbols = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                symbols.add(c);
            } else {
                if (c == ')' && (symbols.empty() || '(' != symbols.pop())) {
                    return false;
                } else if (c == ']' && (symbols.empty() || '[' != symbols.pop())) {
                    return false;
                } else if (c == '}' && (symbols.empty() || '{' != symbols.pop())) {
                    return false;
                }
            }
        }
        return symbols.empty();
    }
}
