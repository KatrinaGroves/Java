package com.ntier.threads;

class SynchronizedMain {

	public static void main(String[] args) {
		StringBuffer letter = new StringBuffer("A");
		SynchronizedBlock sb1 = new SynchronizedBlock(letter);
		SynchronizedBlock sb2 = new SynchronizedBlock(letter);
		SynchronizedBlock sb3 = new SynchronizedBlock(letter);
	
		sb1.start();
		sb2.start();
		sb3.start();
	}
}
