package fr.istic.vv;

import org.junit.jupiter.api.Test;
import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    
    @Test
    void testChaineVide() {
        assertTrue(isBalanced(""));
    }

    @Test
    void testSymbolesEquilibres() {
        assertTrue(isBalanced("{[()]}"));
    }

    @Test
    void testSymbolesDesequilibres() {
        assertFalse(isBalanced("{[(])}"));
    }

    @Test
    void testAutresCaracteres() {
        assertTrue(isBalanced("abc123"));
    }

    @Test
    void testSymboleFermetureRedondant() {
        assertFalse(isBalanced("{[()]}]"));
    }

    @Test
    void testSymboleFermetureNonApparie() {
        assertFalse(isBalanced("{[(])"));
    }


}
