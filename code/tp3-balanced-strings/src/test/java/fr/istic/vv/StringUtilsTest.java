package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void testBalancedStringsVoid() {
        String str = "";
        assertEquals(true, isBalanced(str), "Element on top of the stack should be true");
    }
    @Test
    public void testBalancedStringsNoGrouping() {
        String str = "aaa";
        assertEquals(true, isBalanced(str), "Element on top of the stack should be true");
    }
    @Test
    public void testBalancedStringsOne() {
        String str = "()";
        assertEquals(true, isBalanced(str), "Element on top of the stack should be true");
    }
    @Test
    public void testBalancedStringsConcatenate() {
        String str = "(){}[]";
        assertEquals(true, isBalanced(str), "Element on top of the stack should be true");
    }
    @Test
    public void testBalancedStringsFalse() {
        String str = "({)}[]";
        assertEquals(false, isBalanced(str), "Element on top of the stack should be true");
    }
    @Test
    public void testBalancedStringsComplex() {
        String str = "[[{}(([])){}]]";
        assertEquals(true, isBalanced(str), "Element on top of the stack should be true");
    }
    @Test
    public void testBalancedStringsComplexFalse() {
        String str = "[{]}{(}([])";
        assertEquals(false, isBalanced(str), "Element on top of the stack should be true");
    }
    @Test
    public void testBalancedStringsComplexChars() {
        String str = "[{aa()bb(o)}]";
        assertEquals(true, isBalanced(str), "Element on top of the stack should be true");
    }

}