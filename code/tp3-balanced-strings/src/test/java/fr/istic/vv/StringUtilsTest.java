package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

   @Test
   public void emptyString(){
       String toTest = "";
       assertTrue(isBalanced(toTest));
   }


    @Test
    public void curlyBrace(){
        String toTest = "{";
        assertFalse(isBalanced(toTest));
    }
    @Test
    public void parentheses(){
        String toTest = "(";
        assertFalse(isBalanced(toTest));
    }

    @Test
    public void bracket(){
        String toTest = "[";
        assertFalse(isBalanced(toTest));
    }

    @Test
    public void closingBracket(){
        String toTest = "]";
        assertFalse(isBalanced(toTest));
    }

    @Test
    public void closingParenthese(){
       String toTest = ")";
       assertFalse(isBalanced(toTest));
    }

    @Test
    public void closingBrace(){
       String toTest = "}";
       assertFalse(isBalanced(toTest));
    }

    @Test
    public void stringNull(){
       String toTest = null;
       Exception exception = assertThrows(IllegalArgumentException.class, () -> isBalanced(toTest));

       String expectedMessage = "String cannot be null";
       assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void balancedString(){
       String toTest = "(){}";
       assertTrue(isBalanced(toTest));
    }

    @Test
    public void randomChar(){
       String toTest = "gfds[fhdglf]flkdvglk({{}})";
       assertTrue(isBalanced(toTest));
    }

}