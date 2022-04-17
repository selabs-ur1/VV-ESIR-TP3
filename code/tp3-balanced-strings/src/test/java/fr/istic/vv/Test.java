package Exercice1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class Test {

	@org.junit.jupiter.api.Test
	void test1() {
		assertEquals(3 * .4,  1.2, 0.0000000001);
	}

	@org.junit.jupiter.api.Test
	void test21() {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		a.add("Hello");
		b.add("Hello");
		
		assertEquals(a,b);
	}
	
	@org.junit.jupiter.api.Test
	void test22() {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		a.add("Hello");
		b.add("Hello");
		
		assertSame(a,b);
	}
	
	@org.junit.jupiter.api.Test
	void test23() {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		a.add("Hello");
		b.add("Hello");
		
		assertEquals(a,b);
	}
	
	@org.junit.jupiter.api.Test
	void test24() {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		
		a.add("Hello");
		b = a;
		
		assertSame(a,b);
	}
	
	@org.junit.jupiter.api.Test
	void test3() {
		try {
	         fail("AAAAAAAAAAAA");
	     } catch (final RuntimeException e) {
	         assertTrue(true);
	     }
	}
}
