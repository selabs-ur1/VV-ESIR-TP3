package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

	private StringUtils() {
	}

	public static boolean isBalanced(String str) {
		if(str == null) return false;
		Stack<Character> stack = new Stack<Character>();
		for (char chr : str.toCharArray()) {
			switch (chr) {
			case ('{'):
				stack.push(chr);
				break;
			case '(':
				stack.push(chr);
				break;
			case '[':
				stack.push(chr);
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[')
					return false;
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(')
					return false;
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{')
					return false;
				break;
			}
		}
		return stack.isEmpty();
	}
}
