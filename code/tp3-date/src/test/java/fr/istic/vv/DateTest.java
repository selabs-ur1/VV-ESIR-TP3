package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import static fr.istic.vv.Date.*;

public class DateTest {
    
	// ECC : Each Choice Coverage

	@Test
	public void test1ValidDate() {
		assertFalse(isValidDate(1,1,-1));
	}
	
	@Test
	public void test2ValidDate() {
		assertFalse(isValidDate(-1,-1,0));
	}
	
	
	@Test
	public void test3ValidDate() {
		assertFalse(isValidDate(0,4,2020));
	}

	@Test
	public void test4ValidDate() {
		assertFalse(isValidDate(-2,0,2019));
	}

	@Test
	public void test5ValidDate() {
		assertFalse(isValidDate(29,2,2019));
	}

	@Test
	public void test6ValidDate() {
		assertFalse(isValidDate(0,13,2018));
	}

	@Test
	public void test7ValidDate() {
		assertFalse(isValidDate(30,2,2020));
	}

	@Test
	public void test8ValidDate() {
		assertFalse(isValidDate(29,2,2019));
	}

	@Test
	public void test9ValidDate() {
		assertFalse(isValidDate(32,7,2019));
	}

	///////////////////////////////////////////////////

	@Test
	public void test1LeapYear() {
		assertFalse(isLeapYear(-1));
	}

	@Test
	public void test2LeapYear() {
		assertTrue(isLeapYear(0));
	}

	@Test
	public void test3LeapYear() {
		assertTrue(isLeapYear(2020));
	}

	@Test
	public void test4LeapYear() {
		assertFalse(isLeapYear(2019));
	}

	///////////////////////////////////////////////////

	@Test
	public void test1NextDate() throws Exception {
		Date d1 = new Date(1,12,2000);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(2,12,2000);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test2NextDate() throws Exception {
		Date d1 = new Date(31,12,2000);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(1,1,2001);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test3NextDate() throws Exception {
		Date d1 = new Date(28,2,2016);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(29,2,2016);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test4NextDate() throws Exception {
		Date d1 = new Date(28,2,2017);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(1,3,2017);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test5NextDate() throws Exception {
		Date d1 = new Date(30,4,2016);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(1,5,2016);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test6NextDate() throws Exception {
		Date d1 = new Date(31,7,2016);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(1,8,2016);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test7NextDate() throws Exception {
		Date d1 = new Date(15,6,2016);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(16,6,2016);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test8NextDate() throws Exception {
		Date d1 = new Date(29,2,2016);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(1,3,2016);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	public void test9NextDate() throws Exception {
		Date d1 = new Date(13,2,2015);
		Date d1_bis = d1.nextDate();
		Date d2 = new Date(14,2,2015);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	///////////////////////////////////////////////////


	@Test
	public void test1PreviousDate() throws Exception {
		Date d1 = new Date(1,12,2000);
		Date d1_bis = d1.previousDate();
		Date d2 = new Date(30,11,2000);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test2PreviousDate() throws Exception {
		Date d1 = new Date(1,1,2000);
		Date d1_bis = d1.previousDate();
		Date d2 = new Date(31,12,1999);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test3PreviousDate() throws Exception {
		Date d1 = new Date(1,3,2000);
		Date d1_bis = d1.previousDate();
		Date d2 = new Date(29,2,2000);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test4PreviousDate() throws Exception {
		Date d1 = new Date(1,3,2001);
		Date d1_bis = d1.previousDate();
		Date d2 = new Date(28,2,2001);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test5PreviousDate() throws Exception {
		Date d1 = new Date(5,3,2001);
		Date d1_bis = d1.previousDate();
		Date d2 = new Date(4,3,2001);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}

	@Test
	public void test6PreviousDate() throws Exception {
		Date d1 = new Date(1,4,2001);
		Date d1_bis = d1.previousDate();
		Date d2 = new Date(31,3,2001);
		assertTrue(d1_bis.compareTo(d2) == 0);
	}
		
	@Test
	public void test7PreviousDate() throws Exception {
		Date d1 = new Date(1,1,1);

		Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			d1.previousDate();
   		});
 
   		Assertions.assertEquals("Error : a year can't be negative", thrown.getMessage());
	}

	///////////////////////////////////////////////////

	@Test
	public void test1CompareTo() throws Exception {
		Date d1 = new Date(1,12,2000);
		Date d2 = new Date(5,1,2040);
		assertTrue(d1.compareTo(d2) < 0);
	}

	@Test
	public void test2CompareTo() throws Exception {
		Date d1 = new Date(1,12,2000);
		Date d2 = new Date(1,12,2000);
		assertTrue(d1.compareTo(d2) == 0);
	}

	@Test
	public void test3CompareTo() throws Exception {
		Date d1 = new Date(1,12,2000);
		Date d2 = new Date(31,1,1900);
		assertTrue(d1.compareTo(d2) > 0);
	}

	@Test
	public void test4CompareTo() throws Exception {
		Date d1 = new Date(1,12,2000);
		Date d2 = new Date(1,11,2000);
		assertTrue(d1.compareTo(d2) > 0);
	}

	@Test
	public void test5CompareTo() throws Exception {
		Date d1 = new Date(2,12,2000);
		Date d2 = new Date(1,12,2000);
		assertTrue(d1.compareTo(d2) > 0);
	}
	
	@Test
	public void test6CompareTo() throws Exception {
		Date d1 = new Date(2,12,2000);
		Date d2 = null;

		NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
			d1.compareTo(d2);
   		});
 
   		Assertions.assertEquals("The other date is null", thrown.getMessage());
	}
}
