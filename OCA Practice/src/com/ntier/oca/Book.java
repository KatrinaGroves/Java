package com.ntier.oca;

class Book {

	static private int counter;

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counterIn) {
		counter = counterIn;
	}

	public Book() {
		System.out.println(++counter);
	}
}
