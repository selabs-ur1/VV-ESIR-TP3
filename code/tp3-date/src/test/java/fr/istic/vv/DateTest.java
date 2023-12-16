package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void testConstructorWithInvalidDate() {
        try {
            Date invalidDate = new Date(32, 13, 2022);
            fail("Une exception aurait dû être lancée pour une date invalide.");
        } catch (Exception e) {
            // assertTrue(true);
        }
    }

    // Tests validYear
    @Test
    void testValidYear() {
        assertTrue(Date.isValidDate(1, 1, -1));
    }

    @Test
    void testInvalidDayMonthYear() {
        assertFalse(Date.isValidDate(-1, -1, 0));
    }

    @Test
    void testInvalidDayNull() {
        assertFalse(Date.isValidDate(0, 4, 2020));
    }

    @Test
    void testInvalidDayNegativeMonthNull() {
        assertFalse(Date.isValidDate(-2, 0, 2019));
    }

    @Test
    void testInvalidNotLeapYear() {
        assertFalse(Date.isValidDate(29, 2, 2019));
    }

    @Test
    void testInvalidDayNullMonth13() {
        assertFalse(Date.isValidDate(0, 4, 2020));
    }

    @Test
    void testValidDate() {
        assertTrue(Date.isValidDate(5, 10, 2020));
    }

    @Test
    void testValidDate11() {
        assertTrue(Date.isValidDate(5, 11, 2020));
    }

    @Test
    void testValidDate9() {
        assertTrue(Date.isValidDate(5, 9, 2020));
    }

    // Tests isLeapYear
    @Test
    void testIsLeapYear4() {
        assertTrue(Date.isLeapYear(8));
    }

    @Test
    void testIsNotLeapYear() {
        assertFalse(Date.isLeapYear(200));
    }

    @Test
    void testIsLeapYear400() {
        assertTrue(Date.isLeapYear(800));
    }

    @Test
    void testIsNotLeapYear4() {
        assertFalse(Date.isLeapYear(10));
    }

    @Test
    void testIsNotLeapYear100() {
        assertFalse(Date.isLeapYear(150));
    }

    // Tests compareTo
    @Test
    void testIsBefore() throws Exception {
        Date date = new Date(12, 6, 120);
        Date otherdate = new Date(27, 8, 2018);
        assertEquals(1, date.compareTo(otherdate));
    }

    @Test
    void testIsEquals() throws Exception {
        Date date = new Date(5, 3, 2024);
        Date otherdate = new Date(5, 3, 2024);
        assertEquals(0, date.compareTo(otherdate));
    }

    @Test
    void testIsAfter() throws Exception {
        Date date = new Date(5, 3, 3007);
        Date otherdate = new Date(2, 7, 1932);
        assertEquals(-1, date.compareTo(otherdate));
    }

    @Test
    public void testCompareToYearIsEqualButMonthIsDifferent() throws Exception {
        Date date1 = new Date(1, 2, 2022);
        Date date2 = new Date(1, 1, 2022);
        assertEquals(-1, date1.compareTo(date2));
    }

    @Test
    public void testCompareToIsEqualButYearIsDifferent() throws Exception {
        Date date1 = new Date(1, 1, 2023);
        Date date2 = new Date(1, 1, 2022);
        assertEquals(-1, date1.compareTo(date2));
    }

    // Test nextDate
    @Test
    void testNextDate() throws Exception {
        Date date = new Date(5, 3, 2024);
        Date otherdate = new Date(6, 3, 2024);
        assertEquals(0, date.nextDate().compareTo(otherdate));
    }

    @Test
    void testNextDate0() throws Exception {
        Date date = new Date(31, 12, -1);
        Date otherdate = new Date(1, 1, 1);
        assertEquals(0, date.nextDate().compareTo(otherdate));
    }

    @Test
    void testNextDateEndOfMonth() throws Exception {
        Date date = new Date(31, 1, 2018);
        Date otherdate = new Date(1, 2, 2018);
        assertEquals(0, date.nextDate().compareTo(otherdate));
    }

    @Test
    void testNextDateEndOfYear() throws Exception {
        Date date = new Date(31, 12, 1872);
        Date otherdate = new Date(1, 1, 1873);
        assertEquals(0, date.nextDate().compareTo(otherdate));
    }

    // Tests previousDate
    @Test
    void testPreviousDateBeginningOfMonth() throws Exception {
        Date date = new Date(1, 6, 2018);
        Date otherdate = new Date(31, 5, 2018);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDateBeginningOfYear() throws Exception {
        Date date = new Date(1, 1, -100);
        Date otherdate = new Date(31, 12, -101);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate() throws Exception {
        Date date = new Date(5, 3, 2024);
        Date otherdate = new Date(4, 3, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDateNull() throws Exception {
        Date date = new Date(1, 1, 1);
        Date otherdate = new Date(31, 12, -1);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDateLeapYear() throws Exception {
        Date date = new Date(1, 3, 2024);
        Date otherdate = new Date(29, 2, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDateNotLeapYear() throws Exception {
        Date date = new Date(1, 3, 2023);
        Date otherdate = new Date(28, 2, 2023);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate31() throws Exception {
        Date date = new Date(1, 5, 2024);
        Date otherdate = new Date(30, 4, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate6() throws Exception {
        Date date = new Date(1, 7, 2024);
        Date otherdate = new Date(30, 6, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate9() throws Exception {
        Date date = new Date(1, 10, 2024);
        Date otherdate = new Date(30, 9, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate11() throws Exception {
        Date date = new Date(1, 12, 2024);
        Date otherdate = new Date(30, 11, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate1() throws Exception {
        Date date = new Date(1, 2, 2024);
        Date otherdate = new Date(31, 1, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate3() throws Exception {
        Date date = new Date(1, 4, 2024);
        Date otherdate = new Date(31, 3, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate7() throws Exception {
        Date date = new Date(1, 8, 2024);
        Date otherdate = new Date(31, 7, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate8() throws Exception {
        Date date = new Date(1, 9, 2024);
        Date otherdate = new Date(31, 8, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

    @Test
    void testPreviousDate10() throws Exception {
        Date date = new Date(1, 11, 2024);
        Date otherdate = new Date(31, 10, 2024);
        assertEquals(0, date.previousDate().compareTo(otherdate));
    }

}