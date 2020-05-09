package com.favoritefilms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/**
 * 
 * @author Katrina Groves
 *
 */
class FilmDAO {

	private List<FilmModel> filmList = new ArrayList<>();

	public List<FilmModel> getFilmList() {
		return getFilmData();
	}

	List<FilmModel> getFilmData() {
		try (Stream<String> file = Files.lines(Paths.get("films.txt"))) {
			file.forEach(line -> {
				String[] list = line.split(",");
				FilmModel film = new FilmModel(list[0], list[1], LocalDate.parse(list[2]), list[3], Integer.parseInt(list[4]));
				filmList.add(film);
			});
		} catch (IOException ex) {
			System.out.println("File Not Found");
		}
		return filmList;
	}
}
