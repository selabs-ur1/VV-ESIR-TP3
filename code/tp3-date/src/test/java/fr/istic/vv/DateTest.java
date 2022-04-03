package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

// Test Constructor and isValidDate
	@Test
	void testInvalidDateLeapYear() {
		try{
			new Date(29, 2, 2001);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateMonthSupTwelve() {
		try{
			new Date(15, 18, 1999);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateMonthInfOne() {
		try{
			new Date(15, -4, 1999);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateDaySupMaxMonth() {
		try{
			new Date(35, 2, 2018);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateDayInfOne() {
		try{
			new Date(0, 2, 2018);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testValidDate() {
		try{
			new Date(17, 5, 2000);
			new Date(8, 3, 2000);
			new Date(29, 2, 2000);
			new Date(25, 12, 2845);
		} catch(Exception e) {
			fail("Unexpected exception was thrown");
		}
	}
	
	@Test
	void testValidDateWithoutConstructor() {
		assertTrue(Date.isValidDate(1, 1, -1456));
		assertTrue(Date.isValidDate(31, 12, 7891213));
		assertTrue(Date.isValidDate(15, 8, 1));
		assertTrue(Date.isValidDate(31, 10, -4));
	}
	
	@Test
	void testInValidDateWithoutConstructor() {
		assertFalse(Date.isValidDate(-45, 11, -1456));
		assertFalse(Date.isValidDate(32, 1, 65));
		assertFalse(Date.isValidDate(15, 15, 15));
		assertFalse(Date.isValidDate(0, 0, 0));
		assertFalse(Date.isValidDate(14, 13, 204));
		assertFalse(Date.isValidDate(27, 0, 1028));
		assertFalse(Date.isValidDate(0, 2, 2000));
		assertFalse(Date.isValidDate(30, 2, 2024));
	}
	
// Test isLeapYear
	
	@Test
	void testLeapYear() {
		assertTrue(Date.isLeapYear(2000));
		assertTrue(Date.isLeapYear(2020));
		assertTrue(Date.isLeapYear(2028));
	}
	
	@Test
	void testNotLeapYear() {
		assertFalse(Date.isLeapYear(2002));
		assertFalse(Date.isLeapYear(1900));
		assertFalse(Date.isLeapYear(2019));
	}
	
// Test nextDate
	
	@Test
	void testNextDate() throws Exception {
		Date date1 = new Date(29, 2, 2000);
		Date date2 = new Date(31, 12, 2048);
		Date date3 = new Date(30, 4, 2000);
		Date date4 = new Date(17, 5, 2545);
		
		date1 = date1.nextDate();
		date2 = date2.nextDate();
		date3 = date3.nextDate();
		date4 = date4.nextDate();
		
		assertTrue(date1.day == 1 && date1.month == 3 && date1.year == 2000);
		assertTrue(date2.day == 1 && date2.month == 1 && date2.year == 2049);
		assertTrue(date3.day == 1 && date3.month == 5 && date3.year == 2000);
		assertTrue(date4.day == 18 && date4.month == 5 && date4.year == 2545);
	}
	
// Test previousDate
	
	@Test
	void testPreviousDate() throws Exception {
		Date date1 = new Date(1, 3, 2020);
		Date date2 = new Date(1, 1, 1545);
		Date date3 = new Date(1, 4, 568);
		Date date4 = new Date(17, 5, 132);
		Date date5 = new Date(1, 12, 1025);
		
		date1 = date1.previousDate();
		date2 = date2.previousDate();
		date3 = date3.previousDate();
		date4 = date4.previousDate();
		date5 = date5.previousDate();
		
		assertTrue(date1.day == 29 && date1.month == 2 && date1.year == 2020);
		assertTrue(date2.day == 31 && date2.month == 12 && date2.year == 1544);
		assertTrue(date3.day == 31 && date3.month == 3 && date3.year == 568);
		assertTrue(date4.day == 16 && date4.month == 5 && date4.year == 132);
		assertTrue(date5.day == 30 && date5.month == 11 && date5.year == 1025);
	}
	
// Test compareTo
	
	@Test
	void testCompareTo() throws Exception {
		Date date1 = new Date(1, 3, 2020);
		Date date2 = new Date(1, 3, 2020);
		Date date3 = new Date(5, 4, 785);
		Date date4 = new Date(4, 4, 785);
		Date date5 = new Date(23, 8, 4581);
		Date date6 = new Date(10, 1, 7852);
		Date date7 = new Date(18, 12, 1666);
		Date date8 = new Date(18, 9, 1666);
		
		assertTrue(date1.compareTo(date2) == 0);
		assertTrue(date3.compareTo(date4) > 0);
		assertTrue(date5.compareTo(date6) < 0);
		assertTrue(date7.compareTo(date8) > 0);
	}
}
