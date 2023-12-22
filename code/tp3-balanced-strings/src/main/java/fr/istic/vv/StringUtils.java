package main.java.fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Si c'est une parenthèse ouvrante, la mettre sur la pile
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // Si c'est une parenthèse fermante, vérifier la correspondance avec la parenthèse au sommet de la pile
                if (stack.isEmpty()) {
                    // Si la pile est vide, il n'y a pas de parenthèse correspondante ouvrante
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    // Si la parenthèse au sommet de la pile ne correspond pas à la parenthèse fermante actuelle
                    return false;
                }
            }
        }

        // Vérifier si la pile est vide à la fin, ce qui signifie que toutes les parenthèses ont été équilibrées
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char character1, char character2) {
        return (character1 == '(' && character2 == ')') ||
                (character1 == '[' && character2 == ']') ||
                (character1 == '{' && character2 == '}');
    }
}
