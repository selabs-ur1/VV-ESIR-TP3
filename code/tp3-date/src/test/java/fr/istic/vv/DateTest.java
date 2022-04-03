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
}
	
