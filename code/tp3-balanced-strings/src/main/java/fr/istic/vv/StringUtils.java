package fr.istic.vv;

public class StringUtils {

    private StringUtils() {}

    /**
     * Vérifie qu'une chaîne de caractères est équilibrée (tous les symboles ouvrants sont fermés)
     * @param str une chaîne de caractères quelconque
     * @return true ssi les symboles ouvrants ({[ ont des symboles fermants ]}) associés
     */
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // Caractère fermant sans caractère ouvrant
                }
                char openSymbol = stack.pop();
                if (!isMatching(openSymbol, ch)) {
                    return false; // Mauvais symboles ouverts et fermés
                }
            }
        }
        return stack.isEmpty(); // Vide si tous les symboles ouverts sont fermés
    }

    /**
     * Vérifie qu'un caractère ouvrant est associé à son caractère fermant
     * @param openSymbol un symbole ouvrant [{(
     * @param closeSymbol un symbole fermant )}]
     * @return true ssi closeSymbol est le caractère associé à openSymbol
     */
    private static boolean isMatching(char openSymbol, char closeSymbol) {
        return (openSymbol == '(' && closeSymbol == ')') ||
                (openSymbol == '{' && closeSymbol == '}') ||
                (openSymbol == '[' && closeSymbol == ']');
    }

}
