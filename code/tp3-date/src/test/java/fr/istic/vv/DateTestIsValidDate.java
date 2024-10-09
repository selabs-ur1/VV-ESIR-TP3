package fr.istic.vv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DateTestIsValidDate {

    /*      isValidDate test suite        */

    // Block 1

    @DisplayName("Year < 0")
    @Test
    void isValidDateBlock1Year() {
        assertTrue(Date.isValidDate(1,1,-150));
    }

    @DisplayName("Month < 0")
    @Test
    void isValidDateBlock1Month() {
        assertFalse(Date.isValidDate(1,-150,1));
    }

    @DisplayName("Day < 0")
    @Test
    void isValidDateBlock1Day() {
        assertFalse(Date.isValidDate(-150,1,1));
    }

    // Block 2
    @DisplayName("Year == 0")
    @Test
    void isValidDateBlock2Year() {
        assertFalse(Date.isValidDate(1,1,0));
    }

    @DisplayName("Day == 0")
    @Test
    void isValidDateBlock2Day() {
        assertFalse(Date.isValidDate(0,1,1));
    }

    // Block 3
    @DisplayName("Year is Leap")
    @Test
    void isValidDateBlock3Year() {
        assertTrue(Date.isValidDate(1,1,2024));
    }

    @DisplayName("Month with 31")
    @Test
    void isValidDateBlock3Month() {
        assertTrue(Date.isValidDate(31,0,1));
        assertTrue(Date.isValidDate(31,2,1));
        assertTrue(Date.isValidDate(31,4,1));
        assertTrue(Date.isValidDate(31,6,1));
        assertTrue(Date.isValidDate(31,7,1));
        assertTrue(Date.isValidDate(31,9,1));
        assertTrue(Date.isValidDate(31,11,1));
    }

    @DisplayName("1 < Day < MaxMonth")
    @Test
    void isValidDateBlock3Day() {
        assertTrue(Date.isValidDate(31,0,1));
        assertTrue(Date.isValidDate(29,1,2024));
        assertTrue(Date.isValidDate(28,1,2023));
        assertTrue(Date.isValidDate(1,2,2023));
        assertTrue(Date.isValidDate(30,3,2023));
    }

    // Block 4
    @DisplayName("Year is Common")
    @Test
    void isValidDateBlock4Year() {
        assertTrue(Date.isValidDate(1,1,2023));
        assertTrue(Date.isValidDate(1,1,-2023));
    }

    @DisplayName("Month with 30 days")
    @Test
    void isValidDateBlock4Month() {
        assertTrue(Date.isValidDate(30,3,1));
        assertTrue(Date.isValidDate(30,5,1));
        assertTrue(Date.isValidDate(30,8,1));
        assertTrue(Date.isValidDate(30,10,1));
    }

    @DisplayName("Day > max of the month")
    @Test
    void isValidDateBlock4Day() {
        assertFalse(Date.isValidDate(31+1,0,2024));
        assertFalse(Date.isValidDate(28+1,1,2023));
        assertFalse(Date.isValidDate(29+1,1,2024));
        assertFalse(Date.isValidDate(31+1,2,2024));
        assertFalse(Date.isValidDate(30+1,3,2024));
        assertFalse(Date.isValidDate(31+1,4,2024));
        assertFalse(Date.isValidDate(30+1,5,2024));
        assertFalse(Date.isValidDate(31+1,6,2024));
        assertFalse(Date.isValidDate(31+1,7,2024));
        assertFalse(Date.isValidDate(30+1,8,2024));
        assertFalse(Date.isValidDate(31+1,9,2024));
        assertFalse(Date.isValidDate(30+1,10,2024));
        assertFalse(Date.isValidDate(31+1,11,2024));
    }

    // Block 5
    @DisplayName("Month = 1")
    @Test
    void isValidDateBlock5Month() {
        assertTrue(Date.isValidDate(1,1,1));
    }

    // Block 6
    @DisplayName("Month < 0")
    @Test
    void isValidDateBlock6Month() {
        assertFalse(Date.isValidDate(1,150,1));
    }
}