package com.ntier.streams.starters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import com.ntier.streams.starters.Book.Category;

public class StreamTester {

	public static void main(String[] args) {
		Library lib1 = new Library("books1.txt");
		List<Book> library1 = lib1.getBooks();
//		library1.forEach(System.out::println);

		library1.stream().filter(b -> b.getCategory().equals(Book.Category.FICTION)).map(b -> b.getTitle())
				.forEach(t -> System.out.println(t));
		System.out.println("\r");

		library1.stream().filter(b -> b.getCategory().equals(Book.Category.COMIC)).map(Book::getTitle)
				.forEach(System.out::println);
		System.out.println("\r");

		library1.stream().filter(
				b -> b.getCategory().equals(Book.Category.COOKING) || b.getCategory().equals(Book.Category.HOW_TO))
				.map(b -> b.getTitle()).forEach(System.out::println);
		System.out.println("\r");

		library1.stream().filter(b -> b.getPrice() > 20).map(b -> b.getTitle()).forEach(System.out::println);
		System.out.println("\r");

		library1.stream().filter(b -> b.getYearPublished() < 1999).map(b -> b.getTitle()).forEach(System.out::println);
		System.out.println("\r");

		OptionalDouble avgPrice = library1.stream().mapToDouble(b -> b.getPrice()).average();
		avgPrice.ifPresent(p -> System.out.printf("%.2f", p));
		System.out.println("\r");

		OptionalDouble avgPriceFiction = library1.stream().filter(b -> b.getCategory().equals(Book.Category.SELF_HELP))
				.mapToDouble(b -> b.getPrice()).average();
		avgPriceFiction.ifPresent(p -> System.out.printf("%.2f", p));
		System.out.println("\r");

		OptionalDouble avgPriceComics = library1.stream().filter(b -> b.getCategory().equals(Book.Category.COMIC))
				.mapToDouble(b -> b.getPrice()).average();
		System.out.println(avgPriceComics.orElse(-1));
		System.out.println(avgPriceComics.orElseGet(() -> -2));
		if (avgPriceComics.isPresent()) {
			System.out.printf("%.2f", avgPriceComics.getAsDouble());
		} else {
			System.out.printf("No comic books found");
		}
		System.out.println("\r");

		OptionalDouble avgNumPages = library1.stream().mapToInt(b -> b.getNumPages()).average();
		avgNumPages.ifPresent(p -> System.out.printf("%.2f", p));
		System.out.println("\r");

		OptionalDouble avg = averagePrice(library1);
		if (avg.isPresent()) {
			System.out.printf("%.2f", avg.getAsDouble());
		} else {
			System.out.printf("No books in list");
		}
		System.out.println("\r");

		OptionalDouble avgEmpty = averagePrice(new ArrayList<Book>());
		if (avgEmpty.isPresent()) {
			System.out.printf("%.2f", avgEmpty.getAsDouble());
		} else {
			System.out.printf("No books in list");
		}
		System.out.println("\r");

		Optional<List<Book>> foundBooks = getBooksInCategory(library1, Book.Category.TECHNICAL);
		if (foundBooks.isPresent()) {
			foundBooks.get().stream().forEach(System.out::println);
		} else {
			System.out.println("No books in list");
		}
		System.out.println("\r");

		Optional<List<Book>> foundNoBooks = getBooksInCategory(library1, Book.Category.COMIC);
		if (foundNoBooks.isPresent()) {
			foundNoBooks.get().stream().forEach(System.out::println);
		} else {
			System.out.println("No books in list");
		}
		System.out.println("\r");
	}

	private static OptionalDouble averagePrice(List<Book> books) {
		if (books.size() == 0) {
			return OptionalDouble.empty();
		}
		return books.stream().mapToDouble(b -> b.getPrice()).average();
	}

	private static Optional<List<Book>> getBooksInCategory(List<Book> books, Category c) {
		List<Book> found = books.stream().filter(b -> b.getCategory().equals(c)).collect(Collectors.toList());
		if (found.size() == 0) {
			return Optional.empty();
		}
		return Optional.ofNullable(found);
	}
}
