package com.favoritefilms;

import java.util.Scanner;
/**
 * 
 * @author Katrina Groves
 *
 */
//TODO write unit test
class JavaView {
	
	static FilmController fc = new FilmController();

	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome! Would you like to view films?");
		System.out.println("Enter YES or NO");
		outer: while (true) {
			String line = scan.next();
			if (line.equalsIgnoreCase("yes")) {
				System.out.println("Would you like to sort by rating or search by genre?");
				System.out.println("Enter SORT to sort by rating or SEARCH to search by genre");
				System.out.println("Enter NO to view films without sorting or DONE to exit the program");
				inner: while (scan.hasNext()) {
					if ((line = scan.next()).equalsIgnoreCase("sort")) {
						fc.sortByRating();
					} else if (line.equalsIgnoreCase("search")) {
						System.out.println("Input genre:");
						line = scan.next();
						fc.searchByGenre(line);
					} else if (line.equalsIgnoreCase("no")) {
						fc.printFilmList();
					} else if (line.equalsIgnoreCase("done")) {
						System.out.println("Goodbye");
						System.exit(0);
					} else {
						System.out.println("Invalid Input: Would you like to sort by rating or search by genre?");
						continue inner;
					}
				}
			} else if (line.equalsIgnoreCase("no")) {
				System.out.println("Goodbye");
				System.exit(0);
			} else {
				System.out.println("Invalid Input: Would you like to view films?");
				continue outer;
			}
			scan.close();
		}
	}
}
