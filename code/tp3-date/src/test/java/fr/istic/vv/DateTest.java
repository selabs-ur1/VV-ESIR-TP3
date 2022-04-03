package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

class DateTest {
	@Test
	public void testNotValidDateException() {
		NotValidDateException thrown = new NotValidDateException(1, 1, 1);
		Assertions.assertEquals("the date: 1/1/1 is not valid", thrown.getMessage());
	}
	
	@Test
	public void testDate0() {
		NotValidDateException thrown = Assertions.assertThrows(NotValidDateException.class, () -> {
			Date d = new Date(0,1,1);
	  });
		
		Assertions.assertEquals("the date: 0/1/1 is not valid", thrown.getMessage());
	}
	
	@Test
	public void testInvalidNegYear(){
		assertFalse(Date.isValidDate(1, 1, -1));
	}
	
	@Test
	public void testInvalidNegDateNegMonth(){
		assertFalse(Date.isValidDate(-1, -1, 1));
	}
	
	@Test
	public void testInvalidZeroDay(){
		assertFalse(Date.isValidDate(0, 4, 2020));
	}
	
	@Test void testInvalidNegMonth() {
		assertFalse(Date.isValidDate(1, -1, 1));
	}
	@Test
	public void testInvalidNegDayZeroMonth(){
		assertFalse(Date.isValidDate(-2, 0, 2019));
	}
	@Test
	public void testInvalid29FebNonLeapYear(){
		assertFalse(Date.isValidDate(29, 2, 2019));
	}
	
	@Test
	public void testInvalid0Day13Month(){
		assertFalse(Date.isValidDate(0, 13, 2019));
	}
	
	@Test 
	public void testInvalid31dayInA30DayMonth() {
		assertFalse(Date.isValidDate(31, 11, 20));
	}
	
	@Test
	public void testInvalid30dayInLapYearFebruar() {
		assertFalse(Date.isValidDate(30, 2, 2024));
	}
	
	
	@Test
	public void nextDay31Janvier() throws Exception {
		assertTrue(new Date(1,2,1).compareTo(new Date(31,1,1).nextDate()) == 0);
	}
	
	@Test
	public void nextDay31Decembre() throws Exception {
		assertTrue(new Date(1,1,2).compareTo(new Date(31,12,1).nextDate()) == 0);
	}
	
	@Test
	public void nextDay30thDayOf30DayMonth() throws Exception {
		Date lastNovember = new Date(30,11,1);
		Date firstDecember = new Date(1,12,1);
		assertTrue(lastNovember.nextDate().compareTo(firstDecember) == 0);
	}
	
	@Test
	public void nextDay28thDayOf28DayMonth() throws Exception {
		Date lastFebruar = new Date(28,2,1);
		Date firstMarch = new Date(1,3,1);
		assertTrue(lastFebruar.nextDate().compareTo(firstMarch) == 0);
	}
	
	@Test
	public void nextDay28thDayOf28DayMonthLeapYear() throws Exception {
		Date lastFebruar = new Date(29,2,2024);
		Date firstMarch = new Date(1,3,2024);
		assertTrue(lastFebruar.nextDate().compareTo(firstMarch) == 0);
	}
	
	@Test
	public void testCasualNextDay() throws Exception {
		Date casualDay = new Date(5,2,2024);
		Date nextDay = new Date(6,2,2024);
		assertTrue(casualDay.nextDate().compareTo(nextDay) == 0);
	}
	
	@Test
	public void test400isLeapYear() {
		assertTrue(Date.isLeapYear(400));
	}
	
	@Test
	public void test500isNotLeapYear() {
		assertFalse(Date.isLeapYear(500));
	}
	
	
	@Test
	public void testPreviousOf1rstJanuary() throws Exception {
		Date firstJanuary = new Date(1,1,2);
		Date lastDecember = new Date(31,12,1);
		assertTrue(lastDecember.compareTo(firstJanuary.previousDate()) == 0);
	}
	
	@Test
	public void testPreviousMonth() throws Exception {
		Date firstDayOfMonth = new Date(1,2,2);
		Date lastDayOfPreviousMonth = new Date(31,1,2);
		assertTrue(lastDayOfPreviousMonth.compareTo(firstDayOfMonth.previousDate()) == 0);
	}
	
	@Test
	public void testPreviousDay() throws Exception {
		Date day = new Date(14,2,2);
		Date previousDay = new Date(13,2,2);
		assertTrue(previousDay.compareTo(day.previousDate()) == 0);
	}
	
	@Test
	public void testCompareToYearAfter() throws Exception {
		Date dayOne = new Date(1,1,1);
		Date dayTwo = new Date(1,1,2);
		
		assertTrue(dayOne.compareTo(dayTwo) < 0);
	}
	
	@Test
	public void testCompareToYearBefore() throws Exception {
		Date dayOne = new Date(1,1,1);
		Date dayTwo = new Date(1,1,2);
		
		assertTrue(dayTwo.compareTo(dayOne) > 0);
	}
	
	@Test
	public void testCompareToMonthAfter() throws Exception {
		Date dayOne = new Date(1,1,1);
		Date dayTwo = new Date(1,2,1);
		
		assertTrue(dayOne.compareTo(dayTwo) < 0);
	}
	
	@Test
	public void testCompareToMonthBefore() throws Exception {
		Date dayOne = new Date(1,1,1);
		Date dayTwo = new Date(1,2,1);
		
		assertTrue(dayTwo.compareTo(dayOne) > 0);
	}
	
	@Test
	public void testCompareToDayAfter() throws Exception {
		Date dayOne = new Date(2,1,2);
		Date dayTwo = new Date(3,1,2);
		
		assertTrue(dayOne.compareTo(dayTwo) < 0);
	}
	
	@Test
	public void testCompareToDayBefore() throws Exception {
		Date dayOne = new Date(2,1,2);
		Date dayTwo = new Date(3,1,2);
		
		assertTrue(dayTwo.compareTo(dayOne) > 0);
	}
	
	@Test
	public void testCompareToDayBeforeMonth30Day() throws Exception {
		Date start = new Date(1,12,2);
		Date beforeStart = new Date(30,11,2);
		
		assertTrue(start.previousDate().compareTo(beforeStart) == 0);
	}
	
	@Test
	public void testCompareToDayBeforeMonth31Day() throws Exception {
		Date start = new Date(1,1,2);
		Date beforeStart = new Date(31,12,1);
		
		assertTrue(start.previousDate().compareTo(beforeStart) == 0);
	}
	
	@Test
	public void testCompareToDayBeforeMonth29Day() throws Exception {
		Date start = new Date(1,3,2024);
		Date beforeStart = new Date(29,2,2024);
		
		assertTrue(start.previousDate().compareTo(beforeStart) == 0);
	}
	
	@Test
	public void testCompareToDayBeforeMonth28Day() throws Exception {
		Date start = new Date(1,3,2022);
		Date beforeStart = new Date(28,2,2022);
		
		assertTrue(start.previousDate().compareTo(beforeStart) == 0);
	}
	
}
	
