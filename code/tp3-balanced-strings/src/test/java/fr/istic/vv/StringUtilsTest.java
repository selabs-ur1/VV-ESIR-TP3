package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testBalancedEmptyString() {
        assertTrue(StringUtils.isBalanced(""));
    }

    @Test
    void testBalanced() {
        assertTrue(StringUtils.isBalanced("[{()}]"));
    }

    @Test
    void testNotBalanced() {
        assertFalse(StringUtils.isBalanced("{[]"));
    }

    @Test
    void testNotBalanced2() {
        assertFalse(StringUtils.isBalanced("{[}]"));
    }

    @Test
    void testNotBalanced3() {
        assertFalse(StringUtils.isBalanced("[{(]"));
    }

    @Test
    void testNotBalancedOneParenthesis() {
        assertFalse(StringUtils.isBalanced(")"));
    }

    @Test
    void testNotBalancedOneBracket() {
        assertFalse(StringUtils.isBalanced("]"));
    }

    @Test
    void testNotBalancedOneBracket2() {
        assertFalse(StringUtils.isBalanced("}"));
    }

    @Test
    void testNotBalancedMismatched() {
        assertFalse(StringUtils.isBalanced("(]"));
    }

    @Test
    void testNotBalancedMismatched2() {
        assertFalse(StringUtils.isBalanced("[)"));
    }

    @Test
    void testNotBalancedMismatched3() {
        assertFalse(StringUtils.isBalanced("[}"));
    }

    @Test
    void testBalancedRandomCharacters() {
        assertTrue(StringUtils.isBalanced("abcd1234"));
    }

    @Test
    void testBalancedRandomCharactersWithParenthesis() {
        assertTrue(StringUtils.isBalanced("abcd(12[3{4}])"));
    }
}