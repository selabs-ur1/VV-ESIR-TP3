package fr.istic.vv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

  @Test
  public void testIsValidDate() {
    // Caractéristique : Année normalement toujours valide
    assertTrue(Date.isValidDate(1, 1, 2000)); // Bloc : Mois valide, jour valide
    assertFalse(Date.isValidDate(0, 1, 2000)); // Bloc : Mois invalide, jour valide
    assertTrue(Date.isValidDate(31, 12, 0)); // Bloc : Mois valide, jour valide
    assertFalse(Date.isValidDate(32, 12, 0)); // Bloc : Mois valide, jour invalide
    assertFalse(Date.isValidDate(32, 10, 0)); // Bloc : Mois valide, jour invalide
    assertFalse(Date.isValidDate(31, 11, 0)); // Bloc : Mois valide, jour invalide
    assertTrue(Date.isValidDate(30, 11, 0)); // Bloc : Mois valide, jour valide
    assertFalse(Date.isValidDate(1, 0, 2000)); // Bloc : Mois valide, jour invalide
    assertFalse(Date.isValidDate(1, 13, 2000)); // Bloc : Mois valide, jour invalide
    assertFalse(Date.isValidDate(5, 13, 2000)); // Bloc : Mois valide, jour invalide
    assertTrue(Date.isValidDate(1, 5, 2000)); // Bloc : Mois valide, jour valide
    assertTrue(Date.isValidDate(1, 12, 0)); // Bloc : Mois valide, jour valide
    assertTrue(Date.isValidDate(15, 7, 0)); // Bloc : Mois valide, jour valide
    assertFalse(Date.isValidDate(0, 0, 2000)); // Bloc : Mois invalide, jour invalide
    assertFalse(Date.isValidDate(0, 5, 2000)); // Bloc : Mois invalide, jour invalide

    assertTrue(Date.isValidDate(29, 2, 2000)); // Bloc : Mois valide, jour valide (année bissextile)
    assertFalse(Date.isValidDate(30, 2, 2000)); // Bloc : Mois valide, jour invalide (année bissextile)
    assertFalse(Date.isValidDate(29, 2, 1900)); // Bloc : Mois valide, jour invalide (année non bissextile)
  }

  @Test
  public void testIsLeapYear() {
    assertTrue(Date.isLeapYear(2000));
    assertTrue(Date.isLeapYear(2024));// Bloc : Année bissextile
    assertFalse(Date.isLeapYear(1900));
    assertFalse(Date.isLeapYear(1903));
    assertTrue(Date.isLeapYear(1600));// Bloc : Année non bissextile
  }

  @Test
  public void testNextDate() {
    // Caractéristique : Date au milieu du mois, dernier jour du mois, scénarios bissextiles et non bissextiles
    assertEquals(new Date(16, 1, 2000), new Date(15, 1, 2000).nextDate()); // Bloc : Milieu du mois, non dernier jour
    assertEquals(new Date(1, 2, 2000), new Date(31, 1, 2000).nextDate()); // Bloc : Milieu du mois, dernier jour (année bissextile)
    assertEquals(new Date(1, 3, 2000), new Date(29, 2, 2000).nextDate()); // Bloc : Février dans une année bissextile
    assertEquals(new Date(1, 3, 1900), new Date(28, 2, 1900).nextDate()); // Bloc : Février dans une année non bissextile
  }

  @Test
  public void testPreviousDate() {
    // Caractéristique : Date au milieu du mois, premier jour du mois, scénarios bissextiles et non bissextiles
    assertEquals(new Date(15, 1, 2000), new Date(16, 1, 2000).previousDate()); // Bloc : Milieu du mois, non premier jour
    assertEquals(new Date(31, 1, 2000), new Date(1, 2, 2000).previousDate()); // Bloc : Milieu du mois, premier jour (année bissextile)
    assertEquals(new Date(29, 2, 2000), new Date(1, 3, 2000).previousDate()); // Bloc : Février dans une année bissextile
    assertEquals(new Date(28, 2, 1900), new Date(1, 3, 1900).previousDate()); // Bloc : Février dans une année non bissextile
  }

  @Test
  public void testCompareTo() {
    Date date1 = new Date(1, 1, 2000);
    Date date2 = new Date(1, 1, 2001);

    // Caractéristique : Comparaison des dates : Date avant l'autre, après l'autre, identique à l'autre
    assertTrue(date1.compareTo(date2) < 0); // Bloc : Date avant l'autre
    assertTrue(date2.compareTo(date1) > 0); // Bloc : Date après l'autre
    assertEquals(0, date1.compareTo(new Date(1, 1, 2000))); // Bloc : Date identique à l'autre
  }
}
