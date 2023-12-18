package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void emptyStringTest() {
        assertTrue(isBalanced(""));
    }

    @Test
    void sameTypeParenthesisTest() {
        assertTrue(isBalanced("()"));
    }

    @Test
    void differentTypeTest() {
        assertFalse(isBalanced("{)"));
    }

    @Test
    void serieSameTypeTest() {
        assertTrue(isBalanced("{}()[]"));
    }

    @Test
    void symetricTest() {
        assertTrue(isBalanced("({[]})"));
    }

    @Test
    void onlyOpenTest() {
        assertFalse(isBalanced("(("));
    }

    @Test
    void onlyCloseTest() {
        assertFalse(isBalanced("))"));
    }

    @Test
    void inversedTest() {
        assertFalse(isBalanced(")("));
    }

    @Test
    void alternateTest() {
        assertFalse(isBalanced("({)}"));
    }

    @Test
    void stringInsideTest() {
        assertTrue(isBalanced("(vérificationvalidation)"));
    }

    @Test
    void stringMiddleTest() {
        assertTrue(isBalanced("vérificati(onva)lidation"));
    }
}