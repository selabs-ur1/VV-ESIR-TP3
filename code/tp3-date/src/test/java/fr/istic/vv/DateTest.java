package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.Date.isValidDate;
import static fr.istic.vv.Date.isLeapYear;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    /**** Constructeur pour une mauvaise date ****/
    @Test
    void dateConstructor() throws Exception {
        assertThrows(Date.BadDateException.class,
                () -> new Date(-1,3,5));
    }

    /**** Méthode isLeapYear ****/

    @Test
    void isLeapYear1(){ // Divisible uniquement par 4
        assertTrue(isLeapYear(2012));
    }
    @Test
        void isLeapYear2(){ // Divisible par 4, par 100 mais pas 400
        assertFalse(isLeapYear(2100));
    }
    @Test
    void isLeapYear3(){ // Divisible par 4, par 100 et par 400
        assertTrue(isLeapYear(2000));
    }
    @Test
    void isLeapYear4(){ // Non divisible par 4, 100 ou 400
        assertFalse(isLeapYear(1997));
    }

    /**** Méthode isValidDate ****/
    @Test
    void isValidDate1(){ // bad year
        assertFalse(isValidDate(1, 1, 0));
    }
    @Test
    void isValidDate2(){ // bad year and bad month
        assertFalse(isValidDate(1, -1, 0));
    }
    @Test
    void isValidDate3(){ // bad year and bad day
        assertFalse(isValidDate(-1,-1,0));
    }
    @Test
    void isValidDate4(){ // bad year bad month and bad day
        assertFalse(isValidDate(-1, -1, 0));
    }
    @Test
    void isValidDate5(){ // bad month and bad day
        assertFalse(isValidDate(-1, 0, 1));
    }
    @Test
    void isValidDate6(){ // année bissextile
        assertTrue(isValidDate(1, 1, 2024));
    }
    @Test
    void isValidDate7(){ // année bissextile le 29 février
        assertTrue(isValidDate(29,2,2024));
    }
    @Test
    void isValidDate8(){ // année non bissextile le 29 février
        assertFalse(isValidDate(29,2,2023));
    }
    @Test
    void isValidDate9(){ // jour dépassant le maximum possible
        assertFalse(isValidDate(31,4,2020));
    }
    @Test
    void isValidDate10(){ // mois dépassant le nombre possible
        assertFalse(isValidDate(1,13,2020));
    }
    @Test
    void isValidDate11(){ // année non bissextile le 28 février
        assertTrue(isValidDate(28,2,2021));
    }
    // ajout après PIT
    @Test
    void isValidDate12(){ // mois et jours dépassant le nombre possible
        assertFalse(isValidDate(32,13,2020));
    }
    @Test
    void isValidDate14(){ // mois à 0
        assertFalse(isValidDate(15,0,2020));
    }
    @Test
    void isValidDate16(){ // jour à 0
        assertFalse(isValidDate(0,1,2020));
    }


    /**** Méthode compareTo ****/

    @Test
    void compareTo1(){ // rien en commun, this antérieur à other
        Date d1 = new Date(2,6,2000);
        Date d2 = new Date(3,5,2002);
        assertTrue(d1.compareTo(d2) > 0);
    }
    @Test
    void compareTo2(){ // jour identique, this antérieur à other
        Date d1 = new Date(2,6,2001);
        Date d2 = new Date(2,5,2002);
        assertTrue(d1.compareTo(d2) > 0);
    }
    @Test
    void compareTo3(){ // mois identique, this antérieur à other
        Date d1 = new Date(5,5,2001);
        Date d2 = new Date(2,5,2002);
        assertTrue(d1.compareTo(d2) > 0);
    }
    @Test
    void compareTo4(){ // année identique, this antérieur à other
        Date d1 = new Date(3,5,2002);
        Date d2 = new Date(1,6,2002);
        assertTrue(d1.compareTo(d2) > 0);
    }

    @Test
    void compareTo5(){ // rien en commun, this postérieur à other
        Date d1 = new Date(2,6,2000);
        Date d2 = new Date(3,5,2002);
        assertTrue(d2.compareTo(d1) < 0);
    }
    @Test
    void compareTo6(){ // jour identique, this postérieur à other
        Date d1 = new Date(2,3,2001);
        Date d2 = new Date(2,5,2002);
        assertTrue(d2.compareTo(d1) < 0);
    }
    @Test
    void compareTo7(){ // mois identique, this postérieur à other
        Date d1 = new Date(5,5,2001);
        Date d2 = new Date(2,5,2002);
        assertTrue(d2.compareTo(d1) < 0);
    }
    @Test
    void compareTo8(){ // année identique, this postérieur à other
        Date d1 = new Date(3,5,2002);
        Date d2 = new Date(1,6,2002);
        assertTrue(d2.compareTo(d1) < 0);
    }
    @Test
    void compareTo9(){ // dates identiques
        Date d1 = new Date(3,5,2002);
        Date d2 = new Date(3,5,2002);
        assertEquals(0, d1.compareTo(d2));
    }

    @Test
    void compareTo10() throws Exception { // autre date null
        Date d1 = new Date(3,5,2002);
        assertThrows(NullPointerException.class, () -> {
            d1.compareTo(null);
        });
    }

    // Ajout après PIT
    @Test
    void compareTo11() { // mois et année identiques, this anterieur à other
        Date d1 = new Date(1,5,2002);
        Date d2 = new Date(3,5,2002);
        assertTrue(d1.compareTo(d2) > 0);
    }

    @Test
    void compareTo12() { // mois et année identiques, this posterieur à other
        Date d1 = new Date(1,5,2002);
        Date d2 = new Date(3,5,2002);
        assertTrue(d2.compareTo(d1) < 0);
    }

    /**** Méthode nextDate ****/

    @Test
    void nextDate1(){
        Date date = new Date(3,5,2002);
        Date nextDate = new Date(4,5,2002);
        assertEquals(0, nextDate.compareTo(date.nextDate()));
    }
    @Test
    void nextDate2(){ // fin d'un mois de 31 jours
        Date date = new Date(31,1,2002);
        Date nextDate = new Date(1,2,2002);
        assertEquals(0, nextDate.compareTo(date.nextDate()));
    }
    @Test
    void nextDate3(){ // fin d'un mois de février en année non bissextile
        Date date = new Date(28,2,2001);
        Date nextDate = new Date(1,3,2001);
        assertEquals(0, nextDate.compareTo(date.nextDate()));
    }
    @Test
    void nextDate4(){ // fin d'un mois de février en année bissextile
        Date date = new Date(29,2,2000);
        Date nextDate = new Date(1,3,2000);
        assertEquals(0, nextDate.compareTo(date.nextDate()));
    }

    @Test
    void nextDate5(){ // fin d'un mois de février en année non bissextile pour une année bissextile
        Date date = new Date(28,2,2000);
        Date nextDate = new Date(29,2,2000);
        assertEquals(0, nextDate.compareTo(date.nextDate()));
    }
    @Test
    void nextDate6() { // fin d'une année
        Date date = new Date(31, 12, 2000);
        Date nextDate = new Date(1,1,2001);
        assertEquals(0, nextDate.compareTo(date.nextDate()));
    }

    // Ajout après PIT
    @Test
    void nextDate7(){ // fin d'un mois de 30 jours
        Date date = new Date(30,4,2002);
        Date nextDate = new Date(1,5,2002);
        assertEquals(0, nextDate.compareTo(date.nextDate()));
    }

    /**** Méthode previousDate ****/

    @Test
    void previousDate1(){
        Date date = new Date(3,5,2002);
        Date previousDate = new Date(2,5,2002);
        assertEquals(0, previousDate.compareTo(date.previousDate()));
    }
    @Test
    void previousDate2(){ // début d'un mois avec un précédent mois à 30 jours
        Date date = new Date(1,5,2002);
        Date previousDate = new Date(30,4,2002);
        assertEquals(0, previousDate.compareTo(date.previousDate()));
    }
    @Test
    void previousDate3(){ // début d'un mois avec un précédent mois à 31 jours
        Date date = new Date(1,8,2001);
        Date previousDate = new Date(31,7,2001);
        assertEquals(0, previousDate.compareTo(date.previousDate()));
    }

    @Test
    void previousDate4(){ // début d'un mois de mars en année non bissextile
        Date date = new Date(1,3,2001);
        Date previousDate = new Date(28,2,2001);
        assertEquals(0, previousDate.compareTo(date.previousDate()));
    }
    @Test
    void previousDate5(){ // début d'un mois de mars en année bissextile
        Date date = new Date(1,3,2000);
        Date previousDate = new Date(29,2,2000);
        assertEquals(0, previousDate.compareTo(date.previousDate()));
    }
    @Test
    void previousDate6() { // début d'une année
        Date date = new Date(1, 1, 2000);
        Date previousDate = new Date(31,12,1999);
        assertEquals(0, previousDate.compareTo(date.previousDate()));
    }


}
