package com.javaSampleCode.concurrency.forkJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ParallelismWithForkJoin {
	private static final Logger myLogger = Logger.getLogger(NoParallelism.class.getName());
	private static final int MAX_LOAD = Integer.MAX_VALUE / 100;

	public ParallelismWithForkJoin() {
	}

	public void doWork() {
		List<Integer> listToBeProcessed = getRandomIntegers();
		long _startclk = System.nanoTime();
		int countOfPrimes = findPrimeNumbersFromList(listToBeProcessed);
		long _elapsedclk = System.nanoTime() - _startclk;
		myLogger.info("Number of primes: " + countOfPrimes + ". Elapsed time (millisec): "
				+ TimeUnit.MILLISECONDS.convert(_elapsedclk, TimeUnit.NANOSECONDS));
	}

	private int findPrimeNumbersFromList(List<Integer> listToBeProcessed) {
		int lengthOfListToBeProcessed = listToBeProcessed.size();
		myLogger.info("Length of list to be processed: " + listToBeProcessed.size());
		int numberOfLogicalProcessors = Runtime.getRuntime().availableProcessors();
		int optimizedProcessorCount = (int) (numberOfLogicalProcessors * 0.8);
		myLogger.info("Number of logical processors: " + numberOfLogicalProcessors + " Optimum processor count: "
				+ optimizedProcessorCount);
		ForkJoinPool forkJoinPool = new ForkJoinPool(optimizedProcessorCount);
		ForkJoinTask<Integer> task = forkJoinPool
				.submit(new MyRecusiveTaskForEvaluatingPrimesInList(listToBeProcessed, 0, lengthOfListToBeProcessed));
		int sum = task.join();
		myLogger.info("Steal count: " + forkJoinPool.getStealCount());
		forkJoinPool.shutdown();
		return sum;
	}

	private List<Integer> getRandomIntegers() {
		Random random = new Random();
		// int listSize = random.nextInt(MAX_LOAD);
		int listSize = MAX_LOAD;
		List<Integer> list = new ArrayList<>(5);
		for (int i = 0; i < listSize; i++) {
			int nextInt = random.nextInt();
			list.add(nextInt < 0 ? -nextInt : nextInt);
		}
		return Collections.unmodifiableList(list);
	}

	public static void main(String[] args) {
		ParallelismWithForkJoin forkJoinParallel = new ParallelismWithForkJoin();
		forkJoinParallel.doWork();
	}
}
