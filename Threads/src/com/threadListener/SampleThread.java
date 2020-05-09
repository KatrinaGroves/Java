package com.threadListener;

public class SampleThread implements Runnable {

	@Override
	public void run() {
		int y = 0;
		for (int i = 0; i < 1_000_000; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
