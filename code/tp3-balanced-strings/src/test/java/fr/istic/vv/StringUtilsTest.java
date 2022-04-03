package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

@Test
void emptyInput() {
	assertTrue(isBalanced(""));
}

@Test 
void nullInput() {
	assertTrue(isBalanced(null));
}

@Test
void normalString() {
	assertTrue(isBalanced("Hello world!"));
}

@Test
void onlyOpeningSymbol() {
	assertFalse(isBalanced("[({{("));
}

@Test
void ClosingSymbolWithEmptyStack() {
	assertFalse(isBalanced("Hello world!]()"));
}

@Test
void unbalancedString() {
	assertFalse(isBalanced("[ouij(ezr()]}"));
}

@Test
void balancedString() {
	assertTrue(isBalanced("[oui{azeaz()[]}aze]"));
}

@Test
void poorlyNested() {
	assertFalse(isBalanced("hello(t[)rez]"));
}
}