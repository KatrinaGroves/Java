package com.ntier.thread;

class ThreadyBoi extends Thread {

	public void run() {
		while (true) {
			if (isInterrupted()) {
				break;
			}
			System.out.println("working");

			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
				System.out.println("I was sleeping when interrupted");
				break;
			}
		}
		System.out.println("cleanup");
	}
}
