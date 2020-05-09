package com.ntier.streams.starters;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class StreamTester {

	public static void main(String[] args) {
		Library lib1 = new Library("books1.txt");
		List<Book> library1 = lib1.getBooks();
//		library1.forEach(System.out::println);

		OptionalInt longestBook = library1.stream().mapToInt(lb -> lb.getNumPages()).max();
		System.out.println("Longest Book: " + longestBook);
		System.out.println("\r");

		OptionalDouble cheapestBook = library1.stream().mapToDouble(cb -> cb.getPrice()).min();
		System.out.println("Cheapest Book: " + cheapestBook);
		System.out.println("\r");

		double bookTotal = library1.stream().mapToDouble(bt -> bt.getPrice()).sum();
		System.out.println("Total Price: " + bookTotal);
		System.out.println("\r");

		System.out.println(searchByTitleOrAuthor(library1, "Java"));
		System.out.println(searchByTitleOrAuthor(library1, "Katrina"));
		System.out.println("\r");

		System.out.println(returnSearch(library1, "Kurt"));
		System.out.println("\r");

		naturalSort(library1);
	}

	static boolean searchByTitleOrAuthor(List<Book> library, String search) {
		return library.stream().anyMatch(ta -> ta.getAuthor().contains(search) || ta.getTitle().contains(search));
	}

	static Optional<Book> returnSearch(List<Book> library, String search) {
		return library.stream().filter(ta -> ta.getAuthor().contains(search) || ta.getTitle().contains(search))
				.findAny();
	}

	static void naturalSort(List<Book> library) {
		library.sort(Comparator.comparing(Book::getTitle));
		library.forEach(System.out::println);
		System.out.println("\r");
	}

	static Optional<List<Book>> getBooksBelowPrice(List<Book> library, double price) {
		List<Book> bookFound = library.stream().filter(b -> b.getPrice() < price)
				.sorted((a, b) -> (int) (a.getPrice() * 1000)).collect(Collectors.toList());
		if (bookFound.size() == 0) {
			return Optional.empty();
		} else {
			return Optional.of(bookFound);
		}
	}
}
