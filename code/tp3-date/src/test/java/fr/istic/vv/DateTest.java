package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

	////Testing the constructor
	
	@Test
	public void testNegativeMonth() {
		assertThrows(Exception.class, () -> new Date(1,-1,1));
	}
	@Test
	public void testNegativeday() {
		assertThrows(Exception.class, () -> new Date(-1,1,1));
	}
	@Test
	public void test32DaysJanuaryCommonYear() {
		assertThrows(Exception.class, () -> new Date(32,1,2021));
	}
	@Test
	public void test31DaysAprilCommonYear() {
		assertThrows(Exception.class, () -> new Date(31,4,2021));
	}
	@Test
	public void testValidDays13MonthCommonYear() {
		assertThrows(Exception.class, () -> new Date(1,13,1));
	}
	@Test
	public void test29DaysFebruaryCommonYear() {
		assertThrows(Exception.class, () -> new Date(29,2,2021));
	}
	@Test
	public void test29DaysFebruaryLeapYear() {
		assertDoesNotThrow(() -> new Date(29,2,2000));
	}
	@Test
	public void testValidDaysJanuaryCommonYear() {
		assertDoesNotThrow(() -> new Date(20,1,2021));
	}
	@Test
	public void testValidDaysAprilCommonYear() {
		assertDoesNotThrow(() -> new Date(20,3,2021));
	}
	
	
	//Testing isValidDate
	@Test
	public void testValidDateNegativeMonth() {
		assertFalse(Date.isValidDate(1,-1,1));
	}
	@Test
	public void testValidDateNegativeday() {
		assertFalse(Date.isValidDate(-1,1,1));
	}
	@Test
	public void testValidDate32DaysJanuaryCommonYear() {
		assertFalse(Date.isValidDate(32,1,2021));
	}
	@Test
	public void testValidDate31DaysAprilCommonYear() {
		assertFalse(Date.isValidDate(31,4,2021));
	}
	@Test
	public void testValidDateValidDays13MonthCommonYear() {
		assertFalse(Date.isValidDate(1,13,1));
	}
	@Test
	public void testValidDate29DaysFebruaryCommonYear() {
		assertFalse(Date.isValidDate(29,2,2021));
	}
	@Test
	public void testValidDate29DaysFebruaryLeapYear() {
		assertTrue(Date.isValidDate(29,2,2000));
	}
	@Test
	public void testValidDateValidDaysJanuaryCommonYear() {
		assertTrue(Date.isValidDate(20,1,2021));
	}
	//test added after PIT
	@Test
	public void testValidDateValidDays0monthCommonYear() {
		assertFalse(Date.isValidDate(20,0,2021));
	}
	@Test
	public void testValidDate0DaysCommonMonthCommonYear() {
		assertFalse(Date.isValidDate(0,3,2021));
	}
	
	//Testing isLeapYear
	@Test
	public void testCommonYear() {
		assertFalse(Date.isLeapYear(2021));
	}
	@Test
	public void testDivisibleBy4NotBy100NotBy400() {
		assertTrue(Date.isLeapYear(4));
	}
	@Test
	public void testDivisibleBy4By100By400() {
		assertTrue(Date.isLeapYear(400));
	}
	@Test
	public void testDivisibleBy4By100NotBy400() {
		assertFalse(Date.isLeapYear(200));
	}
	@Test
	public void testDivisibleNotBy4By100NotBy400() {
		assertFalse(Date.isLeapYear(100));
	}
	
	//test compareTo
	@Test
	public void testComparePosterior() throws Exception {
		assertTrue(new Date(2,1,1).compareTo(new Date(1,1,1))>0);
	}
	@Test
	public void testCompareAnterior() throws Exception {
		assertTrue(new Date(1,1,1).compareTo(new Date(2,1,1))<0);
	}
	@Test
	public void testCompareEqual() throws Exception {
		assertTrue(new Date(1,1,1).compareTo(new Date(1,1,1))==0);
	}
	@Test
	public void testComparenull() throws Exception {
		assertThrows(NullPointerException.class, () -> new Date(1,1,1).compareTo(null));
	}
	
	
	//test nextDate
	@Test
	public void testNextCommonYearCommonMonthCommonDay() throws Exception {
		assertEquals(new Date(2,1,1).compareTo(new Date(1,1,1).nextDate()),0);
	}
	@Test
	public void testNextCommonYearCommonMonthLastDay() throws Exception {
		assertEquals(new Date(1,2,1).compareTo(new Date(31,1,1).nextDate()),0);
	}
	
	@Test
	public void testNextCommonYearLastMonthLastDay() throws Exception {
		assertEquals(new Date(1,1,2).compareTo(new Date(31,12,1).nextDate()),0);
	}
	@Test
	public void testNextCommonYearFebruaryLastDay() throws Exception {
		assertEquals(new Date(1,3,1).compareTo(new Date(28,2,1).nextDate()),0);
	}
	@Test
	public void testNextLeapYearFebruaryLastDay() throws Exception {
		assertEquals(new Date(29,2,400).compareTo(new Date(28,2,400).nextDate()),0);
	}


	
	//test previousDate
	@Test
	public void testPreviousCommonYearCommonMonthCommonDay() throws Exception {
		assertEquals(new Date(1,1,1).compareTo(new Date(2,1,1).previousDate()),0);
	}
	@Test
	public void testPreviousCommonYearCommonMonthFirstDay() throws Exception {
		assertEquals(new Date(31,1,1).compareTo(new Date(1,2,1).previousDate()),0);
	}
	@Test
	public void testPreviousCommonYearFirstMonthfirstDay() throws Exception {
		assertEquals(new Date(31,12,1).compareTo(new Date(1,1,2).previousDate()),0);
	}
	@Test
	public void testPreviousCommonYearFebruaryFirstDay() throws Exception {
		assertEquals(new Date(28,2,1).compareTo(new Date(1,3,1).previousDate()),0);
	}
	@Test
	public void testPreviousLeapYearFebruaryLastDay() throws Exception {
		assertEquals(new Date(28,2,400).compareTo(new Date(29,2,400).previousDate()),0);
	}
	
	
	
	

}