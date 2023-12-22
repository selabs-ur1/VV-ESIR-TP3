package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testEmptyString() {
        assertTrue(isBalanced(""));
    }

    @Test
    void testSingleSymbol() {
        assertFalse(isBalanced("{"));
        assertFalse(isBalanced("["));
        assertFalse(isBalanced("("));
        assertFalse(isBalanced("}"));
        assertFalse(isBalanced("]"));
        assertFalse(isBalanced(")"));
    }

    @Test
    void testBalancedStringSingleType() {
        assertTrue(isBalanced("{[]}"));
        assertTrue(isBalanced("()"));
        assertTrue(isBalanced("{[()()]}"));
    }

    @Test
    void testUnbalancedStringSingleType() {
        assertFalse(isBalanced("{]"));
        assertFalse(isBalanced("([)"));
        assertFalse(isBalanced("}("));
    }

    @Test
    void testBalancedStringMixedTypes() {
        assertTrue(isBalanced("{[]()}"));
        assertTrue(isBalanced("[{()}]"));
    }

    @Test
    void testUnbalancedStringMixedTypes() {
        assertFalse(isBalanced("{[()]}"));
        assertFalse(isBalanced("{]}"));
    }

    // Add more test cases as needed to cover different scenarios

}
