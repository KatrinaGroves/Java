package com.ntier.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		String[] family = { "Eric", "Debra", "Kelly", "Joey", "Trini", "Trinidad", "Toni", "Bethany", "Keith", "Kai" };
		Stream<String> familyStream = Arrays.stream(family);
		System.out.println(familyStream.filter(i -> i.toLowerCase().contains("i")).count());

		List<String> familyList = Arrays.asList(family);
		Stream<String> familyListStream = familyList.stream();
		System.out.println(familyListStream.filter(t -> t.toLowerCase().contains("t")).count());

		Map<Integer, String> familyMap = new HashMap<>();
		familyMap.put(10, "Eric");
		familyMap.put(5, "Debra");
		familyMap.put(6, "Kelly");
		familyMap.put(4, "Joey");
		familyMap.put(2, "Trini");
		familyMap.put(7, "Trinidad");
		familyMap.put(8, "Toni");
		familyMap.put(1, "Bethany");
		familyMap.put(3, "Keith");
		familyMap.put(9, "Kai");
		Set<Entry<Integer, String>> ranking = familyMap.entrySet();
		ranking.stream().forEach(r -> System.out.println(r.getKey() + " " + r.getValue()));

		try (Stream<String> file = Files.lines(Paths.get("myPeople.txt"))) {
			file.forEach(line -> {
				String[] data = line.split(",");
				System.out.print(data[0]);
				System.out.println(" " + data[1]);
			});
		} catch (IOException ex) {
			System.out.println("File Not Found");
		}

		OptionalDouble doubles = DoubleStream.of(55.9, 96.4, 24.8, 101.5, 125.4, 61.7, 42.6).max();
		System.out.println(doubles);

		double doubleMax = DoubleStream.of(55.9, 96.4, 24.8, 101.5, 125.4, 61.7, 42.6).sum();
		System.out.println(doubleMax);
		
		OptionalDouble doubleMin = DoubleStream.of(55.9, 96.4, 24.8, 101.5, 125.4, 61.7, 42.6).min();
		System.out.println(doubleMin);
		
		double doubleCount = DoubleStream.of(55.9, 96.4, 24.8, 101.5, 125.4, 61.7, 42.6).count();
		System.out.println(doubleCount);
	}
}
