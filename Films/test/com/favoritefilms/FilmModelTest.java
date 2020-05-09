package com.favoritefilms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FilmModelTest {

	FilmModel fm = new FilmModel("Fight Club", "Movie", LocalDate.of(1999, 9, 10), "Drama", 3);

	@Test
	void testGetName() {
		String expected = "Fight Club";
		String actual = fm.getName();
		assertEquals(actual, expected);
	}

	@Test
	void testGetType() {
		String expected = "Movie";
		String actual = fm.getType();
		assertEquals(actual, expected);
	}

	@Test
	void testGetRelease() {
		LocalDate expected = LocalDate.of(1999, 9, 10);
		LocalDate actual = fm.getRelease();
		assertEquals(actual, expected);
	}

	@Test
	void testGetGenre() {
		String expected = "Drama";
		String actual = fm.getGenre();
		assertEquals(actual, expected);
	}

	@Test
	void testGetRating() {
		int expected = 3;
		int actual = fm.getRating();
		assertEquals(actual, expected);
	}

	@Test
	void testToString() {
		String expected = "Name: Fight Club Type: Movie Release: September 10, 1999 Genre: Drama Rating: 3";
		String actual = fm.toString();
		assertEquals(actual, expected);
	}

}
