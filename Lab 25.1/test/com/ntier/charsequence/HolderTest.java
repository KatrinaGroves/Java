package com.ntier.charsequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolderTest {

	private Holder<StringBuilder> myHolder;

	@BeforeEach
	void setUp() throws Exception {
		myHolder = new Holder<>(new StringBuilder("Constructor"));
	}

	@Test
	void testGetCs() {
		myHolder.setCs(new StringBuilder("Ringo"));
		String expected = "Ringo";
		String actual = myHolder.getCs().toString();
		assertEquals(expected, actual);

		// another way
		assertTrue(myHolder.getCs() instanceof StringBuilder);
	}

	@Test
	void testCharLength() {
		myHolder.setCs(new StringBuilder("Killian"));
		int expected = 7;
		int actual = myHolder.getCs().length();
		assertEquals(expected, actual);
	}

	@Test
	void testHolder() {
		String expected = "Constructor";
		String actual = myHolder.toString();
		assertEquals(expected, actual);
	}

	@Test
	void testCharSub() {
		CharSequence expected = "ns";
		CharSequence actual = myHolder.subSequence(2, 4);
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		String expected = "Constructor";
		String actual = myHolder.toString();
		assertEquals(expected, actual);
	}
}
