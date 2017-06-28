package com.javaSampleCode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintNumberInRepeatProblemUsingLockAndConditionMonitor {
	private PrintNumberThreadType threadType;
	private Lock lock;
	private Condition conditionOne;
	private Condition conditionTwo;
	private Condition conditionThree;

	public PrintNumberInRepeatProblemUsingLockAndConditionMonitor(PrintNumberThreadType threadType) {
		this.threadType = threadType;
		lock = new ReentrantLock();

		conditionOne = lock.newCondition();
		conditionTwo = lock.newCondition();
		conditionThree = lock.newCondition();
	}

	public void printOne() {
		try {
			lock.lock();
			if (threadType != PrintNumberThreadType.ONE) {
				conditionOne.await();
			}
			System.out.println(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			threadType = PrintNumberThreadType.TWO;
			conditionTwo.signalAll();
			lock.unlock();
		}
	}

	public void printTwo() {
		try {
			lock.lock();
			if (threadType != PrintNumberThreadType.TWO) {
				conditionTwo.await();
			}
			System.out.println(2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			threadType = PrintNumberThreadType.THREE;
			conditionThree.signalAll();
			lock.unlock();
		}
	}

	public void printThree() {
		try {
			lock.lock();
			if (threadType != PrintNumberThreadType.THREE) {
				conditionThree.await();
			}
			System.out.println(3);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			threadType = PrintNumberThreadType.ONE;
			conditionOne.signalAll();
			lock.unlock();
		}
	}
}

class PrintNumberInRepeatProblemUsingLockAndConditionThread extends Thread {
	private PrintNumberThreadType threadType;
	private int loopCount;
	private PrintNumberInRepeatProblemUsingLockAndConditionMonitor monitor;

	public PrintNumberInRepeatProblemUsingLockAndConditionThread(PrintNumberThreadType threadType, int loopCount,
			PrintNumberInRepeatProblemUsingLockAndConditionMonitor monitor) {
		this.threadType = threadType;
		this.loopCount = loopCount;
		this.monitor = monitor;
	}

	@Override
	public void run() {
		switch (threadType) {
		case ONE:
			while (loopCount > 0) {
				monitor.printOne();
				loopCount -= 1;
			}
			break;
		case TWO:
			while (loopCount > 0) {
				monitor.printTwo();
				loopCount -= 1;
			}
			break;
		case THREE:
			while (loopCount > 0) {
				monitor.printThree();
				loopCount -= 1;
			}
			break;
		}
	}
}

public class PrintNumberInRepeatProblemUsingLockAndCondition {
	public static void main(String[] args) {
		PrintNumberInRepeatProblemUsingLockAndConditionMonitor monitor = new PrintNumberInRepeatProblemUsingLockAndConditionMonitor(
				PrintNumberThreadType.ONE);

		new Thread(new PrintNumberInRepeatProblemUsingLockAndConditionThread(PrintNumberThreadType.ONE, 5, monitor))
				.start();
		new Thread(new PrintNumberInRepeatProblemUsingLockAndConditionThread(PrintNumberThreadType.TWO, 5, monitor))
				.start();
		new Thread(new PrintNumberInRepeatProblemUsingLockAndConditionThread(PrintNumberThreadType.THREE, 5, monitor))
				.start();

	}
}
