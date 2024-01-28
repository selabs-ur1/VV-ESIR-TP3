package fr.istic.vv;

import java.util.ArrayList;
import java.util.Iterator;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) throws IllegalArgumentException {
        ArrayList<Character> tmp = new ArrayList<Character>();
        if(str==null) {
            throw new IllegalArgumentException("String cannot be null");
        }

            Iterator<Character> it = str.chars().mapToObj(c -> (char) c).iterator();

            while (it.hasNext()) {
                switch (it.next()) {

                    case '{':
                        tmp.add('{');
                        break;

                    case '[':
                        tmp.add('[');
                        break;

                    case '(':
                        tmp.add('(');
                        break;

                    case '}':

                        if (!tmp.isEmpty() && tmp.get(tmp.size()-1).equals('{')) {
                            tmp.remove(tmp.size()-1);

                        } else {
                            return false;
                        }
                        break;

                    case ']':

                        if (!tmp.isEmpty() && tmp.get(tmp.size()-1).equals('[')) {
                        tmp.remove(tmp.size()-1);

                        } else {
                            return false;
                        }
                        break;

                    case ')':

                        if (!tmp.isEmpty() &&tmp.get(tmp.size()-1).equals('(')) {
                            tmp.remove(tmp.size()-1);

                        } else {
                            return false;
                        }
                        break;

                }
            }
        return tmp.isEmpty();
    }

}
