package com.javaSampleCode.concurrency.forkJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class NoParallelism {
	private static final Logger myLogger = Logger.getLogger(NoParallelism.class.getName());
	private static final int MAX_LOAD = Integer.MAX_VALUE / 100;

	public NoParallelism() {
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
		myLogger.info("Length of list to be processed: " + listToBeProcessed.size());
		int countOfPrimes = 0;
		for (Integer number : listToBeProcessed) {
			if (isNumberPrime(number)) {
				countOfPrimes++;
			}
		}
		return countOfPrimes;
	}

	private boolean isNumberPrime(Integer number) {
		if (number < 2) {
			return false;
		}
		if (number == 2 || number == 3) {
			return true;
		}
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		long squareRootNumber = (long) Math.sqrt(number) + 1;
		for (long i = 6L; i <= squareRootNumber; i += 6) {
			if (number % (i - 1) == 0 || number % (i + 1) == 0) {
				return false;
			}
		}
		return true;
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
		NoParallelism noParallel = new NoParallelism();
		noParallel.doWork();
	}
}