package com.ntier.oca;

class Statics {

	int num;

	public static void main(String[] args) {
		System.out.println("counter prints when each new book instance is created");
		new Book();
		new Book();
		new Book();

//		static method can't access non-static variable
//		System.out.println(num);

		System.out.println("\raccessing the getter method in a static way");
		System.out.println(Book.getCounter());

		System.out.println("\raccessing the getter in a non-static way results in a warning");
		System.out.print("the constructor call: ");
		Book b = new Book();
		System.out.println("the method call: " + b.getCounter());

//		accessing getter in a non-static way in an interface results in compiler error
//		Reader r = new Reader();
//		System.out.println(r.read());

		System.out.println("\rinterface must be accessed in static way");
		Reader.read();
	}
}
