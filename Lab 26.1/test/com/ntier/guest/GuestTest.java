package com.ntier.guest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GuestTest {

	List<Guest> guests;
	private Guest gst1;

	@BeforeEach
	void setUp() throws Exception {
		gst1 = new Guest("Katrina", "Groves", 250);
		guests = new ArrayList<>();
		guests.add(gst1);

		Guest gst2 = new Guest("Eric", "Groves", 350);
		guests.add(gst2);

		Guest gst3 = new Guest("Bethany", "Etherton", 150);
		guests.add(gst3);

		Guest gst4 = new Guest("Keith", "Towne", 450);
		guests.add(gst4);
	}

	@Test
	void testCompareTo() {
		Collections.sort(guests);
		for (Guest guest : guests) {
			System.out.println(guest);
		}
		String expected = "Eric";
		String actual = guests.get(1).getFirstName();
		assertEquals(expected, actual);
	}
}
