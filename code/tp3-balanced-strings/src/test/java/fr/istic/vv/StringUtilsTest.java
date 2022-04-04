package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    public void Vide() {
        assertTrue(isBalanced(""));
    }
    
    @Test
    public void ParenthesesSimple() {
        assertTrue(isBalanced("()"));
    }

    @Test
    public void CrochetsSimple() {
        assertTrue(isBalanced("[]"));
    }

    @Test
    public void AccoladesSimple() {
        assertTrue(isBalanced("{}"));
    }

    @Test
    public void ParenthesesIndexes() {
        assertTrue(isBalanced("(azert)a"));
    }

    @Test
    public void CrochetsIndexes() {
        assertTrue(isBalanced("[azert]a"));
    }

    @Test
    public void AccoladesIndexes() {
        assertTrue(isBalanced("{azert}a"));
    }

    @Test
    public void ParenthesesFalse() {
        assertFalse(isBalanced(")("));
    }

    @Test
    public void CrochetsFalse() {
        assertFalse(isBalanced("]["));
    }

    @Test
    public void AccoladesFalse() {
        assertFalse(isBalanced("}{"));
    }

    @Test
    public void MultiTrue() {
        assertTrue(isBalanced("([]{})"));
    }

    @Test
    public void MultiFalse() {
        assertFalse(isBalanced("([]{{})"));
    }

    @Test
    public void DesorderFalse() {
        assertFalse(isBalanced("([)]"));
    }
    

}