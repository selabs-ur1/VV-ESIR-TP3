package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest
{
	
	@Test
	void voidTest()
	{
		assertTrue(StringUtils.isBalanced(""));
	}
	
	@Test
	void noneTest()
	{
		assertTrue(StringUtils.isBalanced("a"));
	}

	@Test
	void successifTest()
	{
		assertTrue(StringUtils.isBalanced("(){}[]"));
	}

	@Test
	void chaosvraiTest()
	{
		assertTrue(StringUtils.isBalanced("q{t(t[te(st)])p}"));
	}

	@Test
	void chevTest()
	{
		assertFalse(StringUtils.isBalanced("[(])"));
	}
	
	@Test
	void nbdiffTest()
	{
		assertFalse(StringUtils.isBalanced("[(]"));
	}
	
	@Test
	void ordreTest()
	{
		assertFalse(StringUtils.isBalanced(")("));
	}

	
}



/*
package fr.esir.mdi.ci.tpmaven;

import org.junit.Test;

import junit.framework.TestCase;

public class test extends TestCase {

	@Test
	public void testFirstPDF() throws Exception
	{
		System.out.println("coucou");
		//assertTrue(3*.4 == 1.2);
		double a = 3*.4;
		//System.out.println(typeOf(a));
		assertEquals(a, 1.2,0.001);
	}
	
	
}

*/