package fr.istic.vv;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static fr.istic.vv.Date.*;
import static org.junit.jupiter.api.Assertions.*;

class DateTest 
{
	@Test
	void basicTest()
	{
		assertTrue(isValidDate(29,2,2020));
	}
	
	@Test
	void notValidMonth()
	{
		assertThrows(Exception.class, () -> new Date(1,-1,2000));
		assertThrows(Exception.class, () -> new Date(1,13,2000));
	}
	
	@Test
	void notValidDayTest()
	{
		assertThrows(Exception.class, () -> new Date(29,2,2019));
		assertThrows(Exception.class, () -> new Date(-1,2,2019));
	}
	
	@Test
	void nextGenTest() throws Exception
	{
		Date d = new Date(1,1,2000);
		Date res = d.nextDate();
		Date oracle = new Date(2,1,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	
	@ParameterizedTest
    @ValueSource(ints = {4, 6, 9, 11})
	void next30Test(int m) throws Exception
	{
		Date d = new Date(30,m,2000);
		Date res = d.nextDate();
		Date oracle = new Date(1,m+1,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@ParameterizedTest
    @ValueSource(ints = {1,3,5,7,8,10})
	void next31Test(int m) throws Exception
	{
		Date d = new Date(31,m,2000);
		Date res = d.nextDate();
		Date oracle = new Date(1,m+1,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void next28Test() throws Exception
	{
		Date d = new Date(28,2,2001);
		Date res = d.nextDate();
		Date oracle = new Date(1,3,2001);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void next28100Test() throws Exception
	{
		Date d = new Date(28,2,1900);
		Date res = d.nextDate();
		Date oracle = new Date(1,3,1900);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void next294Test() throws Exception
	{
		Date d = new Date(29,2,2016);
		Date res = d.nextDate();
		Date oracle = new Date(1,3,2016);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void next29400Test() throws Exception
	{
		Date d = new Date(29,2,2000);
		Date res = d.nextDate();
		Date oracle = new Date(1,3,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void nextNewYearTest() throws Exception
	{
		Date d = new Date(31,12,2000);
		Date res = d.nextDate();
		Date oracle = new Date(1,1,2001);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}

	
	
	
	
	
	
	@Test
	void previousGenTest() throws Exception
	{
		Date d = new Date(2,1,2000);
		Date res = d.previousDate();
		Date oracle = new Date(1,1,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	
	@ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 9, 11})
	void previous31Test(int m) throws Exception
	{
		Date d = new Date(1,m,2000);
		Date res = d.previousDate();
		Date oracle = new Date(31,m-1,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@ParameterizedTest
    @ValueSource(ints = {5, 7, 10, 12})
	void previous30Test(int m) throws Exception
	{
		Date d = new Date(1,m,2000);
		Date res = d.previousDate();
		Date oracle = new Date(30,m-1,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void previous28Test() throws Exception
	{
		Date d = new Date(1,3,2001);
		Date res = d.previousDate();
		Date oracle = new Date(28,2,2001);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void previous28100Test() throws Exception
	{
		Date d = new Date(1,3,1900);
		Date res = d.previousDate();
		Date oracle = new Date(28,2,1900);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void previous294Test() throws Exception
	{
		Date d = new Date(1,3,2016);
		Date res = d.previousDate();
		Date oracle = new Date(29,2,2016);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void previous29400Test() throws Exception
	{
		Date d = new Date(1,3,2000);
		Date res = d.previousDate();
		Date oracle = new Date(29,2,2000);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	@Test
	void previousNewYearTest() throws Exception
	{
		Date d = new Date(1,1,2000);
		Date res = d.previousDate();
		Date oracle = new Date(31,12,1999);
		
		assertEquals(res.d,oracle.d);
		assertEquals(res.m,oracle.m);
		assertEquals(res.y,oracle.y);
	}
	
	
	
	@Test
	void compareEqualsTest() throws Exception
	{
		Date d1 = new Date(1,1,2000);
		Date d2 = new Date(1,1,2000);
		
		int res = d1.compareTo(d2);
		
		assertTrue(res == 0);
	}
	
	@Test
	void compareNullTest() throws Exception
	{
		Date d1 = new Date(1,1,2000);
		Date d2 = null;
		
		assertThrows(NullPointerException.class, () -> d1.compareTo(d2));
		
	}
	
	@Test
	void compareLessYTest() throws Exception
	{
		Date d1 = new Date(2,2,1999);
		Date d2 = new Date(1,1,2000);
		
		int res = d1.compareTo(d2);
		
		assertTrue(res < 0);
	}
	
	@Test
	void compareLessMTest() throws Exception
	{
		Date d1 = new Date(2,1,2000);
		Date d2 = new Date(1,2,2000);
		
		int res = d1.compareTo(d2);
		
		assertTrue(res < 0);
	}
	
	@Test
	void compareLessDTest() throws Exception
	{
		Date d1 = new Date(1,1,2000);
		Date d2 = new Date(2,1,2000);
		
		int res = d1.compareTo(d2);
		
		assertTrue(res < 0);
	}
	
	@Test
	void compareGreatYTest() throws Exception
	{
		Date d1 = new Date(1,1,2001);
		Date d2 = new Date(2,2,2000);
		
		int res = d1.compareTo(d2);
		
		assertTrue(res > 0);
	}
	
	@Test
	void compareGreatMTest() throws Exception
	{
		Date d1 = new Date(1,2,2000);
		Date d2 = new Date(2,1,2000);
		
		int res = d1.compareTo(d2);
		
		assertTrue(res > 0);
	}
	
	@Test
	void compareGreatDTest() throws Exception
	{
		Date d1 = new Date(2,1,2000);
		Date d2 = new Date(1,1,2000);
		
		int res = d1.compareTo(d2);
		
		assertTrue(res > 0);
	}
	
	
}