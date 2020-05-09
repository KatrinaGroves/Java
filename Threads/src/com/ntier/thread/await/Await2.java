package com.ntier.thread.await;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Await2 extends Thread {

	ReentrantLock lock;
	Condition blockB;
	
	public Await2(ReentrantLock lock, Condition block) {
		this.lock = lock;
		this.blockB = block;
	}
	
	public void run() {

		lock.lock();
		try {
			System.out.println("Waiting...");
			blockB.await();
			System.out.println("Lock released");
		} catch (InterruptedException ie) {
			System.out.println("Interrupted");
			ie.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				System.out.println("Locked");
			}
		}
	}

}
