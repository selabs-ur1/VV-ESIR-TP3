package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    public static boolean isBalanced(String str) {
        Stack<Character> pile = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '{':
                    pile.push(c);
                    break;
                case '[':
                    pile.push(c);
                    break;
                case '(':
                    pile.push(c);
                    break;
                case '}':
                    if (pile.size() == 0 || pile.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (pile.size() == 0 || pile.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (pile.size() == 0 || pile.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        return pile.size() == 0;
    }

}
