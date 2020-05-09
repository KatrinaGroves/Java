package com.ntier.thread.await;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Await extends Thread {

	ReentrantLock lock;
	Condition blockA;

	public void run() {

		lock.lock();
		try {
			System.out.println("Waiting...");
			blockA.await();
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

	public Await(ReentrantLock lock, Condition block) {
		this.lock = lock;
		this.blockA = block;
	}

}
