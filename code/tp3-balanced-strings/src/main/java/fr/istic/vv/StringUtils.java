package fr.istic.vv;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StringUtils {

    //private StringUtils() {}

    public static boolean isBalanced(String str) {
    	if(str==null) return true;
    	CharacterIterator it = new StringCharacterIterator(str);
    	Stack<Character> symbol = new Stack<Character>();
    	
    	Character[] openingSymbolTab = new Character[]{'(','[','{'};
    	ArrayList<Character> openingSymbol = new ArrayList<>(Arrays.asList(openingSymbolTab));
    	
    	Character[] closingSymbolTab = new Character[]{')',']','}'};
    	ArrayList<Character> closingSymbol = new ArrayList<>(Arrays.asList(closingSymbolTab));
    	
        while (it.current() != CharacterIterator.DONE)
        {        	
            if(openingSymbol.contains(it.current())) {	
            	symbol.push(it.current());
            } else if(symbol.isEmpty()) {
            	if(closingSymbol.contains(it.current())) {
            		return false;
            	}
            } else if((char)(it.current()-2)==symbol.peek() || it.current()==')') {
            	symbol.pop();
            }
            it.next();
        }
        return symbol.empty();
    }

}
