package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testDate_1(){
        assertThrows(IllegalArgumentException.class ,() -> new Date(0, 0, 0));
    }

    @Test
    void testIsValidDate_1() {
        assertTrue(Date.isValidDate(1, 1, 2022));
    }
    @Test
    void testIsValidDate_2() {
        assertFalse(Date.isValidDate(0, 1, 2022));
    }
     @Test
    void testIsValidDate_3() {
        assertFalse(Date.isValidDate(1, 0, 2022));
    }
     @Test
    void testIsValidDate_4() {
        assertFalse(Date.isValidDate(32, 1, 2022));
    }
     @Test
    void testIsValidDate_5() {
        assertFalse(Date.isValidDate(1, 13, 2022));
    }
     @Test
    void testIsValidDate_6() {
        assertFalse(Date.isValidDate(29, 2, 2021));
    }
     @Test
    void testIsValidDate_7() {
        assertTrue(Date.isValidDate(29, 2, 2024));
    }

    @Test
    void testIsValidDate_8() {
        assertTrue(Date.isValidDate(1, 1, 1));
    }


    @Test
    void testIsLeapYear_1() {
        assertFalse(Date.isLeapYear(2021));
    }
    @Test
    void testIsLeapYear_2() {
        assertTrue(Date.isLeapYear(2024));
    }
    @Test
    void testIsLeapYear_3() {
        assertFalse(Date.isLeapYear(1900));
    }
    @Test
    void testIsLeapYear_4() {
        assertTrue(Date.isLeapYear(2000));
    }

    Date date_next = new Date(31, 12, 2021);

    Date date_leap_next= new Date(28, 2, 2020);
    Date date_leap_previous = new Date(1, 3, 2020);

    @Test
    void testNextDate_1() {
        assertEquals(0, date_next.nextDate().compareTo(new Date(1, 1, 2022)));
    }

    @Test
    void testNextDate_2() {
        assertEquals(0, date_leap_next.nextDate().compareTo(new Date(29, 2, 2020)));
    }

    @Test
    void testNextDate_3() {
        assertEquals(0, new Date(28, 12, 2020).nextDate().compareTo(new Date(29, 12, 2020)));
    }


    Date date_prev = new Date(1, 1, 2022);

    @Test
    void testPreviousDate_1() {
        assertEquals(0, date_prev.previousDate().compareTo(new Date(31, 12, 2021)));
    }

    @Test
    void testPreviousDate_2() {
        assertEquals(0, new Date(25, 12, 2021).previousDate().compareTo(new Date(24, 12, 2021)));
    }

    @Test
    void testPreviousDate_3() {
        assertEquals(0, date_leap_previous.previousDate().compareTo(new Date(29, 2, 2020)));
    }

    @Test
    void testPreviousDate_4() {
        assertEquals(0, new Date(2, 5, 2021).previousDate().compareTo(new Date(1, 5, 2021)));
    }

    @Test
    void testPreviousDate_5() {
        assertEquals(0, new Date(1, 2, 2021).previousDate().compareTo(new Date(31, 1, 2021)));
    }

    Date date1 = new Date(1, 1, 2022);
    Date date2 = new Date(1, 1, 2023);
    Date date3 = new Date(1, 2, 2022);
    Date date4 = new Date(10, 1, 2022);
    Date date5 = null;

    @Test
    void testCompareTo_1() {
        assertThrows(NullPointerException.class, () -> date1.compareTo(date5));
    }
    @Test
    void testCompareTo_2() {
        assertTrue(date1.compareTo(date2) < 0);
    }
    @Test
    void testCompareTo_3() {
        assertTrue(date1.compareTo(date3) < 0);
    }
    @Test
    void testCompareTo_4() {
        assertTrue(date1.compareTo(date4) < 0);
    }
    @Test
    void testCompareTo_5() {
        assertTrue(date2.compareTo(date1) > 0);
    }
    @Test
    void testCompareTo_6() {
        assertTrue(date3.compareTo(date1) > 0);
    }
    @Test
    void testCompareTo_7() {
        assertTrue(date4.compareTo(date1) > 0);
    }
    @Test
    void testCompareTo_8() {
        assertEquals(0, date1.compareTo(date1));
    }
}

    