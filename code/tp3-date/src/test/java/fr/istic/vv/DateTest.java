package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class DateTest {
	
	private Date tmp;
	
	@BeforeEach	
	void setUp() throws Exception {
		this.tmp = new Date(2,2,2000);
	}

	@Test
	void zeroInputIsValidDate() {
		assertFalse(Date.isValidDate(0, 0, 0));
	}

	@Test
	void dayZero() {
		assertFalse(Date.isValidDate(0, 11, 2021));
	}

	@Test
	void monthZero() {
		assertFalse(Date.isValidDate(1, 0, 2021));
	}

	@Test
	void yearZero() {
		assertTrue(Date.isValidDate(1, 1, 0));
	}

	@Test
	void createASimpleWrongDate() throws Exception {
		Assertions.assertThrows(Exception.class, 
				() -> {
					new Date(0,0,0);
				}
				);
	}
	
	
	
	@Test
	void isValid30th() throws Exception{
		assertTrue(Date.isValidDate(30,7,2025));
	}
	
	@Test
	void isValid30thEndYear() throws Exception{
		assertTrue(Date.isValidDate(30,9,2025));
	}
	
	@Test
	void isValid30thLeapYear() throws Exception{
		assertTrue(Date.isValidDate(30,4,2024));
	}
	
	@Test
	void isValid30thLeapYearEndYear() throws Exception{
		assertTrue(Date.isValidDate(30,9,2024));
	}
	
	
	@Test
	void isValid31th() throws Exception{
		assertTrue(Date.isValidDate(31,5,2025));
	}
	
	@Test
	void isValid31thEndNormalYear() throws Exception{
		assertTrue(Date.isValidDate(31,12,2025));
	}
	
	@Test
	void isValid31thLeapYear() throws Exception{
		assertTrue(Date.isValidDate(31,5,2024));
	}
	
	@Test
	void isValid31thLeapYearEndYear() throws Exception{
		assertTrue(Date.isValidDate(31,12,2024));
	}
	
	@Test 
	void isValidADate() throws Exception{
		assertTrue(Date.isValidDate(1,1,1));
	}
	
	@Test
	void isValid28thFebruaryNormalYear() throws Exception{
		assertTrue(Date.isValidDate(28,2,2025));
	}
	
	@Test
	void isValid28thFebruaryLeapYear() throws Exception{
		assertTrue(Date.isValidDate(28,2,2024));
	}
	
	@Test
	void isValid29thFebruaryOnALeapYear() throws Exception{
		assertTrue(Date.isValidDate(29,2,2024));
	}
	
	@Test
	void isValid32thFebruaryOnALeapYear() throws Exception{
		assertFalse(Date.isValidDate(32,2,2024));
	}
	
	@Test
	void aLeapYear() {
		assertTrue(Date.isLeapYear(2024));
	}

	@Test
	void notALeapYear() {
		assertFalse(Date.isLeapYear(2022));
	}

	@Test
	void compareSameDate() throws Exception {
		assertTrue(tmp.compareTo(tmp)==0);
	}

	@Test
	void compareEqualDate() throws Exception {
		Date tmp2 = new Date(2,2,2000);
		assertTrue(tmp.compareTo(tmp2) == 0);
	}

	@Test
	void compareAnteriorYearDate() throws Exception{
		Date tmp2 = new Date(2,2,2099);
		assertTrue(tmp.compareTo(tmp2)<0);
	}
	
	@Test
	void comparePosteriorYearDate() throws Exception{
		Date tmp2 = new Date(2,2,1099);
		assertTrue(tmp.compareTo(tmp2)>0);
	}
	
	@Test
	void compareAnteriorMonthDate() throws Exception{
		Date tmp2 = new Date(2,3,2000);
		assertTrue(tmp.compareTo(tmp2)<0);
	}
	
	@Test
	void comparePosteriorMonthDate() throws Exception{
		Date tmp2 = new Date(2,1,2000);
		assertTrue(tmp.compareTo(tmp2)>0);
	}
	
	@Test
	void comparePosteriorDayDate() throws Exception{
		Date tmp2 = new Date(4,2,2000);
		assertTrue(tmp.compareTo(tmp2)<0);
	}
	
	@Test
	void compareAnteriorDayDate() throws Exception{
		Date tmp2 = new Date(1,2,2000);
		assertTrue(tmp.compareTo(tmp2)>0);
	}
	
	@Test
	void nextDayDate() throws Exception {
		assertTrue(tmp.nextDate().compareTo(new Date(3,2,2000))==0);
	}
	
	@Test 
	void nextMonthDate() throws Exception{
		Date complexDate = new Date(29,2,2024);
		assertTrue(complexDate.nextDate().compareTo(new Date(1,3,2024))==0);
	}
	
	@Test
	void nextYearDate() throws Exception{
		Date lastDay = new Date(31,12,1999);
		assertTrue(lastDay.nextDate().compareTo(new Date(1,1,2000))==0);
	}
	
	@Test
	void previousDayDate() throws Exception {
		assertTrue(tmp.previousDate().compareTo(new Date(1,2,2000))==0);
	}
	
	@Test 
	void previous29DayMonthDate() throws Exception{
		Date complexDate = new Date(1,3,2024);
		assertTrue(complexDate.previousDate().compareTo(new Date(29,2,2024))==0);
	}
	
	@Test 
	void previous30DayMonthDate() throws Exception{
		Date complexDate = new Date(1,5,2024);
		assertTrue(complexDate.previousDate().compareTo(new Date(30,4,2024))==0);
	}
	
	@Test 
	void previous31DayMonthDate() throws Exception{
		Date complexDate = new Date(1,6,2024);
		assertTrue(complexDate.previousDate().compareTo(new Date(31,5,2024))==0);
	}
	
	@Test 
	void previous28DayMonthDate() throws Exception{
		Date complexDate = new Date(1,3,2025);
		assertTrue(complexDate.previousDate().compareTo(new Date(28,2,2025))==0);
	}
	
	@Test
	void previousYearDate() throws Exception{
		Date lastDay = new Date(1,1,2000);
		assertTrue(lastDay.previousDate().compareTo(new Date(31,12,1999))==0);
	}
	
}