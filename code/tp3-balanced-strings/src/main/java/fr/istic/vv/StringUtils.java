package fr.istic.vv;

import java.util.LinkedList;

public class StringUtils {

    private static final char parenthese_ouvert = '(';
    private static final char parenthese_ferme = ')';

    private static final char crochet_ouvert = '[';
    private static final char crochet_ferme = ']';

    private static final char accolade_ouvert = '{';
    private static final char accolade_ferme = '}';

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        LinkedList<Character> ll = new LinkedList<Character>(); 
        for(char ch: str.toCharArray()) {
            if (ch == parenthese_ouvert || ch == crochet_ouvert || ch == accolade_ouvert) {
                ll.addLast(ch);
            } else if(ch == parenthese_ferme || ch == crochet_ferme || ch == accolade_ferme) {
                if(ll.size() == 0) {
                    return false;
                }
                char last_character = ll.getLast();
                char must_be = 'r';
                switch(ch) {
                    case parenthese_ferme:
                        must_be = parenthese_ouvert;
                        break;
                    case crochet_ferme:
                        must_be = crochet_ouvert;
                        break;
                    case accolade_ferme:
                        must_be = accolade_ouvert;
                        break;
                }
                if (last_character != must_be) {
                    return false;
                } else {
                    ll.removeLast();
                }
            }
        }
        return true;
    }

}
