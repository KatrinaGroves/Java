package com.ntier.shoes;

class Shoe {

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int sizeIn) {
		size = sizeIn;
	}

	double convertSizeToEuropean() {
		//pretend rule is times 5
		return size + 33;
	}
}
