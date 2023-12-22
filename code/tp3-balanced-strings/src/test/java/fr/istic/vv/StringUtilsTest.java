package test.java.fr.istic.vv;

import org.junit.jupiter.api.Test;
import static main.java.fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    // Pour une chaîne vide
    @Test
    public void testIsBalancedEmptyString(){
        String val = "";

        assertEquals(true, isBalanced(val));
    }

    // Parenthèses équilibrées
    @Test
    public void testIsBalancedBalanced1(){
        String val = "{}";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses équilibrées
    @Test
    public void testIsBalancedBalanced2(){
        String val = "[()]";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses équilibrées
    @Test
    public void testIsBalancedBalanced3(){
        String val = "{[()]}";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses équilibrées
    @Test
    public void testIsBalancedBalanced4(){
        String val = "((()))";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses non équilibrées
    @Test
    public void testIsBalancedUnbalanced1(){
        String val = "{[}";

        boolean res = isBalanced(val);

        assertEquals(false, res);
    }

    // Parenthèses non équilibrées
    @Test
    public void testIsBalancedUnbalanced2(){
        String val = "(())]";

        boolean res = isBalanced(val);

        assertEquals(false, res);
    }

    // Parenthèses non équilibrées
    @Test
    public void testIsBalancedUnbalanced3(){
        String val = "(()))";

        boolean res = isBalanced(val);

        assertEquals(false, res);
    }

    // Parenthèses mélangées
    @Test
    public void testIsBalancedMixed1(){
        String val = "{[()]}";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses mélangées
    @Test
    public void testIsBalancedMixed2(){
        String val = "([)]";

        boolean res = isBalanced(val);

        assertEquals(false, res);
    }

    // Autres caractères
    @Test
    public void testIsBalancedOther1(){
        String val = "abc";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Autres caractères
    @Test
    public void testIsBalancedOther2(){
        String val = "123";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Autres caractères
    @Test
    public void testIsBalancedOther3(){
        String val = "abc(def)123";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses emboîtées
    @Test
    public void testIsBalancedNested1(){
        String val = "({})";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses emboîtées
    @Test
    public void testIsBalancedNested2(){
        String val = "{[()]}";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }

    // Parenthèses emboîtées
    @Test
    public void testIsBalancedNested3(){
        String val = "((()))";

        boolean res = isBalanced(val);

        assertEquals(true, res);
    }
}
