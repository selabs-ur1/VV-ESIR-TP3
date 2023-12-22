package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Stack<Character> opening = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) { // On parcoure la chaîne de caractère
            char c = str.charAt(i);
            switch(c) {
                case '{' : case '[': case '(' : // On insère dans la pile
                    opening.push(c);
                    break;
                case '}':
                    if (opening.empty() || opening.pop() != '{') return false;
                    break;
                case ']':
                    if (opening.empty() || opening.pop() != '[') return false;
                    break;
                case ')':
                    if (opening.empty() || opening.pop() != '(') return false;
                    break;
                default: // si le caractère est tout autre chose (une lettre par exemple)
                    break;
            }
        }
        return opening.isEmpty();
    }

}