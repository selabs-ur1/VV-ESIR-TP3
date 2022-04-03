package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
	
	@Test
	public void testNull() {
		assertFalse(isBalanced(null),"Test should pass. String is null");
	}
	
	@Test
	public void testNoGroupingSymbols() {
		assertTrue(isBalanced("string"),"Test should pass. String does not have grouping symbols");
	}
	
	@Test
	public void testEvenInOrder() {
		assertTrue(isBalanced("[[()string{}]]"),"Test should pass. String has an even number of symbols and they are in order");
	}
	
	@Test
	public void testEvenNotInOrder() {
		assertFalse(isBalanced("[[)(string{}]]"),"Test should pass. String has an even number of symbols and they are not in order");
	}
	
	@Test
	public void testOddParenthesesOpeningInOrder() {
		assertFalse(isBalanced("[[(string{}]]"),"Test should pass. String has an odd number of parentheses and they are in order. There are more opening symbols.");
	}
	
	@Test
	public void testOddBracketsOpeningInOrder() {
		assertFalse(isBalanced("[[[string{}]]"),"Test should pass. String has an odd number of brackets and they are in order. There are more opening symbols.");
	}
	
	@Test
	public void testOddBracesOpeningInOrder() {
		assertFalse(isBalanced("[[{string{}]]"),"Test should pass. String has an odd number of braces and they are in order. There are more opening symbols.");
	}
	
	@Test
	public void testOddParenthesesClosingInOrder() {
		assertFalse(isBalanced("[[string{}]])"),"Test should pass. String has an odd number of parentheses and they are in order. There are more closing symbols.");
	}
	
	@Test
	public void testOddBracketsClosingInOrder() {
		assertFalse(isBalanced("[[string{}]]]"),"Test should pass. String has an odd number of brackets and they are in order. There are more closing symbols.");
	}
	
	@Test
	public void testOddBracesClosingInOrder() {
		assertFalse(isBalanced("[[string{}]]}"),"Test should pass. String has an odd number of braces and they are in order. There are more closing symbols.");
	}
	@Test
	public void testOddOpeningNotInOrder() {
		assertFalse(isBalanced("[[(string}{]]"),"Test should pass. String has an odd number of symbols and they are in order. There are more opening symbols.");
	}
	
	@Test
	public void testOddClosingNotInOrder() {
		assertFalse(isBalanced("[[string}{]])"),"Test should pass. String has an odd number of symbols and they are in order. There are more closing symbols.");
	}
}