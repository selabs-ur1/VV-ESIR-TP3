package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Stack<Character> GroupingSymbols = new Stack<>();
        
        if(str==null) return true;
        
        for(int i = 0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            if(currentChar == '{' || currentChar== '[' || currentChar== '('){
                GroupingSymbols.push(currentChar);
            }
            if(currentChar=='}'){
                if(GroupingSymbols.peek()=='{'){
                    GroupingSymbols.pop();
                }
                else{
                    return false;
                }
                
            }
    
            else if(currentChar==']'){
                if(GroupingSymbols.peek()=='['){
                    GroupingSymbols.pop();
                }
                else{
                    return false;
                }
                
            }
    
            else if(currentChar==')'){
                if(GroupingSymbols.peek()=='('){
                    GroupingSymbols.pop();
                }
                else{
                    return false;
                }
                
            }
        }
        return GroupingSymbols.isEmpty();
    }

}
