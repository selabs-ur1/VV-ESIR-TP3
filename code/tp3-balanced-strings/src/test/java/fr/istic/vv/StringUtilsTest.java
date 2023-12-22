package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
  @Test
  public void testChaineVide(){
       assertTrue(isBalanced(""));
  }
  @Test
  public void testAlphanum(){
    assertTrue(isBalanced("Hello World!"));
  }
  @Test
  public void testCaraUniqueOuvrant(){
      assertFalse(isBalanced("{"));
  }
  @Test
  public void testBalanced(){
      assertTrue(isBalanced("{([])}"));
  }
  @Test
  public void testUnbalanced(){
      assertFalse(isBalanced("{(})"));
  }
  @Test
  public void testCaraUniqueFermant(){
      assertFalse(isBalanced(")"));
  }
}
