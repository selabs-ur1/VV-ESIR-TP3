package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testCreationDateValide() {
        // Vérifie si la création d'une date valide ne lève pas d'exception
        assertDoesNotThrow(() -> new Date(1, 1, 2022));
    }

    @Test
    void testCreationDateInvalide() {
        // Vérifie si la création d'une date invalide lève une exception IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> new Date(32, 1, 2022));
        assertThrows(IllegalArgumentException.class, () -> new Date(1, 13, 2022));
        assertThrows(IllegalArgumentException.class, () -> new Date(29, 2, 2021)); // Pas une année bissextile
    }

    @Test
    void testEstDateValide() {
        // Vérifie si la fonction estDateValide retourne les résultats attendus
        assertTrue(Date.isValidDate(1, 1, 2022));
        assertFalse(Date.isValidDate(32, 1, 2022));
        assertFalse(Date.isValidDate(1, 13, 2022));
        assertFalse(Date.isValidDate(29, 2, 2021)); // Pas une année bissextile
        assertTrue(Date.isValidDate(29, 2, 2020)); // Année bissextile
    }

    @Test
    void testEstAnneeBissextile() {
        // Vérifie si la fonction estAnneeBissextile retourne les résultats attendus
        assertFalse(Date.isLeapYear(2021));
        assertTrue(Date.isLeapYear(2020));
        assertFalse(Date.isLeapYear(1900));
        assertTrue(Date.isLeapYear(2000));
    }

    @Test
    void testDateSuivante() {
        // Vérifie si la fonction dateSuivante retourne la date suivante attendue
        assertEquals(new Date(1, 1, 2023), new Date(31, 12, 2022).nextDate());
        assertEquals(new Date(1, 3, 2023), new Date(28, 2, 2023).nextDate());
        assertEquals(new Date(1, 3, 2020), new Date(29, 2, 2020).nextDate());
    }

    @Test
    void testDatePrecedente() {
        // Vérifie si la fonction datePrecedente retourne la date précédente attendue
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());
        assertEquals(new Date(28, 2, 2023), new Date(1, 3, 2023).previousDate());
        assertEquals(new Date(29, 2, 2020), new Date(1, 3, 2020).previousDate());
    }

    @Test
    void testComparerDate() {
        // Vérifie si la fonction comparerDate retourne les résultats attendus
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2022);
        assertEquals(0, date1.compareTo(date2));

        date2 = new Date(2, 1, 2022);
        assertTrue(date1.compareTo(date2) < 0);

        date2 = new Date(1, 2, 2022);
        assertTrue(date1.compareTo(date2) < 0);

        date2 = new Date(1, 1, 2023);
        assertTrue(date1.compareTo(date2) < 0);
    }
}
