package com.javaSampleCode.concurrency.forkJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ParallelismWithBareExectorService {
	private static final Logger myLogger = Logger.getLogger(NoParallelism.class.getName());
	private static final int THRESHOLD_TO_TRIGGER_PARALLEL_WORK = 10000;
	private static final int MAX_LOAD = Integer.MAX_VALUE / 100;

	public ParallelismWithBareExectorService() {
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
		ExecutorService service = null;
		List<Future<Integer>> sumFromIndividualThreads = new ArrayList<>();
		if (lengthOfListToBeProcessed > THRESHOLD_TO_TRIGGER_PARALLEL_WORK) {
			int numberOfLogicalProcessors = Runtime.getRuntime().availableProcessors();
			myLogger.info("Number of logical processors: " + numberOfLogicalProcessors);
			int optimizedProcessorCount = (int) (numberOfLogicalProcessors * 0.8);
			myLogger.info("Number of logical processors: " + numberOfLogicalProcessors + " Optimum processor count: "
					+ optimizedProcessorCount);
			service = Executors.newFixedThreadPool(optimizedProcessorCount);
			int sliceLength = lengthOfListToBeProcessed / numberOfLogicalProcessors;
			int index = 0;
			do {
				int newIndex = index + sliceLength;
				if (newIndex <= lengthOfListToBeProcessed) {
					sumFromIndividualThreads.add(
							service.submit(new MyTaskForEvaluatingPrimesInList(listToBeProcessed, index, newIndex)));
					index = newIndex;
				} else {
					sumFromIndividualThreads.add(service.submit(
							new MyTaskForEvaluatingPrimesInList(listToBeProcessed, index, lengthOfListToBeProcessed)));
					break;
				}
			} while (index < lengthOfListToBeProcessed);
		} else {
			myLogger.info("Processing all in one thread");
			service = Executors.newFixedThreadPool(1);
			sumFromIndividualThreads.add(service
					.submit(new MyTaskForEvaluatingPrimesInList(listToBeProcessed, 0, lengthOfListToBeProcessed)));
		}
		int sum = 0;
		if (service != null) {
			service.shutdown();
			try {
				service.awaitTermination(10, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
			}

			for (Future<Integer> taskResult : sumFromIndividualThreads) {
				try {
					sum += taskResult.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
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
		ParallelismWithBareExectorService bareParallel = new ParallelismWithBareExectorService();
		bareParallel.doWork();
	}
}
