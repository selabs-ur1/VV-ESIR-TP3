package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class DateTest {
		
		private Date date;
		
		@BeforeEach	
		void setUp() throws Exception {
			this.date = new Date(7,8,2000);
		}

		@Test
		void allZerotIsValidDate() {
			assertFalse(Date.isValidDate(0, 0, 0));
		}

		@Test
		void dayZeroIsValidDate() {
			assertFalse(Date.isValidDate(0, 5, 2021));
		}

		@Test
		void monthZeroIsValidDate() {
			assertFalse(Date.isValidDate(12, 0, 2014));
		}

		@Test
		void yearZeroIsValidDate() {
			assertTrue(Date.isValidDate(9, 6, 0));
		}
		
		@Test
		void negativeYearIsValidDate() {
			assertFalse(Date.isValidDate(9, 6, -234));
		}

		@Test
		void simpleWrongDateConstructor() throws Exception {
			Assertions.assertThrows(Exception.class, 
					() -> {new Date(0,2,469);
					}
					);
		}
		
		@Test
		void isValidDate30Month() throws Exception{
			assertTrue(Date.isValidDate(30,4,2002));
		}		
		
		@Test
		void isValid31Month() throws Exception{
			assertTrue(Date.isValidDate(31,5,208));
		}
		
		@Test
		void isValidDate28thFebNormalYear() throws Exception{
			assertTrue(Date.isValidDate(28,2,2007));
		}
		
		@Test
		void isValidDate28thFebLeapYear() throws Exception{
			assertTrue(Date.isValidDate(28,2,2008));
		}
		
		@Test
		void isValidDate29thFebLeapYear() throws Exception{
			assertTrue(Date.isValidDate(29,2,2008));
		}
		
		@Test
		void isValidDate30FebLeapYear() throws Exception{
			assertFalse(Date.isValidDate(30,2,2024));
		}
		
		@Test
		void isLeapYear2024() {
			assertTrue(Date.isLeapYear(2024));
		}

		@Test
		void isntLeapYear2007() {
			assertFalse(Date.isLeapYear(2007));
		}

		@Test
		void compareToSameDate() throws Exception {
			assertTrue(date.compareTo(date)==0);
		}

		//@Test
		void compareToEqualDate() throws Exception {
			Date date2 = new Date(7,8,2000);
			assertTrue(date.compareTo(date2) == 0);
		}

		@Test
		void compareToAnteriorYearDate() throws Exception{
			Date date2 = new Date(7,8,2001);
			assertTrue(date.compareTo(date2)<0);
		}
		
		@Test
		void compareToPosteriorYearDate() throws Exception{
			Date date2 = new Date(7,8,1999);
			assertTrue(date.compareTo(date2)>0);
		}
		
		@Test
		void compareToAnteriorMonthDate() throws Exception{
			Date date2 = new Date(7,9,2000);
			assertTrue(date.compareTo(date2)<0);
		}
		
		@Test
		void compareToPosteriorMonthDate() throws Exception{
			Date date2 = new Date(7,7,2000);
			assertTrue(date.compareTo(date2)>0);
		}
		
		@Test
		void compareToPosteriorDayDate() throws Exception{
			Date date2 = new Date(8,8,2000);
			assertTrue(date.compareTo(date2)<0);
		}
		
		@Test
		void compareToAnteriorDayDate() throws Exception{
			Date date2 = new Date(6,8,2000);
			assertTrue(date.compareTo(date2)>0);
		}
		
		@Test
		void nextDateNormalDay() throws Exception {
			assertTrue(date.nextDate().compareTo(new Date(8,8,2000))==0);
		}
		
		@Test 
		void nextDateLastDayMonth() throws Exception{
			Date complexDate = new Date(29,2,2008);
			assertTrue(complexDate.nextDate().compareTo(new Date(1,3,2008))==0);
		}
		
		@Test
		void nextDateLastDayYear() throws Exception{
			Date lastDay = new Date(31,12,2018);
			assertTrue(lastDay.nextDate().compareTo(new Date(1,1,2019))==0);
		}
		
		@Test
		void previousDateNormalDay() throws Exception {
			assertTrue(date.previousDate().compareTo(new Date(6,8,2000))==0);
		}
		
		@Test 
		void previousDate1stMarchLeapYear() throws Exception{
			Date complexDate = new Date(1,3,2024);
			assertTrue(complexDate.previousDate().compareTo(new Date(29,2,2024))==0);
		}
		
		@Test 
		void previousDate1stMarchNormalYear() throws Exception{
			Date complexDate = new Date(1,3,2022);
			assertTrue(complexDate.previousDate().compareTo(new Date(28,2,2022))==0);
		}
		
		@Test 
		void previousDateFirstDay30thMonth() throws Exception{
			Date complexDate = new Date(1,7,2000);
			assertTrue(complexDate.previousDate().compareTo(new Date(30,6,2000))==0);
		}
		
		@Test 
		void previousDateFirstDay31thMonth() throws Exception{
			Date complexDate = new Date(1,9,2019);
			assertTrue(complexDate.previousDate().compareTo(new Date(31,8,2019))==0);
		}
		
		
		@Test
		void previousDateFirstDayYear() throws Exception{
			Date lastDay = new Date(1,1,2004);
			assertTrue(lastDay.previousDate().compareTo(new Date(31,12,2003))==0);
		}

}