package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void testIsBalancedNoGrouping() {
        String s = "Je mange la pomme";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOneParenthesis() {
        String s = "Je mange la (pomme)";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOneBracket() {
        String s = "Je mange la {pomme}";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOneAngleBracket() {
        String s = "Je mange la [pomme]";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedMultipleSymbols() {
        String s = "Je (mange) {la} [pomme]";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedMultipleNestedSymbols() {
        String s = "Je (m[{a}n[g]]e) {la} [(po()m)me]";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneParenthesis() {
        String s = "()";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneBracket() {
        String s = "{}";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneAngleBracket() {
        String s = "[]";
        assertTrue(StringUtils.isBalanced(s));
    }
    
    @Test
    void testIsBalancedOnlyOneParenthesisIncorrect() {
        String s = "(}";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneParenthesisIncorrect1() {
        String s = "(";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneParenthesisIncorrect2() {
        String s = ")";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneBracketIncorrect() {
        String s = "{]";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneBracketIncorrect1() {
        String s = "{";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneBracketIncorrect2() {
        String s = "}";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneAngleBracketIncorrect() {
        String s = "[)";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneAngleBracketIncorrect1() {
        String s = "[";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlyOneAngleBracketIncorrect2() {
        String s = "]";
        assertFalse(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlySymbolsCorrect() {
        String s = "[({}{})[{{}}([])]]";
        assertTrue(StringUtils.isBalanced(s));
    }

    @Test
    void testIsBalancedOnlySymbolsIncorrect() {
        String s = "[({}{)}[{{}(}([])]";
        assertFalse(StringUtils.isBalanced(s));
    }
}