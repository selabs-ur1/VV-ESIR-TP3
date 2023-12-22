package fr.istic.vv;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    void testDateConstructorValid() {
        // Valid date
        assertDoesNotThrow(() -> new Date(1, 1, 2023));
    }

    @Test
    void testDateConstructorInvalid() {
        // Invalid date
        assertThrows(IllegalArgumentException.class, () -> new Date(30, 2, 2023));
        assertThrows(IllegalArgumentException.class, () -> new Date(-1, 1, 2023));
    }

    @Test
    void testIsValidDate() {
        // Valid dates
        assertTrue(Date.isValidDate(1, 1, 2023));
        assertTrue(Date.isValidDate(29, 2, 2024)); // Leap year

        // Invalid dates
        assertFalse(Date.isValidDate(30, 2, 2023));
        assertFalse(Date.isValidDate(31, 4, 2023));
        assertFalse(Date.isValidDate(-1, 1, 2023));
    }

    @Test
    void testIsLeapYear() {
        // Leap years
        assertTrue(Date.isLeapYear(2024));
        assertTrue(Date.isLeapYear(2000));

        // Non-leap years
        assertFalse(Date.isLeapYear(2023));
        assertFalse(Date.isLeapYear(1900));
    }

    @Test
    void testNextDate() {
        // Normal progression
        assertEquals(new Date(2, 1, 2023), new Date(1, 1, 2023).nextDate());
        assertEquals(new Date(1, 2, 2023), new Date(31, 1, 2023).nextDate());

        // End of month
        assertEquals(new Date(1, 3, 2023), new Date(28, 2, 2023).nextDate());

        // End of year
        assertEquals(new Date(1, 1, 2024), new Date(31, 12, 2023).nextDate());

        // Leap year considerations
        assertEquals(new Date(29, 2, 2024), new Date(28, 2, 2024).nextDate());
    }

    @Test
    void testPreviousDate() {
        // Normal progression
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());
        assertEquals(new Date(28, 1, 2023), new Date(29, 1, 2023).previousDate());

        // Beginning of month
        assertEquals(new Date(31, 1, 2023), new Date(1, 2, 2023).previousDate());

        // Beginning of year
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());

        // Leap year considerations
        assertEquals(new Date(28, 2, 2024), new Date(29, 2, 2024).previousDate());
    }

    @Test
    void testCompareTo() {
        // Compare to an earlier date
        assertTrue(new Date(1, 1, 2023).compareTo(new Date(2, 1, 2023)) < 0);

        // Compare to a later date
        assertTrue(new Date(2, 1, 2023).compareTo(new Date(1, 1, 2023)) > 0);

        // Compare to the same date
        assertEquals(0, new Date(1, 1, 2023).compareTo(new Date(1, 1, 2023)));

        // Null comparison
        assertThrows(NullPointerException.class, () -> new Date(1, 1, 2023).compareTo(null));
    }
}
