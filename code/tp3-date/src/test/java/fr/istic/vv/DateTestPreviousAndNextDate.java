package fr.istic.vv;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTestPreviousAndNextDate {

    static Date test_1_1;
    static Date test_1_2;
    static Date test_2_1;
    static Date test_2_2;
    static Date test_3_1;
    static Date test_3_2;
    static Date test_4_1;
    static Date test_4_2;


    @BeforeAll
    static void setUp() {
        // normal
        test_1_1 = new Date(14,0,364);
        test_1_2 = new Date(15,0,364);

        // end of month
        test_2_1 = new Date(31,0,364);
        test_2_2 = new Date(1,1,364);

        // end of year
        test_3_1 = new Date(31,11,364);
        test_3_2 = new Date(1,0,365);

        test_4_1 = new Date(31,11,-1);
        test_4_2 = new Date(1,0,1);
    }

    // Next Day

    @DisplayName("Block 1 : Increase Day")
    @Test
    void nextDateBlock1() {
        assertEquals(0, test_1_1.nextDate().compareTo(test_1_2));
    }

    @DisplayName("Block 2 : Increase Month")
    @Test
    void nextDateBlock2() {
        assertEquals(0, test_2_1.nextDate().compareTo(test_2_2));
    }

    @DisplayName("Block 3 : Increase Year")
    @Test
    void nextDateBlock3() {
        assertEquals(0, test_3_1.nextDate().compareTo(test_3_2));
        assertEquals(0, test_4_1.nextDate().compareTo(test_4_2));
    }

    // Previous Day

    @DisplayName("Block 1 : Decrease Day")
    @Test
    void previousDateBlock1() {
        assertEquals(0, test_1_2.previousDate().compareTo(test_1_1));
    }

    @DisplayName("Block 2 : Decrease Month")
    @Test
    void previousDateBlock2() {
        assertEquals(0, test_2_2.previousDate().compareTo(test_2_1));
    }

    @DisplayName("Block 3 : Decrease Year")
    @Test
    void previousDateBlock3() {
        assertEquals(0, test_3_2.previousDate().compareTo(test_3_1));
        assertEquals(0, test_4_2.previousDate().compareTo(test_4_1));
    }

}