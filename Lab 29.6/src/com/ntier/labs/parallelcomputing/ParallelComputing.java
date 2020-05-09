package com.ntier.labs.parallelcomputing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

class ParallelComputing extends RecursiveAction {

	private static final int THRESHOLD = 1000;
	private int[] numbers;
	private int start;
	private int end;

	public static void main(String[] args) {
		int[] numbers = new int[5_000_000];
		ForkJoinPool fj = new ForkJoinPool();
		ParallelComputing action = new ParallelComputing(numbers, 0, numbers.length);
		fj.invoke(action);
	}

	@Override
	protected void compute() {
		if (end - start <= THRESHOLD) {
			for (int i = start; i < end; i++) {
				int nextIntValue = ThreadLocalRandom.current().nextInt();
				numbers[i] = nextIntValue;
				System.out.println(Thread.currentThread().getName() + "-" + nextIntValue);
			}
		} else {
			int halfWay = ((end - start) / 2) + start;
			ParallelComputing a1 = new ParallelComputing(numbers, start, halfWay);
			a1.fork();
			ParallelComputing a2 = new ParallelComputing(numbers, halfWay, end);
			a2.compute();
			a1.join();
		}
	}

	ParallelComputing(int[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}
}
