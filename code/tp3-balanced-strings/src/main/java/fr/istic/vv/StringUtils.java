package fr.istic.vv;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StringUtils {

    public StringUtils() {}

    public boolean isOpenSymbol(char c){
        return c == '[' || c == '(' || c == '{';
    }

    public boolean isCloseSymbol(char c){
        return c == ']' || c == ')' || c == '}';
    }

    public boolean isBalanced(String str){
        Stack<Character> groupingSymbols = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            if(isOpenSymbol(str.charAt(i))){
                groupingSymbols.push(str.charAt(i));
            }
            else{
                if(isCloseSymbol(str.charAt(i))){
                    if(str.charAt(i)==']' && !(groupingSymbols.pop() == '[')){
                        return false;
                    }
                    else if(str.charAt(i)==')' && !(groupingSymbols.pop() == '(')){
                        return false;
                    }
                    else if(str.charAt(i)=='}' && !(groupingSymbols.pop() == '{')){
                        return false;
                    }
                }
            }
        }
        return groupingSymbols.empty();
    }

}
