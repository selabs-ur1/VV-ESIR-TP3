package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

class DateTest {

    @Test
    public void testIsValidDate() {
        assertTrue(Date.isValidDate(1, 1, -1));
        assertFalse(Date.isValidDate(-1, -1, 0));
        assertFalse(Date.isValidDate(0, 4, 2020));
        assertFalse(Date.isValidDate(-2, 0, 2019));
        assertFalse(Date.isValidDate(29,2,2019));
        assertFalse(Date.isValidDate(0,13,2018));

    }

    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Date(1, 1, 1));

        assertThrows(IllegalArgumentException.class, () -> {
            new Date(-1, 0, 0);
        });
    }

    @Test
    public void testLeapYear() {
        assertTrue(Date.isLeapYear(4));
        assertFalse(Date.isLeapYear(5));
        assertFalse(Date.isLeapYear(100));
        assertTrue(Date.isLeapYear(104));
        assertTrue(Date.isLeapYear(400));
    }

    @Test
    public void testCompareTo(){
        Date d1 = new Date(1,1,1);
        Date d2 = new Date(31,12,2020);
        Date d3 = new Date(12,5,2012);
        assertTrue(d1.compareTo(d2) < 0 );
        assertTrue(d2.compareTo(d1) > 0 );
        assertTrue(d3.compareTo(d3) == 0);
        assertThrows(NullPointerException.class, () -> {
            d3.compareTo(null);
        });
    }

    @Test
    public void testNextDate(){
        Date d1 = new Date(31,7,2002);
        Date d2 = new Date(25,4,1945);
        Date d3 = new Date(31,12,2012);

        Date d4 = new Date(31,12,-1);
        assertTrue(d1.nextDate().compareTo(new Date(1,8,2002)) == 0);
        assertTrue(d2.nextDate().compareTo(new Date(26,4,1945)) == 0);
        assertTrue(d3.nextDate().compareTo(new Date(1,1,2013)) == 0);

        assertTrue(d4.nextDate().compareTo(new Date(1,1,1)) == 0);
    }

    @Test
    public void testPreviousDate(){
        Date d1 = new Date(1,6,45);
        Date d2 = new Date(13,8,1225);
        Date d3 = new Date(1,1,3001);

        Date d4 = new Date(1,1,1);
        assertTrue(d1.previousDate().compareTo(new Date(31,5,45)) == 0);
        assertTrue(d2.previousDate().compareTo(new Date(12,8,1225)) == 0);
        assertTrue(d3.previousDate().compareTo(new Date(31,12,3000)) == 0);

        assertTrue(d4.previousDate().compareTo(new Date(31,12,-1)) == 0);
    }
}