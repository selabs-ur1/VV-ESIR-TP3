package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;


class StringUtilsTest {

    /******************** Input Space Partitioning ********************/

    /****Tests Q1 ****/

    // B1 : pas de contenu textuel supplementaire => vrai
    @Test
    void testNoText() {
        assertTrue(isBalanced("({}[])"));
    }

    // B2 : contenu textuel supplementaire symetrique => vrai
    @Test
    void testSymetricText() {
        assertTrue(isBalanced("(a(b(c)d)e)"));
    }

    // B3 : contenu textuel supplementaire non symetrique => vrai
    @Test
    void testNonSymetricText() {
        assertTrue(isBalanced("(a(b(c)))"));
    }

    /****Tests Q2 ****/
    // B1 : chaine vide => vrai 
    @Test
    void testEmptyString() {
        assertTrue(isBalanced(""));
    }

    // B2 : une ouverture par fermeture => vrai
    @Test
    void testOneOpenClose() {
        assertTrue(isBalanced("(()(())())"));
    }

    //B3 : moins d'une fermeture par ouverture => faux
    @Test
    void testLessCloseThanOpen() {
        assertFalse(isBalanced("(()(())("));
    }

    /****Tests Q3 ****/

    // B1 => impossible

    // B2 => ordre fermeture/ouverture respecte => vrai
    @Test
    void testOrderRespected() {
        assertTrue(isBalanced("([]{}[{}()])"));
    }

    // B3 => ordre fermeture/ouverture non respecte => faux
    @Test
    void testOrderNotRespected() {
        assertFalse(isBalanced("([)]"));
    }


    /******************** Test coverage ********************/

    // Input Space Partitioningis sufficient to cover all the code

    /******************** Logic test ********************/

    @Test 
    void testBranchCoverageBrackets() {
        assertFalse(isBalanced("(]"));
    }

    @Test 
    void testBranchCoverageBraces() {
        assertFalse(isBalanced("(}"));
    }


    /******************** Mutation score ********************/

    @Test
    void testClassSignature() {
        StringUtils stringUtils = new StringUtils();
        assertTrue(stringUtils.isBalanced("({}[])"));
    }


}