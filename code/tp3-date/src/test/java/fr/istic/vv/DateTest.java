package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void isValidDateDay() {
        assertFalse(Date.isValidDate(0, 12, 1980));
        assertFalse(Date.isValidDate(32, 12, 1980));
        assertFalse(Date.isValidDate(-1, 12, 1980));

        assertTrue(Date.isValidDate(1, 12, 1980));
    }

    @Test
    public void isValidDateMonth() {
        assertFalse(Date.isValidDate(1, 0, 1980));
        assertFalse(Date.isValidDate(1, 13, 1980));
        assertFalse(Date.isValidDate(1, -1, 1980));

        assertTrue(Date.isValidDate(1, 1, 1980));
    }

    @Test
    public void isValidDateYear() {
        assertTrue(Date.isValidDate(1, 12, -4000));
        assertTrue(Date.isValidDate(1, 12, 0));
        assertTrue(Date.isValidDate(1, 12, 1980));
    }

    @Test
    public void isValidDateCombined() {
        assertFalse(Date.isValidDate(0, 0, 2000));
        assertFalse(Date.isValidDate(32, 12, 2000));
    }

    @Test
    public void isValidDateFebruaryAndLeap() {
        assertTrue(Date.isValidDate(29, 2, 2020));
        assertFalse(Date.isValidDate(29, 2, 2023));
    }

    @Test
    public void Date() {
        assertThrows(IllegalArgumentException.class, () -> new Date(0, 0, 2000));
        assertThrows(IllegalArgumentException.class, () -> new Date(32, 12, 2000));
        assertThrows(IllegalArgumentException.class, () -> new Date(29, 2, 2023));
    }

    /*
    Tester la bissextilité : divisible par 4 sauf centenaire non divisible par 400

    - cas divisible par 4 mais pas par 400
    - cas divisible par 4 et par 400
    - cas non divisible par 4
     */
    @Test
    void isLeapYear() {
        assertFalse(Date.isLeapYear(2018)); // non divisible par 4
        assertTrue(Date.isLeapYear(2008));  // divisible par 4, mais non par 100
        assertTrue(Date.isLeapYear(2000));  // divisible par 400
        assertFalse(Date.isLeapYear(1900));  // non divisible par 400, mais par quatre

    }

    @Test
    void nextDate() {
        // normal
        assertEquals(new Date(2, 1, 10_000), new Date(1, 1, 10_000).nextDate());

        assertEquals(new Date(1, 5, 2023), new Date(30, 4, 2023).nextDate());

        // jusqu'au mois d'après
        assertEquals(new Date(1, 2, 10_000), new Date(31, 1, 10_000).nextDate());
        // jusqu'à l'année d'après
        assertEquals(new Date(1, 1, 10_001), new Date(31, 12, 10_000).nextDate());
        // jusqu'au 29 février
        assertEquals(new Date(29, 2, 2020), new Date(28, 2, 2020).nextDate());

        // après PIT
        assertEquals(new Date(1, 12, 2020), new Date(30, 11, 2020).nextDate());
    }

    @Test
    void previousDate() {
        assertEquals(new Date(1, 1, 2022), new Date(2, 1, 2022).previousDate());

        // au mois précédent
        assertEquals(new Date(31, 1, 2022), new Date(1, 2, 2022).previousDate());
        assertEquals(new Date(30, 4, 2022), new Date(1, 5, 2022).previousDate());

        // au dernier jour de l'année précédente
        assertEquals(new Date(31, 12, 2023), new Date(1, 1, 2024).previousDate());
        // au dernier jour de l'année 0
        assertEquals(new Date(31, 12, 0), new Date(1, 1, 1).previousDate());
        // au 29 février
        assertEquals(new Date(29, 2, 2024), new Date(1, 3, 2024).previousDate());
    }

    @Test
    public void compareToEqualDates() {
        Date date1 = new Date(1, 1, 2024);
        Date date2 = new Date(1, 1, 2024);
        assertEquals(0, date1.compareTo(date2));
    }

    @Test
    public void compareToNormalDates() {
        // date plus tôt
        Date date1 = new Date(1, 1, 2024);
        Date date2 = new Date(2, 1, 2024);
        assertTrue(date1.compareTo(date2) < 0);

        // date plus tard
        date1 = new Date(2, 1, 2024);
        date2 = new Date(1, 1, 2024);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    public void compareToDifferentUnits() {
        Date date_y1 = new Date(1, 1, 2024);
        Date date_y2 = new Date(1, 1, 2025);
        assertTrue(date_y1.compareTo(date_y2) < 0);
        assertTrue(date_y2.compareTo(date_y1) > 0);

        Date date_m1 = new Date(1, 1, 2024);
        Date date_m2 = new Date(1, 2, 2024);
        assertTrue(date_m1.compareTo(date_m2) < 0);
        assertTrue(date_m2.compareTo(date_m1) > 0);

        Date date_d1 = new Date(1, 1, 2024);
        Date date_d2 = new Date(2, 1, 2024);
        assertTrue(date_d1.compareTo(date_d2) < 0);
        assertTrue(date_d2.compareTo(date_d1) > 0);
    }

    @Test
    public void equalsSameDates() {
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2022);
        assertEquals(date1, date2);

        assertTrue(date1.equals(date1));
        assertTrue(date2.equals(date2));
    }

    @Test
    public void equalsDifferentDates() {
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(2, 1, 2022);
        assertNotEquals(date1, date2);
    }

    @Test
    public void equalsNullDifferent() {
        Date date1 = new Date(1, 1, 2022);
        assertFalse(date1.equals(null));
        assertFalse(date1.equals("Pas une date"));

        Date date3 = new Date(2, 1, 2022);
        assertFalse(date1.equals(date3), "Different day should return false.");
        Date date4 = new Date(1, 2, 2022);
        assertFalse(date1.equals(date4), "Different month should return false.");
        Date date5 = new Date(1, 1, 2023);
        assertFalse(date1.equals(date5), "Different year should return false.");
    }
}