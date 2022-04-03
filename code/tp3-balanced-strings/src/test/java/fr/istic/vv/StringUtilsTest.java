package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
	
	@Test
	void strNull() {
		assertTrue(isBalanced(null));
	}

	@Test
	void strEmpty() {
		assertTrue(isBalanced(""));
	}
	
	@Test
	void strWithoutGroupingSymb() {
		assertTrue(isBalanced("Abc..cbA"));
	}
	
	@Test
	void strBalanced() {
	    assertTrue(isBalanced("{Val}id(at[ion])"));
	}
	
	@Test
	void strUnbalanced() {
	    assertFalse(isBalanced("Verif{i[]cation)"));
	}

	@Test
	void strOpeningSymbolText() {
	    assertFalse(isBalanced("[[({("));
	}

	@Test
	void strMostlyClosingSymbol() {
	    assertFalse(isBalanced("Test(ing}])"));
	}


	@Test
	void strPoorlyNested() {
	    assertFalse(isBalanced("Ab{cd]}efgh]ij"));
	}
	

}