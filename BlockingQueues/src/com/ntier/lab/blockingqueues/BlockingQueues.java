package com.ntier.lab.blockingqueues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class BlockingQueues implements Runnable {

	private static ArrayBlockingQueue<Integer> array1 = new ArrayBlockingQueue<>(500);
	private static ArrayBlockingQueue<Integer> array2 = new ArrayBlockingQueue<>(500);
	private static ArrayBlockingQueue<Integer> array3 = new ArrayBlockingQueue<>(500);
	static CyclicBarrier barrier;
	String[] processSet;
	
	public static void main(String[] args) throws InterruptedException {
		processor(array1Numbers());
		processor(array2Numbers());
		processor(array3Numbers());
	}

	static ArrayBlockingQueue<Integer> array1Numbers() throws InterruptedException {
		System.out.println("Array 1");
		for (int i = 0; i < 500; i++) {
			array1.put(ThreadLocalRandom.current().nextInt(500));
		}
		array1.forEach(System.out::println);
		System.out.println("\r");
		return array1;
	}
	
	static ArrayBlockingQueue<Integer> array2Numbers() throws InterruptedException {
		System.out.println("Array 2");
		for (int i = 0; i < 500; i++) {
			array2.put(ThreadLocalRandom.current().nextInt(500));
		}
		array2.forEach(System.out::println);
		System.out.println("\r");
		return array2;
	}
	
	static ArrayBlockingQueue<Integer> array3Numbers() throws InterruptedException {
		System.out.println("Array 3");
		for (int i = 0; i < 500; i++) {
			array3.put(ThreadLocalRandom.current().nextInt(500));
		}
		array3.forEach(System.out::println);
		System.out.println("\r");
		return array3;
	}
	
	static void processor(ArrayBlockingQueue<Integer> array) {
		barrier = new CyclicBarrier(500,() ->  {
			System.out.println();
		});
	}

	@Override
	public void run() {
		
	}
}