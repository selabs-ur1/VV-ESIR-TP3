package fr.istic.vv;

import java.util.ArrayList;

public class StringUtils {

    public static boolean isBalanced(String str) {
        ArrayList<Character> characters = new ArrayList<>();
        for(Character car : str.toCharArray()){

            // Verify if the character is a starting bracket/parenthesis/brace
            if(car == '(' || car == '[' || car == '{'){
                characters.add(car);
            }

            // Verify if the character is a closing bracket/parenthesis/brace
            else if(car == ')' || car == ']' || car == '}'){

                // Verify if there is no starting bracket/parenthesis/brace -> not balanced
                if(characters.isEmpty()){
                    return false;
                }
                else{

                    // Get the last character in the list
                    char last = characters.get(characters.size()-1);

                    // Verify if the last character is the same type of bracket/parenthesis/brace
                    if((car == ')' && last == '(') || (car == ']' && last == '[') || (car == '}' && last == '{')){
                        characters.remove(characters.size()-1);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        
        return characters.isEmpty();
    }

}
