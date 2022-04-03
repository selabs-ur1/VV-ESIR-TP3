package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
		Stack<Character> s = new Stack<Character>();
		for(int i=0; i<str.length(); i++) {
			char currentChar = str.charAt(i);//
			
			if(currentChar=='(' || currentChar=='[' || currentChar=='{') {//
				s.add(currentChar);//
			}
			else {
				
				if(currentChar==')') {//
					if(s.isEmpty()) return false;//
					char previousSymbol = s.pop();//
					if(previousSymbol!='(') return false;//
				}
				
				if(currentChar==']') {//
					if(s.isEmpty()) return false;//
					char previousSymbol = s.pop();//
					if(previousSymbol!='[')	return false;//
				}
				
				if(currentChar=='}') {//
					if(s.isEmpty()) return false;//
					char previousSymbol = s.pop();//
					if(previousSymbol!='{')	return false;//
				}
			}
		}
		if(s.size()==0) return true;//
	    return false;//
    }

}
