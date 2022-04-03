package fr.istic.vv;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private StringUtils string;

    @BeforeEach
    protected void setUp()throws Exception{
        string = new StringUtils();
    }

    @Test
    public void testVide(){
        assertTrue(string.isBalanced(""));
    }
/*
    @Test
    public void testTwoSymbol(){
        assertTrue(string.isBalanced("()"));
    }
*/
    @Test
    public void testSimpleSymbols(){
        assertTrue(string.isBalanced("()[]{}"));
    }

    @Test
    public void testImbriquedSymbols(){
        assertTrue(string.isBalanced("{}[()[()]{}]()"));
    }

    @Test
    public void testImbriquedSymbolsWithOtherCharacters(){
        assertTrue(string.isBalanced("public class StringUtils {" +
                "public StringUtils(String s){" +
                "char c = s.charAt(0);" +
                "}" +
                "}"));
    }

    /*
    @Test
    public void testErrorOnSymbol(){
        assertFalse(string.isBalanced("("));
    }
     */

    @Test
    public void testErrorTwoSymbol(){
        assertFalse(string.isBalanced("(}"));
    }

    @Test
    public void testErrorTwoSymbol2(){
        assertFalse(string.isBalanced("(]"));
    }

    @Test
    public void testErrorWrongOrder(){
        assertFalse(string.isBalanced("({[][)}]"));
    }

    @Test
    public void testErrorWithOtherCharacters(){
        assertFalse(string.isBalanced("if(((true==true) && true)"));
    }

}