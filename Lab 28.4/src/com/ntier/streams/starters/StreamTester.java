package com.ntier.streams.starters;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ntier.streams.starters.Book.Category;

public class StreamTester {

	public static void main(String[] args) {
		Library lib1 = new Library("books1.txt");
		List<Book> library1 = lib1.getBooks();

		Map<Book.Category, List<Book>> booksByCategoryLambda = library1.stream()
				.collect(Collectors.groupingBy(bl -> bl.getCategory()));
		for (Entry<Book.Category, List<Book>> book : booksByCategoryLambda.entrySet()) {
			System.out.println("Category: " + book.getKey());
			for (Book b : book.getValue()) {
				System.out.println("\t" + b);
			}
		}
		System.out.println("\r");

		Map<Book.Category, List<Book>> booksByCategoryMethod = library1.stream()
				.collect(Collectors.groupingBy(Book::getCategory));
		for (Entry<Book.Category, List<Book>> book : booksByCategoryMethod.entrySet()) {
			System.out.println("Category: " + book.getKey());
			for (Book b : book.getValue()) {
				System.out.println("\t" + b);
			}
		}
		System.out.println("\r");

		Map<Category, Long> booksByCategoryCount = library1.stream()
				.collect(Collectors.groupingBy(Book::getCategory, Collectors.counting()));
		for (Entry<Category, Long> book : booksByCategoryCount.entrySet()) {
			System.out.println("There are " + book.getValue() + " books in the " + book.getKey() + " category");
		}
		System.out.println("\r");

		Map<Category, List<String>> booksByCategoryTitle = library1.stream().collect(
				Collectors.groupingBy(Book::getCategory, Collectors.mapping(Book::getTitle, Collectors.toList())));
		for (Entry<Category, List<String>> book : booksByCategoryTitle.entrySet()) {
			for (String b : book.getValue()) {
				System.out.println("Title: " + b);
			}
		}
		System.out.println("\r");

		Map<String, List<Book>> booksByAuthor = library1.stream().collect(Collectors.groupingBy(Book::getAuthor));
		for (Entry<String, List<Book>> book : booksByAuthor.entrySet()) {
			System.out.println("Author: " + book.getKey());
		}
		System.out.println("\r");

		Map<Boolean, List<Book>> bookPartition = library1.stream()
				.collect(Collectors.partitioningBy(bp -> bp.getPrice() < 20));
		for (Entry<Boolean, List<Book>> book : bookPartition.entrySet()) {
			System.out.println("Books under $20: " + book.getKey());
			for (Book b : book.getValue()) {
				System.out.println("\t" + b);
			}
		}
		System.out.println("\r");

		Map<Category, Double> booksGroupedByAverageLambda = library1.stream()
				.collect(Collectors.groupingBy(Book::getCategory, Collectors.averagingDouble(bal -> bal.getPrice())));
		for (Entry<Category, Double> book : booksGroupedByAverageLambda.entrySet()) {
			System.out.println("The average price for a " + book.getKey() + " book is $"
					+ (String.format("%.2f", book.getValue())));
		}
		System.out.println("\r");

		Map<Category, Double> booksGroupedByAverage = library1.stream()
				.collect(Collectors.groupingBy(Book::getCategory, Collectors.averagingDouble(Book::getPrice)));
		for (Entry<Category, Double> book : booksGroupedByAverage.entrySet()) {
			System.out.println("The average price for a " + book.getKey() + " book is $"
					+ (String.format("%.2f", book.getValue())));
		}
		System.out.println("\r");

		System.out.println(highestPrice(library1));
	}

	private static Optional<Book> highestPrice(List<Book> books) {
		Optional<Book> b = books.stream()
				.collect(Collectors.maxBy((i, y) -> Double.compare(i.getPrice(), y.getPrice())));
		return b;
	}
}
