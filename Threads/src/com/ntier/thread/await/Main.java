package com.ntier.thread.await;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Main {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock();
		Condition block = lock.newCondition();
		
		Await a = new Await(lock, block);
		Await2 b = new Await2(lock, block);
		
		a.start();
		Thread.sleep(2000);
		b.start();
	}

}
