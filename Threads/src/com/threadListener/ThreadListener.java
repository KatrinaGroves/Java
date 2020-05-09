package com.threadListener;

public class ThreadListener extends Thread {

	public ThreadListener(String name) {
		super(name);
	}

	@Override
	public void run() {
		boolean keepRunning = true;
		while (keepRunning) {
			for (Thread thread : Thread.getAllStackTraces().keySet()) {
				System.out.print("Thread: id-'" + thread.getId());
				System.out.print("' : name-'" + thread.getName());
				System.out.print("' : priority-'" + thread.getPriority());
				System.out.println("' : state =-'" + thread.getState() + "'");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
