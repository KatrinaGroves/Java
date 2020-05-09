package com.ntier.streams.starters;

import static com.ntier.streams.starters.Book.Category.FICTION;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTester {

	public static void main(String[] args) {
		Library lib1 = new Library("books1.txt");
		Library lib2 = new Library("books2.txt");
		List<Book> library1 = lib1.getBooks();
		List<Book> library2 = lib2.getBooks();

		String fictionBooks = library1.stream().filter(fb -> fb.getCategory().equals(FICTION)).map(Book::getTitle)
				.sorted().collect(Collectors.joining(", "));
		System.out.println("Fiction books: " + fictionBooks);
		System.out.println("\r");

		String booksByAuthor = library1.stream().map(Book::getAuthor).distinct().sorted()
				.collect(Collectors.joining(", "));
		System.out.println("Fiction books: " + booksByAuthor);
		System.out.println("\r");

		List<List<Book>> masterLibrary = Arrays.asList(library1, library2);
		List<Book> libraryDatabase = masterLibrary.stream().flatMap(ld -> ld.stream()).collect(Collectors.toList());
		libraryDatabase.forEach(System.out::println);
		System.out.println("\r");

		Stream.iterate(1000, n -> n - 50).limit(21).forEach(System.out::println);
		System.out.println("\r");

		Stream.iterate(1000, n -> n - 50).limit(10).forEach(System.out::println);
		System.out.println("\r");

		Stream.iterate('A', c -> (char) (c + 1)).limit(24).forEach(System.out::print);
		System.out.println("\r");

		Stream.iterate('A', c -> (char) (c + 1)).limit(58).forEach(s -> {
			if (s <= 'Z' || s >= 'a')
				System.out.print(s);
		});
		System.out.println("\r");
	}

}
