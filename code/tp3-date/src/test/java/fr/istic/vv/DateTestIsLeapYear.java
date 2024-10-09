package fr.istic.vv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTestIsLeapYear {
    /*      Leap year test suite        */

    @DisplayName("Block 1 : Year // 400")
    @Test
    void isLeapYearBlock1() {
        assertTrue(Date.isLeapYear(400));
        assertTrue(Date.isLeapYear(800));
        assertTrue(Date.isLeapYear(-3600));
        assertTrue(Date.isLeapYear(-800));
    }

    @DisplayName("Block 2 : Year // 100")
    @Test
    void isLeapYearBlock2() {
        assertFalse(Date.isLeapYear(100));
        assertFalse(Date.isLeapYear(700));
        assertFalse(Date.isLeapYear(-300));
        assertFalse(Date.isLeapYear(-3500));
    }

    @DisplayName("Block 3 : Year // 4")
    @Test
    void isLeapYearBlock3() {
        assertTrue(Date.isLeapYear(2024));
        assertTrue(Date.isLeapYear(-2012));
        assertTrue(Date.isLeapYear(-4));
        assertTrue(Date.isLeapYear(8));
    }

    @DisplayName("Block 4 : Common Year")
    @Test
    void isLeapYearBlock4() {
        assertFalse(Date.isLeapYear(213));
        assertFalse(Date.isLeapYear(2013));
        assertFalse(Date.isLeapYear(-5));
        assertFalse(Date.isLeapYear(-1023));
    }

}