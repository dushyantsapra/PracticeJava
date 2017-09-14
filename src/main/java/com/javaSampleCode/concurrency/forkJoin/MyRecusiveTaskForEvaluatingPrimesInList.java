package com.javaSampleCode.concurrency.forkJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecusiveTaskForEvaluatingPrimesInList extends RecursiveTask<Integer> {
	private static final long serialVersionUID = -505815667114796749L;
	private List<Integer> myList;
	private int beginIndex;
	private int endIndex;

	private static final int THRESHOLD_TO_TRIGGER_PARALLEL_WORK = 10000;

	public MyRecusiveTaskForEvaluatingPrimesInList(List<Integer> list, int beginIndex, int endIndex) {
		this.myList = list;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	@Override
	protected Integer compute() {
		if ((endIndex - beginIndex) > THRESHOLD_TO_TRIGGER_PARALLEL_WORK) {
			List<RecursiveTask<Integer>> subTaskList = createTaskList();
			invokeAll(subTaskList);
			int countOfPrimes = 0;
			for (RecursiveTask<Integer> task : subTaskList) {
				countOfPrimes += task.join();
			}
			return countOfPrimes;
		} else {
			return evaluateListDirectly();
		}
	}

	private List<RecursiveTask<Integer>> createTaskList() {
		List<RecursiveTask<Integer>> subTaskList = new ArrayList<>();
		int midSplitIndex = beginIndex + ((endIndex - beginIndex) / 2);
		subTaskList.add(new MyRecusiveTaskForEvaluatingPrimesInList(myList, beginIndex, midSplitIndex));
		subTaskList.add(new MyRecusiveTaskForEvaluatingPrimesInList(myList, midSplitIndex + 1, endIndex));
		return subTaskList;
	}

	private int evaluateListDirectly() {
		int countOfPrimes = 0;
		for (int i = beginIndex; i < endIndex; i++) {
			if (isNumberPrime(myList.get(i))) {
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
}
