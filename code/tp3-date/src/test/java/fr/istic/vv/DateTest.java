package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

class DateTest {
	@Test
	public void testNotValidDateException() {
		NotValidDateException thrown = new NotValidDateException(1, 1, 1);
		Assertions.assertEquals("the date: 1/1/1 is not valid", thrown.getMessage());
	}
}