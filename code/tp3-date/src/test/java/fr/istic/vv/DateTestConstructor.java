package fr.istic.vv;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTestConstructor {

    @DisplayName("Test Constructor with a False Date")
    @Test
    void DateTest() {
        assertThrows(AssertionError.class, ()->{new Date(15,1,0);});
    }

}
