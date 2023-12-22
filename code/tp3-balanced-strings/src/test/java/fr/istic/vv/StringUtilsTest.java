package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isBalanced1(){ //chaîne de longueur 0
        assertTrue(isBalanced(""));
    }
    @Test
    void isBalanced2(){ // chaîne de longueur 1 avec un type de symbole
        assertFalse(isBalanced("{"));
    }
    @Test
    void isBalanced3(){ // chaîne de longueur 1 avec 0 symbole et 1 autre caractère
        assertTrue(isBalanced("a"));
    }
    @Test
    void isBalanced4(){ // chaîne de longueur > 1 avec 0 symbole et d'autres caractères
        assertTrue(isBalanced("aa"));
    }
    @Test
    void isBalanced5(){ // chaîne de longueur 1 avec un type de symbole
        assertFalse(isBalanced("{"));
    }
    @Test
    void isBalanced6(){ // chaîne de longueur > 1 avec 2 types de symboles déséquilibrés
        assertFalse(isBalanced("{("));
    }
    @Test
    void isBalanced7(){ // chaîne de longueur > 1 avec 3 types de symboles déséquilibrés
        assertFalse(isBalanced("{[)"));
    }
    @Test
    void isBalanced8(){ // chaîne de longueur > 1 avec 1 type de symboles équilibré
        assertTrue(isBalanced("{}"));
    }
    @Test
    void isBalanced9(){ // chaîne de longueur > 1 avec 2 types de symboles équilibrés
        assertTrue(isBalanced("{()}"));
    }
    @Test
    void isBalanced10(){ // chaîne de longueur > 1 avec 3 types de symboles équilibrés
        assertTrue(isBalanced("{([])}"));
    }
    @Test
    void isBalanced11(){ // chaîne de longueur > 1 avec 1 type de symboles équilibré et un autre caractère
        assertTrue(isBalanced("{a}"));
    }
    @Test
    void isBalanced12(){ // chaîne de longueur > 1 avec 2 types de symboles équilibrés et un autre caractère
        assertTrue(isBalanced("{a(aaa)}"));
    }
    @Test
    void isBalanced13(){ // chaîne de longueur > 1 avec 3 types de symboles équilibrés et un autre caractère
        assertTrue(isBalanced("{a(aa[a]a)}"));
    }
    @Test
    void isBalanced14(){ // chaîne de longueur > 1 avec 1 type de symboles déséquilibré et un autre caractère
        assertFalse(isBalanced("{a"));
    }
    @Test
    void isBalanced15(){ // chaîne de longueur > 1 avec 2 types de symboles déséquilibrés et un autre caractère
        assertFalse(isBalanced("{a(}"));
    }
    @Test
    void isBalanced16(){ // chaîne de longueur > 1 avec 3 types de symboles déséquilibrés et un autre caractère
        assertFalse(isBalanced("{a(a]}"));
    }
}