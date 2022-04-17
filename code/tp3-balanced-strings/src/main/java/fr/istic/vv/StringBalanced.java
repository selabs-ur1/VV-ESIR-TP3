package Exercice3;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.engine.discovery.predicates.IsPotentialTestContainer;

public class StringBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isBalanced("{[][]}({})"));
		
		System.out.println(isBalanced("]["));
		System.out.println(isBalanced("([)]"));
		System.out.println(isBalanced("{"));
		System.out.println(isBalanced("{(}{}"));
		System.out.println(isBalanced("{}{}"));
		
	}

	public static boolean isBalanced(String str) {
		LinkedList<String> buffer = new LinkedList<String>();
		
		for(int i = 0; i<str.length();i++) {
			
			Character c = str.charAt(i);			
			
			if(c == '(' || c == '{' || c =='[') {
				buffer.push(c.toString());
			}
			
			if(c == ')' || c == ']' || c == '}') {
				if(!buffer.isEmpty() && buffer.getFirst().compareTo(opposite(c))==0 ) {
					buffer.pop();
				}else return false;
			}
			
		}
		
		if(!buffer.isEmpty()) return false;
		
		return true;
	}

	private static String opposite(Character c) {
		if(c.compareTo(')') == 0) return "(";
		if(c.compareTo(']') == 0) return "[";
		else return "{";
	}
}
