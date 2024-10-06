package fr.istic.vv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {
    /*      String Length     */

    @DisplayName("String Length : Short")
    @Test
    void isBalancedBlock1Length() {
        assertTrue(isBalanced(""));
        assertFalse(isBalanced("("));
        assertTrue(isBalanced("{}"));
        assertFalse(isBalanced("[)]"));
    }

    @DisplayName("String Length : Normal")
    @Test
    void isBalancedBlock2Length() {
        assertTrue(isBalanced("(())"));
        assertTrue(isBalanced("{[()]}"));
        assertFalse(isBalanced("[({}]"));
        assertFalse(isBalanced("{[[]}"));
    }

    @DisplayName("String Length : Long")
    @Test
    void isBalancedBlock3Length() {
        assertTrue(isBalanced("((()))()[]"));
        assertTrue(isBalanced("{[()()]}"));
        assertFalse(isBalanced("{[()(})]}"));
        assertFalse(isBalanced("{[[()()]}"));
    }

    /*      Types of Grouping Symbols       */

    @DisplayName("Types of Grouping Symbols : 1")
    @Test
    void isBalancedBlock1Types() {
        assertTrue(isBalanced("{}"));
        assertTrue(isBalanced("()"));
        assertFalse(isBalanced("[[]"));
        assertFalse(isBalanced("{}{"));
    }

    @DisplayName("Types of Grouping Symbols : 2")
    @Test
    void isBalancedBlock2Types() {
        assertTrue(isBalanced("()[]"));
        assertTrue(isBalanced("({})"));
        assertFalse(isBalanced("[{]}"));
        assertFalse(isBalanced("([)"));
    }

    @DisplayName("Types of Grouping Symbols : 3")
    @Test
    void isBalancedBlock3Types() {
        assertTrue(isBalanced("()[]{}"));
        assertTrue(isBalanced("[{()}]"));
        assertFalse(isBalanced("([})"));
        assertFalse(isBalanced("{[(])"));
    }

    /*      Correctness of the grouping       */

    @DisplayName("Correctness of the grouping : Only opening")
    @Test
    void isBalancedBlock1Correctness() {
        assertFalse(isBalanced("("));
        assertFalse(isBalanced("({"));
        assertFalse(isBalanced("({["));
        assertFalse(isBalanced("({(["));
    }

    @DisplayName("Correctness of the grouping : Only closing")
    @Test
    void isBalancedBlock2Correctness() {
        assertFalse(isBalanced(")"));
        assertFalse(isBalanced(")}"));
        assertFalse(isBalanced(")}]"));
        assertFalse(isBalanced(")})]"));
    }

    /*      Non grouping characters       */

    @DisplayName("Non grouping characters : Just them")
    @Test
    void isBalancedBlock1Characters() {
        assertTrue(isBalanced("abc"));
        assertTrue(isBalanced("123"));
        assertTrue(isBalanced("1a2b"));
        assertTrue(isBalanced("a4-5y"));
    }

    @DisplayName("Non grouping characters : Not only just them")
    @Test
    void isBalancedBlock2Characters() {
        assertTrue(isBalanced("(a)bc"));
        assertTrue(isBalanced("a{bc}"));
        assertFalse(isBalanced("(a(bc"));
        assertFalse(isBalanced("a{b]c}"));
    }
}