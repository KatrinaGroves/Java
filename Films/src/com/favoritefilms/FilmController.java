package com.favoritefilms;

import java.util.Comparator;
/**
 * 
 * @author Katrina Groves
 *
 */
class FilmController {

	FilmDAO fd = new FilmDAO();

	void printFilmList() {
		fd.getFilmList().sort(Comparator.comparing(FilmModel::getName));
		fd.getFilmList().forEach(System.out::println);
	}

	void sortByRating() {
		fd.getFilmList().sort(Comparator.comparing(FilmModel::getRating).reversed());
		fd.getFilmList().forEach(System.out::println);
	}

	void searchByGenre(String genre) {
		fd.getFilmList().stream().filter(fl -> fl.getGenre().equalsIgnoreCase(genre)).forEach(System.out::println);
	}
}
