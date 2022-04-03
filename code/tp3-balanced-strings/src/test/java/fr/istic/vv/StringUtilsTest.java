package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
	@Test
	void testIsBalancedNoSymbol() {
		String s1 = "";
		String s2 = "lucas";
		assertTrue(isBalanced(s1));
		assertTrue(isBalanced(s2));
	}

	@Test
	void testIsBalancedStartsWithClosingSymbol() {
		String s1 = "][";
		String s2 = ")(";
		String s3 = "}{";
		assertFalse(isBalanced(s1));
		assertFalse(isBalanced(s2));
		assertFalse(isBalanced(s3));
	}

	@Test
	void testIsBalancedOnlyOneSymbolSimple() {
		String s1 = "[]";
		String s2 = "()";
		String s3 = "{}";
		assertTrue(isBalanced(s1));
		assertTrue(isBalanced(s2));
		assertTrue(isBalanced(s3));
	}

	@Test
	void testIsBalancedOnlyOneSymbol() {
		String s1 = "[[][][[]]]";
		String s2 = "()(()(()))";
		String s3 = "{{}{}{{}}}";
		assertTrue(isBalanced(s1));
		assertTrue(isBalanced(s2));
		assertTrue(isBalanced(s3));
	}

	@Test
	void testIsBalancedCorrectMultipleSymbols() {
		String s = "([]{{}()})";
		assertTrue(isBalanced(s));
	}

	@Test
	void testIsBalancedIncorrectMultipleSymbols() {
		String s = "({[}])";
		assertFalse(isBalanced(s));
	}

	@Test
	void testIsBalancedCorrectWithCharacters() {
		String s = "(zdqzf[gqzg]jfkjS{KIUBf{qkzyf}Huqyfy(mpfuq iqohfb) oiseufb! }qf?);;";
		assertTrue(isBalanced(s));
	}

	@Test
	void testIsBalancedIncorrectWithCharacters() {
		String s1 = "zhjqgb (fqekje %%{filn!![oigiubn%}klfh!]qzflmn;)zqlkufb;";
		String s2 = ":mf[l[m)}]nz[{[qiu}]}]vfy()bsiobjiodqzm)ouv]yhiu";
		String s3 = "q((]of}hg[4v{( }t86g)}[by)tokbv)[6}545[{p)]]{]]8q{'n)5ub";
		assertFalse(isBalanced(s1));
		assertFalse(isBalanced(s2));
		assertFalse(isBalanced(s3));
	}
	
	@Test
	void testIsBalancedNotEnoughClosings() {
		String s = "((((())))";
		assertFalse(isBalanced(s));		
	}

}