package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class StringUtilsTest {

    private String s;
    
    @Test
    public void inputDomain(){
        s = null;
        assertTrue(isBalanced(s), "Un string null doit renvoyer true");

        s = "";
        assertTrue(isBalanced(s), "Un string vide est balance");

        s = "{";
        assertFalse(isBalanced(s));

        s = "(";
        assertFalse(isBalanced(s));

        s = "[";
        assertFalse(isBalanced(s));
    }

    @Test
    public void simplebalanced(){

        s = "[]";
        assertTrue(isBalanced(s));

        s = "()";
        assertTrue(isBalanced(s));

        s = "{}";
        assertTrue(isBalanced(s));
    }

    @Test
    public void surrounded(){

        s = "([])";
        assertTrue(isBalanced(s));

        s = "({[]})";
        assertTrue(isBalanced(s));
    }

    @Test
    public void entangle(){

        s = "([)]";
        assertFalse(isBalanced(s));

        s = "{([)}]";
        assertFalse(isBalanced(s));

    }

    @Test
    public void addition(){

        s = "()()";
        assertTrue(isBalanced(s));

        s = "([]){()}";
        assertTrue(isBalanced(s));

    }

    @Test
    public void random(){

        s = "(}";
        assertFalse(isBalanced(s));

        s = "](}({";
        assertFalse(isBalanced(s));

    }
}