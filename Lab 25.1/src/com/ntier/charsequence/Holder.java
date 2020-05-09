package com.ntier.charsequence;

class Holder<T extends CharSequence> {

	private T cs;

	T getCs() {
		return cs;
	}

	public void setCs(T csIn) {
		cs = csIn;
	}

	int length() {
		return cs.length();
	}

	public Holder(T csIn) {
		cs = csIn;
	}

	CharSequence subSequence(int start, int end) {
		return cs.subSequence(start, end);
	}

	public String toString() {
		return "" + this.cs;
	}
}
