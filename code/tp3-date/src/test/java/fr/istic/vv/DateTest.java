package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    /******************** Input Space Partitioning ********************/

    /****Tests Q1 ****/

    // B1 : value of year < 0 => valid date
    @Test
    void testNegativeYear() {
        assertTrue(Date.isValidDate(1, 1, -1));
    }

    @Test
    void testNegativeYearNextDate() {
        Date date = new Date(31, 12, -1);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.getDay());
        assertEquals(1, nextDate.getMonth());
        assertEquals(0, nextDate.getYear());
    }

    @Test
    void testNegativeYearPreviousDate() {
        Date date = new Date(1, 1, -1);
        Date previousDate = date.previousDate();
        assertEquals(31, previousDate.getDay());
        assertEquals(12, previousDate.getMonth());
        assertEquals(-2, previousDate.getYear());
    }

    @Test
    void testNegativeYearCompareTo() {
        Date date1 = new Date(1, 1, -1);
        Date date2 = new Date(1, 1, -2);
        Date date3 = new Date(1, 1, 1);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    @Test
    void testNegativeYearIsLeapYear() {
        assertTrue(Date.isLeapYear(-4));
        assertFalse(Date.isLeapYear(-3));
    }

    // B2 : value of year == 0 => valid date
    @Test
    void testZeroYear() {
        assertTrue(Date.isValidDate(1, 1, 0));
    }

    @Test
    void testZeroYearNextDate() {
        Date date = new Date(31, 12, 0);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.getDay());
        assertEquals(1, nextDate.getMonth());
        assertEquals(1, nextDate.getYear());
    }

    @Test
    void testZeroYearPreviousDate() {
        Date date = new Date(1, 1, 0);
        Date previousDate = date.previousDate();
        assertEquals(31, previousDate.getDay());
        assertEquals(12, previousDate.getMonth());
        assertEquals(-1, previousDate.getYear());
    }

    @Test
    void testZeroYearCompareTo() {
        Date date1 = new Date(1, 1, 0);
        Date date2 = new Date(1, 1, -1);
        Date date3 = new Date(1, 1, 1);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    @Test
    void testZeroYearIsLeapYear() {
        assertTrue(Date.isLeapYear(0));
    }

    //B3 : valid leap year => valid date
    @Test
    void testLeapYear() {
        assertTrue(Date.isValidDate(29, 2, 2020));
    }

    @Test
    void testLeapYearNextDate() {
        Date date = new Date(29, 2, 2020);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.getDay());
        assertEquals(3, nextDate.getMonth());
        assertEquals(2020, nextDate.getYear());
    }

    @Test 
    void testLeapYearPreviousDate() {
        Date date = new Date(29, 2, 2020);
        Date previousDate = date.previousDate();
        assertEquals(28, previousDate.getDay());
        assertEquals(2, previousDate.getMonth());
        assertEquals(2020, previousDate.getYear());
    }

    @Test 
    void testLeapYearCompareTo() {
        Date date1 = new Date(29, 2, 2020);
        Date date2 = new Date(28, 2, 2019);
        Date date3 = new Date(1, 3, 2020);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    //B4 : valid common year => valid date
    @Test
    void testCommonYear() {
        assertTrue(Date.isValidDate(28, 2, 2021));
    }

    @Test
    void testCommonYearNextDate() {
        Date date = new Date(28, 2, 2021);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.getDay());
        assertEquals(3, nextDate.getMonth());
        assertEquals(2021, nextDate.getYear());
    }

    @Test
    void testCommonYearPreviousDate() {
        Date date = new Date(28, 2, 2021);
        Date previousDate = date.previousDate();
        assertEquals(27, previousDate.getDay());
        assertEquals(2, previousDate.getMonth());
        assertEquals(2021, previousDate.getYear());
    }

    @Test
    void testCommonYearCompareTo() {
        Date date1 = new Date(1, 1, 2021);
        Date date2 = new Date(1, 1, 2020);
        Date date3 = new Date(1, 1, 2022);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    //B5 : NA

    //B6 : NA


    /****Tests Q2 ****/

    // B1 : value of month < 0 => invalid date
    @Test
    void testNegativeMonth() {
        assertFalse(Date.isValidDate(1, -1, 2021));
        assertThrows(IllegalArgumentException.class, () -> {
            Date date = new Date(1, -1, 2021);
        });
    }

    // B2 : value of month == 0 => invalid date
    @Test
    void testZeroMonth() {
        assertFalse(Date.isValidDate(1, 0, 2021));
        assertThrows(IllegalArgumentException.class, () -> {
            Date date = new Date(1, 0, 2021);
        });
    }

    // B3 : { 1, 3, 5, 7, 8, 10, 12} => valid date
    @Test
    void testValidMonth31Days() {
        assertTrue(Date.isValidDate(31, 1, 2021));
        assertTrue(Date.isValidDate(31, 3, 2021));
        assertTrue(Date.isValidDate(31, 5, 2021));
        assertTrue(Date.isValidDate(31, 7, 2021));
        assertTrue(Date.isValidDate(31, 8, 2021));
        assertTrue(Date.isValidDate(31, 10, 2021));
        assertTrue(Date.isValidDate(31, 12, 2021));
    }

    @Test 
    void testValidMonth31DaysNextDate() {
        Date date = new Date(31, 1, 2021);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.getDay());
        assertEquals(2, nextDate.getMonth());
        assertEquals(2021, nextDate.getYear());
    }

    @Test 
    void testValidMonth31DaysPreviousDate() {
        Date date = new Date(31, 1, 2021);
        Date previousDate = date.previousDate();
        assertEquals(30, previousDate.getDay());
        assertEquals(1, previousDate.getMonth());
        assertEquals(2021, previousDate.getYear());
    }

    @Test
    void testValidMonth31DaysCompareTo() {
        Date date1 = new Date(31, 1, 2021);
        Date date2 = new Date(30, 1, 2021);
        Date date3 = new Date(1, 2, 2021);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    // B4 : { 4, 6, 9, 11} => valid date
    @Test
    void testValidMonth30Days() {
        assertTrue(Date.isValidDate(30, 4, 2021));
        assertTrue(Date.isValidDate(30, 6, 2021));
        assertTrue(Date.isValidDate(30, 9, 2021));
        assertTrue(Date.isValidDate(30, 11, 2021));
    }

    @Test
    void testValidMonth30DaysNextDate() {
        Date date = new Date(30, 4, 2021);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.getDay());
        assertEquals(5, nextDate.getMonth());
        assertEquals(2021, nextDate.getYear());
    }

    @Test
    void testValidMonth30DaysPreviousDate() {
        Date date = new Date(30, 4, 2021);
        Date previousDate = date.previousDate();
        assertEquals(29, previousDate.getDay());
        assertEquals(4, previousDate.getMonth());
        assertEquals(2021, previousDate.getYear());
    }

    @Test
    void testValidMonth30DaysCompareTo() {
        Date date1 = new Date(30, 4, 2021);
        Date date2 = new Date(29, 4, 2021);
        Date date3 = new Date(1, 5, 2021);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    // B5 : value of month == 2 => valid date
    @Test
    void testValidMonth28Days() {
        assertTrue(Date.isValidDate(28, 2, 2021));
    }

    @Test
    void testValidMonth28DaysNextDate() {
        Date date = new Date(28, 2, 2021);
        Date nextDate = date.nextDate();
        assertEquals(1, nextDate.getDay());
        assertEquals(3, nextDate.getMonth());
        assertEquals(2021, nextDate.getYear());
    }

    @Test
    void testValidMonth28DaysPreviousDate() {
        Date date = new Date(28, 2, 2021);
        Date previousDate = date.previousDate();
        assertEquals(27, previousDate.getDay());
        assertEquals(2, previousDate.getMonth());
        assertEquals(2021, previousDate.getYear());
    }

    @Test
    void testValidMonth28DaysCompareTo() {
        Date date1 = new Date(28, 2, 2021);
        Date date2 = new Date(27, 2, 2021);
        Date date3 = new Date(1, 3, 2021);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    // B6 : value of month > 12 => invalid date
    @Test
    void testInvalidMonth() {
        assertFalse(Date.isValidDate(1, 13, 2021));
        assertThrows(IllegalArgumentException.class, () -> {
            Date date = new Date(1, 13, 2021);
        });
    }


    /****Tests Q3 ****/

    // B1 : value of day < 0 => invalid date
    @Test
    void testNegativeDay() {
        assertFalse(Date.isValidDate(-1, 1, 2021));
        assertThrows(IllegalArgumentException.class, () -> {
            Date date = new Date(-1, 1, 2021);
        });
    }



    // B3 : >= 1 and <= max(month, year) => valid date
    @Test
    void testValidDay() {
        assertTrue(Date.isValidDate(1, 1, 2021));
        assertTrue(Date.isValidDate(31, 1, 2021));
    }

    @Test
    void testValidDayNextDate() {
        Date date = new Date(1, 1, 2021);
        Date nextDate = date.nextDate();
        assertEquals(2, nextDate.getDay());
        assertEquals(1, nextDate.getMonth());
        assertEquals(2021, nextDate.getYear());
    }

    @Test
    void testValidDayPreviousDate() {
        Date date = new Date(1, 5, 2021);
        Date previousDate = date.previousDate();
        assertEquals(30, previousDate.getDay());
        assertEquals(4, previousDate.getMonth());
        assertEquals(2021, previousDate.getYear());
    }

    @Test
    void testValidDayCompareTo() {
        Date date1 = new Date(1, 1, 2021);
        Date date2 = new Date(31, 12, 2020);
        Date date3 = new Date(2, 1, 2021);
        assertTrue(date1.compareTo(date2) > 0);
        assertTrue(date1.compareTo(date3) < 0);
    }

    // B4 : > max(month, year) => invalid date
    @Test
    void testInvalidDay() {
        assertFalse(Date.isValidDate(32, 1, 2021));
        assertThrows(IllegalArgumentException.class, () -> {
            Date date = new Date(32, 1, 2021);
        });
    }

    //B5 : NA

    //B6 : NA


    
    /******************** Test coverage ********************/

    // Input Space Partitioningis sufficient to cover all the code

    /******************** Logic test ********************/

    @Test
    void testBranchCoverageLeapYear() {
        //not divisible by 4
        assertFalse(Date.isLeapYear(2021));
        //divisible by 4 and not by 100
        assertTrue(Date.isLeapYear(2020));
        //divisible by 4 and by 100 but not by 400
        assertFalse(Date.isLeapYear(1900));
        //divisible by 4 and by 100 and by 400
        assertTrue(Date.isLeapYear(2000));
    }

   

    /******************** Mutation score ********************/

    @Test
    void testNextDayBoundariesDay() {
        Date date2 = new Date(29, 11, 2021);
        Date nextDate2 = date2.nextDate();
        assertEquals(30, nextDate2.getDay());
        assertEquals(11, nextDate2.getMonth());
    }

    @Test
    void testNextDayBoundariesMonth() {
        Date date1 = new Date(30, 11, 2021);
        Date nextDate1 = date1.nextDate();
        assertEquals(1, nextDate1.getDay());
        assertEquals(12, nextDate1.getMonth());
        assertEquals(2021, nextDate1.getYear());
    }

    @Test
    void testPreviousDayBoundariesDay() {
        Date date2 = new Date(2, 12, 2021);
        Date previousDate2 = date2.previousDate();
        assertEquals(1, previousDate2.getDay());
        assertEquals(12, previousDate2.getMonth());
    }

    @Test
    void testPreviousDayBoundariesMonth() {
        Date date1 = new Date(1, 2, 2021);
        Date previousDate1 = date1.previousDate();
        assertEquals(31, previousDate1.getDay());
        assertEquals(1, previousDate1.getMonth());
        assertEquals(2021, previousDate1.getYear());
    }
}