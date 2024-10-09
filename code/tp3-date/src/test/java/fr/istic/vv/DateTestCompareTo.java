package fr.istic.vv;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTestCompareTo {
    static Date test_1_1;
    static Date test_1_2;
    static Date test_2_1;
    static Date test_2_2;
    static Date test_3_1;
    static Date test_3_2;
    static Date test_4_1;
    static Date test_4_2;
    static Date test_5_1;
    static Date test_5_2;

    @BeforeAll
    static void setUp() {
        test_1_1 = new Date(1,1,364);
        test_1_2 = new Date(1,1,365);

        test_2_1 = new Date(1,10,1);
        test_2_2 = new Date(1,11,1);

        test_3_1 = new Date(30,0,1);
        test_3_2 = new Date(31,0,1);

        test_4_1 = new Date(30,0,1);
        test_4_2 = new Date(30,0,1);

        test_5_1 = new Date(31,0,1);
        test_5_2 = null;
    }


    /*      compareTo test suite        */

    @DisplayName("Block 1 : Inferior Year")
    @Test
    void compareToBlock1Year() {
        assertEquals(-1, test_1_1.compareTo(test_1_2));
    }

    @DisplayName("Block 1 : Inferior Month")
    @Test
    void compareToBlock1Month() {
        assertEquals(-1, test_2_1.compareTo(test_2_2));
    }

    @DisplayName("Block 1 : Inferior Day")
    @Test
    void compareToBlock1Day() {
        assertEquals(-1, test_3_1.compareTo(test_3_2));
    }


    @DisplayName("Block 2 : Superior Year")
    @Test
    void compareToBlock2Year() {
        assertEquals(1, test_1_2.compareTo(test_1_1));
    }

    @DisplayName("Block 2 : Superior Month")
    @Test
    void compareToBlock2Month() {
        assertEquals(1, test_2_2.compareTo(test_2_1));
    }

    @DisplayName("Block 2 : Superior Day")
    @Test
    void compareToBlock2Day() {
        assertEquals(1, test_3_2.compareTo(test_3_1));
    }

    @DisplayName("Block 3 : Equals")
    @Test
    void compareToBlock3() {
        assertEquals(0, test_4_1.compareTo(test_4_2));
    }

    @DisplayName("Block 4 : Null")
    @Test
    void compareToBlock4() {
        assertThrows(NullPointerException.class, () -> {
            test_5_1.compareTo(test_5_2);
        });
    }
}