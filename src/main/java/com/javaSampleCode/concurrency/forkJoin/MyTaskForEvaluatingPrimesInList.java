package com.javaSampleCode.concurrency.forkJoin;

import java.util.List;
import java.util.concurrent.Callable;

public class MyTaskForEvaluatingPrimesInList implements Callable<Integer> {
	private final List<Integer> myList;
	private final int beginIndex;
	private final int endIndex;

	public MyTaskForEvaluatingPrimesInList(List<Integer> wholeList, int beginIndex, int endIndex) {
		this.myList = wholeList;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}

	@Override
	public Integer call() {
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