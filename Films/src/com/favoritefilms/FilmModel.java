package com.favoritefilms;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * 
 * @author Katrina Groves
 *
 */
class FilmModel {

	private String name;
	private String type;
	private LocalDate release;
	private String genre;
	private int rating;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, uuuu");

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	void setType(String type) {
		this.type = type;
	}

	public LocalDate getRelease() {
		return release;
	}

	void setRelease(LocalDate release) {
		this.release = release;
	}

	public String getGenre() {
		return genre;
	}

	void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRating() {
		return rating;
	}

	void setRating(int rating) {
		this.rating = rating;
	}

	FilmModel(String name, String type, LocalDate release, String genre, int rating) {
		this.setName(name);
		this.setType(type);
		this.setRelease(release);
		this.setGenre(genre);
		this.setRating(rating);
	}

	@Override
	public String toString() {
		return "Name: " + name + " Type: " + type + " Release: " + release.format(formatter) + " Genre: " + genre
				+ " Rating: " + rating;
	}

}
