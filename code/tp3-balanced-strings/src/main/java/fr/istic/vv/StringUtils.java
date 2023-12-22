package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }    
            }
        }
        return stack.isEmpty();  
    }
}
