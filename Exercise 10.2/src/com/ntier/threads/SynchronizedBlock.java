package com.ntier.threads;

class SynchronizedBlock extends Thread {

	StringBuffer letter;

	public void run() {
		System.out.println("not synchronized");
		synchronized (letter) {
			for (int i = 1; i <= 100; i++) {
				System.out.println(i + "\t" + letter);
			}
			char c = letter.charAt(0);
			++c;
			letter.setCharAt(0, c);
			System.out.println("synchronized");
			System.out.println("\r");
		}
	}

	SynchronizedBlock(StringBuffer letterIn) {
		letter = letterIn;
	}
}
