package fr.istic.vv;

import java.util.Stack;

public class StringUtils 
{

    private StringUtils() {}

    public static boolean isBalanced(String str) 
    {
    	if(str.length()==0)
    	{
    		return true;
    	}
    	
    	Stack<Character> pile = new Stack<Character>();
    	char current = ' ';
    	
    	for(int i=0; i<str.length();i++)
    	{
    		current = str.charAt(i);
    		if (current == '(' || current == '[' || current == '{' ) 
    		{
    			pile.add(current);
    		}
    		
    		if (current == ')' || current == ']' || current == '}' ) 
    		{
    			if (pile.isEmpty())
    			{
    				return false;
    			}
    			char top = pile.peek();
    			if ((top == '(' && current == ')') || (top == '[' && current == ']') || (top == '{' && current == '}'))
    			{
    				pile.pop();
    			}
    			else
    			{
    				return false;
    			}
    		}
    	}
    	
    	return pile.isEmpty();
    }

}
