package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    public void testIsValidDate_YearIsValid() {
        assertTrue(Date.isValidDate(1, 1, 2023));
    }

    @Test
    public void testIsValidDate_MonthIsInvalid() {
        assertFalse(Date.isValidDate(1, 13, 2023));
    }

    @Test
    public void testIsValidDate_DayIsInvalid() {
        assertFalse(Date.isValidDate(31, 4, 2023));
    }

    @Test
    public void testIsLeapYear_LeapYear() {
        assertTrue(Date.isLeapYear(2020));
    }

    @Test
    public void testIsLeapYear_NotLeapYear() {
        assertFalse(Date.isLeapYear(2021));
    }

    @Test
    public void testNextDate() {
        assertEquals(
                new Date(1, 1, 2023),
                new Date(31, 12, 2022).nextDate());
    }

    @Test
    public void testPreviousDate() {
        Date currentDate = new Date(1, 1, 2023);
        Date previousDate = currentDate.previousDate();
        assertEquals(new Date(31, 12, 2022), previousDate);
    }

    // step 3
    @Test
    public void testNextDate_SimpleIncrement() {
        assertEquals(new Date(2, 1, 2023), new Date(1, 1, 2023).nextDate());
    }

    @Test
    public void testNextDate_ChangeOfMonth() {
        assertEquals(new Date(1, 1, 2023), new Date(31, 12, 2022).nextDate());
    }

    @Test
    public void testNextDate_ChangeOfYear() {
        assertEquals(new Date(1, 1, 2024), new Date(31, 12, 2023).nextDate());
    }

    @Test
    public void testPreviousDate_SimpleDecrement() {
        assertEquals(new Date(1, 1, 2023), new Date(2, 1, 2023).previousDate());
    }

    @Test
    public void testPreviousDate_ChangeOfMonth() {
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());
    }

    @Test
    public void testPreviousDate_ChangeOfYear() {
        assertEquals(new Date(31, 12, 2023), new Date(1, 1, 2024).previousDate());
    }

    @Test
    public void testPreviousDate_FirstDayOfYear() {
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());
    }


    // TEST Après PIT
    @Test
    public void testBooleanTrueReturnValsMutator() {
        // La méthode isDateValid devrait retourner true pour une date valide.
        assertTrue(Date.isValidDate(1, 1, 2023));
    }


    @Test
    public void testBooleanFalseReturnValsMutator() {
        // La méthode isLeapYear devrait retourner false pour l'année non bissextile.
        assertFalse(Date.isLeapYear(2023));
    }

    @Test
    public void testPrimitiveReturnsMutator() {
        // La méthode getDay devrait retourner le jour spécifié dans le constructeur.
        Date dateInstance = new Date(1, 1, 2023);
        assertEquals(1, dateInstance.getDay());
    }
}