package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

	@Test
	public void invalidPostitiveDay() {
		assertFalse(Date.isValidDate(1000, 1, 1));
	}
	
	@Test
	public void invalidNegativeDay() {
		assertFalse(Date.isValidDate(-1000, 1, 1));
	}
	
	@Test
	public void invalidPostitiveMonth() {
		assertFalse(Date.isValidDate(1, 1000, 1));
	}
	
	@Test
	public void invalidNegativeMonth() {
		assertFalse(Date.isValidDate(1000, -1000, 1));
	}
	
	@Test
	public void yearZero() {
		assertFalse(Date.isValidDate(1, 1, 0));
	}
	
	@Test
	public void twentyNinthOfFebOnLeapYear() {
		assertTrue(Date.isValidDate(29, 2, 2024));
	}
	
	@Test
	public void twentyNinthOfFebNotOnLeapYear() {
		assertFalse(Date.isValidDate(29, 2, 2023));
	}
	
	@Test
	public void thirtyFirstOnShortMonth() {
		assertFalse(Date.isValidDate(31, 4, 1));
	}
	
	/// Compare To
	@Test
	public void equalDates() {
		var d = new Date(1, 1, 1);
		var o = new Date(1, 1, 1);
		assertEquals(d.compareTo(o), 0);
	}
	
	@Test
	public void equalDayMonthButDiffYear() {
		var d = new Date(1, 1, 100);
		var o = new Date(1, 1, 1);
		assertTrue(d.compareTo(o) > 0);
	}
	
	@Test
	public void equalDayYearButDiffMonth() {
		var d = new Date(1, 4, 1);
		var o = new Date(1, 1, 1);
		assertTrue(d.compareTo(o) > 0);
	}
	
	@Test
	public void equalMonthYearButDiffDay() {
		var d = new Date(2, 1, 1);
		var o = new Date(1, 1, 1);
		assertTrue(d.compareTo(o) > 0);
	}
	
	/// Next Date
	@Test
	public void prevDayOf1_1_1AD() {
		var d = new Date(1, 1, 1);
		var nextDate = d.nextDate();
		assertEquals(31, nextDate.getDay());
		assertEquals(12, nextDate.getMonth());
		assertEquals(-1, nextDate.getYear());
	}
	
	@Test
	public void fromMarchOnNonLeapYear() {
		var d = new Date(1, 3, 1);
		var nextDate = d.nextDate();
		assertEquals(28, nextDate.getDay());
		assertEquals(2, nextDate.getMonth());
		assertEquals(1, nextDate.getYear());
	}
	
	@Test
	public void fromMarchOnLeapYear() {
		var d = new Date(1, 3, 2024);
		var nextDate = d.nextDate();
		assertEquals(29, nextDate.getDay());
		assertEquals(2, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
	
	@Test
	public void toLongMonth() {
		var d = new Date(1, 4, 2024);
		var nextDate = d.nextDate();
		assertEquals(31, nextDate.getDay());
		assertEquals(3, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
	
	@Test
	public void toShortMonth() {
		var d = new Date(1, 5, 2024);
		var nextDate = d.nextDate();
		assertEquals(31, nextDate.getDay());
		assertEquals(4, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
	
	/// Previous Date
	@Test
	public void nextDayOf31_12_1BC() {
		var d = new Date(31, 12, -1);
		var nextDate = d.nextDate();
		assertEquals(1, nextDate.getDay());
		assertEquals(1, nextDate.getMonth());
		assertEquals(1, nextDate.getYear());
	}
	
	@Test
	public void toMarchOnNonLeapYear() {
		var d = new Date(28, 2, 1);
		var nextDate = d.nextDate();
		assertEquals(1, nextDate.getDay());
		assertEquals(3, nextDate.getMonth());
		assertEquals(1, nextDate.getYear());
	}
	
	@Test
	public void toMarchOnLeapYear() {
		var d = new Date(29, 2, 2024);
		var nextDate = d.nextDate();
		assertEquals(1, nextDate.getDay());
		assertEquals(3, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
	
	@Test
	public void twentyEighthOnLeapYear() {
		var d = new Date(28, 2, 2024);
		var nextDate = d.nextDate();
		assertEquals(29, nextDate.getDay());
		assertEquals(2, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
	
	@Test
	public void thirtyFirstOfLongMonth() {
		var d = new Date(31, 3, 2024);
		var nextDate = d.nextDate();
		assertEquals(1, nextDate.getDay());
		assertEquals(4, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
	
	@Test
	public void thirtiethOfLongMonth() {
		var d = new Date(30, 3, 2024);
		var nextDate = d.nextDate();
		assertEquals(31, nextDate.getDay());
		assertEquals(3, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
	
	@Test
	public void thirtiethOfShortMonth() {
		var d = new Date(30, 4, 2024);
		var nextDate = d.nextDate();
		assertEquals(1, nextDate.getDay());
		assertEquals(5, nextDate.getMonth());
		assertEquals(2024, nextDate.getYear());
	}
}