package com.discord.insulter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class InsultDAO {

	static String addInsults() {
		List<String> insults = new ArrayList<>();
		try (Stream<String> file = Files.lines(Paths.get("insults.txt"))) {
			file.forEach(line -> {
				insults.add(line);
			});
		} catch (IOException ex) {
			System.out.println("File Not Found");
		}
		return insults.get((int) (Math.random() * (insults.size() - 1)));
	}

}
