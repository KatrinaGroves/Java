package com.ntier.library;

class Book {

	private String title;
	private String author;
	private int maxInventory;

	public String getTitle() {
		return title;
	}

	public void setTitle(String titleIn) {
		title = titleIn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String authorIn) {
		author = authorIn;
	}

	public int getMaxInventory() {
		return maxInventory;
	}

	public void setMaxInventory(int maxInventoryIn) {
		maxInventory = maxInventoryIn;
	}
}
