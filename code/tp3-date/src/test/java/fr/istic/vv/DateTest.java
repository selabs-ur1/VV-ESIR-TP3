package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DateTest {

    // common value
    int negative = -1;
    int zero = 0;

    // month value
    int day31 = 1;
    int day30 = 4;
    int feb = 2;
    int aboveMonth = 13;

    // year value
    int leap = 2000;
    int common = 2001;

    // day value
    int valideDay = 18;
    int aboveDay = 32;

    @Test
    public void isLeapYear_InputDomain() {
        assertTrue(Date.isLeapYear(leap), "2000 is a leap year");
        assertFalse(Date.isLeapYear(common), "2001 is not a leap year");

    }

    @Test
    public void is31Day_InputDomain() {


        assertFalse(Date.is31Day(negative), "month can't be negative");
        assertFalse(Date.is31Day(zero), "month can't be null");
        assertTrue(Date.is31Day(day31), "january have 31 days");
        assertFalse(Date.is31Day(feb), "february have only 30 at max");
        assertFalse(Date.is31Day(day30), "april have 30 days");
        assertFalse(Date.is31Day(aboveMonth), "there is no more than 12 month");

    }

    @Test
    public void isValideDateDay_InputDomain() {

        // day test
        assertFalse(Date.isValidDate(negative, day30, common));
        assertFalse(Date.isValidDate(zero, day30, common));
        assertTrue(Date.isValidDate(valideDay, day30, common));
        assertFalse(Date.isValidDate(aboveDay, day30, common));


    }

    public void isValideDateMonth_InputDomain() {

        // month test
        assertFalse(Date.isValidDate(valideDay, negative, common));
        assertFalse(Date.isValidDate(valideDay, zero, common));
        assertTrue(Date.isValidDate(valideDay, day30, common));
        assertTrue(Date.isValidDate(valideDay, day31, common));
        assertTrue(Date.isValidDate(valideDay, feb, common));
        assertFalse(Date.isValidDate(valideDay, aboveMonth, common));
    }

    public void isValideDateYear_InputDomain() {

        // year test
        assertTrue(Date.isValidDate(valideDay, day31, negative));
        assertTrue(Date.isValidDate(valideDay, day31, zero));
        assertTrue(Date.isValidDate(valideDay, day31, leap));
        assertTrue(Date.isValidDate(valideDay, day31, common));
    }

    @Test
    public void isValideDate_LeapYear() {

        assertTrue(Date.isValidDate(valideDay, feb, leap));
        assertTrue(Date.isValidDate(30, feb, leap));
        assertFalse(Date.isValidDate(30, 2, common));
        assertFalse(Date.isValidDate(31, 2, leap));
        
    }


    @Test
    public void compareTo_InputDomain(){

        Date day = new Date(valideDay, day30, common);

        assertThrows(NullPointerException.class, () -> day.compareTo(null));
        assertTrue( 0 == day.compareTo(day));

    }

    @Test
    public void compareTo_Years(){
        Date date = new Date(valideDay, day30, 2000);
        Date date2 = new Date(valideDay, day30, 2002);

        assertTrue( 1 == date2.compareTo(date));
        assertTrue( -1 == date.compareTo(date2));
    }

    @Test
    public void compareTo_Month(){
        Date date = new Date(valideDay, 6, common);
        Date date2 = new Date(valideDay, 12, common);

        assertTrue( 1 == date2.compareTo(date));
        assertTrue( -1 == date.compareTo(date2));
    }

    @Test
    public void compareTo_Day(){
        Date date = new Date(4, day30, common);
        Date date2 = new Date(30, day30, common);

        assertTrue( 1 == date2.compareTo(date));
        assertTrue( -1 == date.compareTo(date2));
    }


    @Test
    public void nextDate_Normal(){

        Date firstJan = new Date(1, 1, 2001);
        Date twoJan = new Date(2, 1, 2001);
        Date firstApril = new Date(1, 4, 2001);
        Date twoApril = new Date(2, 4, 2001);

        //normal case
        assertTrue(0 == (firstJan.nextDate().compareTo(twoJan)));
        assertTrue(0 == (firstApril.nextDate().compareTo(twoApril)));

    }

    @Test
    public void nextDate_ChangeYear(){
        Date firstJan = new Date(1, 1, 2001);
        Date lastDec = new Date(31, 12, 2000);

        //change of year
        assertTrue(0 == (lastDec.nextDate().compareTo(firstJan)));
    }

    @Test
    public void nextDate_Leap(){

        Date leapFeb = new Date(30, 2, 2000);
        Date leapFebPlusOne = new Date(1, 3, 2000);
        Date commonFeb = new Date(29, 2, 2001);
        Date commonFebPlusOne = new Date(1, 3, 2001);

        //leap year
        assertTrue(0 == (leapFeb.nextDate().compareTo(leapFebPlusOne)));
        assertTrue(0 == (commonFeb.nextDate().compareTo(commonFebPlusOne)));
    }


        @Test
    public void previousDate_Normal(){

        Date firstJan = new Date(1, 1, 2001);
        Date twoJan = new Date(2, 1, 2001);

        Date firstJuly = new Date(1, 7, 2001);
        Date lastJune = new Date(30, 6, 2001);

        //normal case
        assertTrue(0 == (twoJan.previousDate().compareTo(firstJan)));
        assertTrue(0 == (firstJuly.previousDate().compareTo(lastJune)));

    }

    @Test
    public void previousDate_ChangeYear(){
        Date firstJan = new Date(1, 1, 2001);
        Date lastDec = new Date(31, 12, 2000);

        //change of year
        assertTrue(0 == (firstJan.previousDate().compareTo(lastDec)));
    }

    @Test
    public void previousDate_Leap(){

        Date leapFeb = new Date(30, 2, 2000);
        Date leapFebPlusOne = new Date(1, 3, 2000);
        Date commonFeb = new Date(29, 2, 2001);
        Date commonFebPlusOne = new Date(1, 3, 2001);

        //leap year
        assertTrue(0 == (leapFebPlusOne.previousDate().compareTo(leapFeb)));
        assertTrue(0 == (commonFebPlusOne.previousDate().compareTo(commonFeb)));
    }


}