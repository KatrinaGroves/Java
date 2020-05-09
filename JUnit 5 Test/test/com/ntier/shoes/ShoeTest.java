package com.ntier.shoes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoeTest {

	private Shoe myShoe;

	@BeforeEach
	void setUp() throws Exception {
		// stuff that more than one test needs
		System.out.println("setup ran");

		myShoe = new Shoe();
	}

	@Test
	void testGetSize() {
		int expected = 10;
		myShoe.setSize(10);
		int actual = myShoe.getSize();
		assertEquals(expected, actual);
	}

	@Test
	void testConvertSizeToEuropean() {
		double expected = 43;
		myShoe.setSize(10);
		double actual = myShoe.convertSizeToEuropean();
		assertEquals(expected, actual);
	}

}
