package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {


    private Date createDate(int day, int month, int year)throws Exception{
        return new Date(day,month,year);
    }

    @Test
    public void testCorrectDateOnIsValidDate(){
        try {
            Date date = createDate(01, 01, 2000);
            assertTrue(date.isValidDate(01,01,2000));
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testWrongDateOnIsValidDate(){
        try {
            Date date = createDate(01, 01, 2000);
            assertFalse(date.isValidDate(00,01,2000));
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testWrongDateCreationDay0(){
        Date date;
        try {
            createDate(00, 01, 2000);
            fail(new Exception("Error : Date Creation should fail"));
        }
        catch(Exception e){
            assertNotNull(e);
        }
    }

    @Test
    public void testWrongDateCreationDay31(){
        Date date;
        try {
            createDate(31, 04, 2000);
            fail(new Exception("Error : Date Creation should fail"));
        }
        catch(Exception e){
            assertNotNull(e);
        }
    }

    @Test
    public void testWrongDateCreationMonth13(){
        Date date;
        try {
            createDate(01, 13, 2000);
            fail(new Exception("Error : Date Creation should fail"));
        }
        catch(Exception e){
            assertNotNull(e);
        }
    }

    @Test
    public void testWrongDateCreationMonth0(){
        Date date;
        try {
            createDate(0, 13, 2000);
            fail(new Exception("Error : Date Creation should fail"));
        }
        catch(Exception e){
            assertNotNull(e);
        }
    }

    /*
    Check For Leap year because: year % 4 == 0 and year % 100 ! =0
     */
    @Test
    public void testIsLeapYear2012(){
        try {
            Date date = createDate(01, 01, 2000);
            assertTrue(date.isLeapYear(2012));
        }
        catch(Exception e){
            fail(e);
        }
    }

    /*
    Check For not Leap year because: year % 100 == 0 and year%400 !=0
     */
    @Test
    public void testIsLeapYear2100(){
        try {
            Date date = createDate(01, 01, 2000);
            assertFalse(date.isLeapYear(2100));
        }
        catch(Exception e){
            fail(e);
        }
    }

    /*
    Check For Leap year because: year % 100 == 0 and year % 400 == 0
     */
    @Test
    public void testIsLeapYear2000(){
        try {
            Date date = createDate(01, 01, 2000);
            assertTrue(date.isLeapYear(2000));
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testCompareToCorrectEquals(){
        try {
            Date d1 = new Date(01, 01, 2000);
            Date d2 = new Date(01, 01, 2000);
            assertTrue(d1.compareTo(d2)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testCompareToCorrectSupDay(){
        try {
            Date d1 = new Date(02, 01, 2000);
            Date d2 = new Date(01, 01, 2000);
            assertTrue(d1.compareTo(d2)>0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testCompareToCorrectSupMonth(){
        try {
            Date d1 = new Date(02, 02, 2000);
            Date d2 = new Date(01, 01, 2000);
            assertTrue(d1.compareTo(d2)>0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testCompareToCorrectSupYear(){
        try {
            Date d1 = new Date(02, 01, 2001);
            Date d2 = new Date(01, 01, 2000);
            assertTrue(d1.compareTo(d2)>0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testCompareToCorrectInfDay(){
        try {
            Date d1 = new Date(02, 01, 2000);
            Date d2 = new Date(03, 01, 2000);
            assertTrue(d1.compareTo(d2)<0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testCompareToCorrectInfMonth(){
        try {
            Date d1 = new Date(02, 02, 2000);
            Date d2 = new Date(01, 03, 2000);
            assertTrue(d1.compareTo(d2)<0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testCompareToCorrectInfYear(){
        try {
            Date d1 = new Date(02, 01, 2002);
            Date d2 = new Date(01, 01, 2003);
            assertTrue(d1.compareTo(d2)<0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testNextDateCorrectOnDay(){
        try {
            Date date = createDate(01, 01, 2000);
            Date dateSuivante = createDate(02, 01, 2000);
            assertTrue(date.nextDate().compareTo(dateSuivante)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testNextDateCorrectOnMonth(){
        try {
            Date date = createDate(31, 01, 2000);
            Date dateSuivante = createDate(01, 02, 2000);
            assertTrue(date.nextDate().compareTo(dateSuivante)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testNextDateCorrectOnMonthFebruary(){
        try {
            Date date = createDate(28, 02, 2021);
            Date dateSuivante = createDate(01, 03, 2021);
            assertTrue(date.nextDate().compareTo(dateSuivante)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testNextDateCorrectOnYear(){
        try {
            Date date = createDate(31, 12, 2000);
            Date dateSuivante = createDate(01, 01, 2001);
            date = date.nextDate();
            assertTrue(date.compareTo(dateSuivante)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testPreviousDateCorrectOnDay(){
        try {
            Date date = createDate(02, 01, 2000);
            Date datePrecedente = createDate(01, 01, 2000);
            assertTrue(date.previousDate().compareTo(datePrecedente)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testPreviousDateCorrectOnMonth(){
        try {
            Date date = createDate(01, 02, 2000);
            Date datePrecedente = createDate(31, 01, 2000);
            assertTrue(date.previousDate().compareTo(datePrecedente)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testPreviousDateCorrectOnMonthFebruary(){
        try {
            Date date = createDate(1, 03, 2021);
            Date datePrecedente = createDate(28, 02, 2021);
            assertTrue(date.previousDate().compareTo(datePrecedente)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testPreviousDateCorrectOnYear(){
        try {
            Date date = createDate(1, 1, 2000);
            Date datePrecedente = createDate(31, 12, 1999);
            date = date.previousDate();
            assertTrue(date.compareTo(datePrecedente)==0);
        }
        catch(Exception e){
            fail(e);
        }
    }

    @Test
    public void testNullPointerRaised() {
        try{
            Date date = createDate(1, 1, 2000);
            Date date2 = null;
            date.compareTo(date2);
            fail("Expected NullPointerException but nothing happened");
        }
        catch(NullPointerException e){
            assertNotNull(e);
        }
        catch(Exception e){
            fail("Unexpected Exception Occurred");
        }
    }

}