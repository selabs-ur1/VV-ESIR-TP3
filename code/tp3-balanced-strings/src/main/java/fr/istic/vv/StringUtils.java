package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    /*
    public static void main (String[] args){
        System.out.println(isBalanced("{[()]}())[]"));
    }
    */

    private StringUtils() {}

    public static boolean isBalanced(String str) {

        if (str == null) return true ;

        Stack<Character> pile = new Stack<Character>();

        for (int i=0; i < str.length(); i++){

            char actualChar = str.charAt(i);

            if (pile.empty()){
                pile.push(actualChar);
            }
            else if ((actualChar == '}' && pile.peek() == '{') 
            || (actualChar == ']' && pile.peek() == '[') 
            || (actualChar == ')' && pile.peek() == '(')){
                pile.pop();
            }
            else {
                pile.push(actualChar);
                
            }
            
            
        }
        return pile.empty();
    }


}
