package com.threadListener;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		ThreadListener listener = new ThreadListener("ThreadListener");
		listener.start();

		Runnable longLoop = new SampleThread();
		Thread t1 = new Thread(longLoop, "First Thread");
		Thread t2 = new Thread(longLoop, "Second Thread");
		Thread t3 = new Thread(longLoop, "Third Thread");

		t1.start();
		Thread.sleep(5000);
		t2.start();
		Thread.sleep(5000);
		t3.start();
		Thread.sleep(5000);

		t2.interrupt();
		Thread.sleep(5000);
		t2.interrupt();
		Thread.sleep(5000);

		t2.start();
		Thread.sleep(5000);

		t3.notify();
		Thread.sleep(5000);

		System.out.println("End of main thread");

	}

}
