package com.javaSampleCode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class EvenOddProblemUsingLockAndConditionMonitor {
	private EvenOddThreadType threadType;
	private Lock lock;
	private Condition evenCondition;
	private Condition oddCondition;

	public EvenOddProblemUsingLockAndConditionMonitor(EvenOddThreadType threadType) {
		this.threadType = threadType;
		lock = new ReentrantLock();
		evenCondition = lock.newCondition();
		oddCondition = lock.newCondition();
	}

	public void printEven(int num) {
		lock.lock();
		try {
			while (threadType != EvenOddThreadType.EVEN)
				evenCondition.await();
			System.out.println(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			oddCondition.signalAll();
		}
	}

	public void printOdd(int num) {
		lock.lock();
		try {
			while (threadType != EvenOddThreadType.ODD)
				oddCondition.await();
			System.out.println(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			evenCondition.signalAll();
		}
	}
}

class EvenOddProblemUsingLockAndConditionMonitorThread extends Thread {
	private int maxValue;
	private EvenOddThreadType threadType;
	private EvenOddProblemUsingLockAndConditionMonitor monitor;

	public EvenOddProblemUsingLockAndConditionMonitorThread(int maxValue, EvenOddThreadType threadType,
			EvenOddProblemUsingLockAndConditionMonitor monitor) {
		this.maxValue = maxValue;
		this.threadType = threadType;
		this.monitor = monitor;
	}

	@Override
	public void run() {
		int iLoop = 0;
		switch (threadType) {
		case EVEN:
			iLoop = 2;
			while (iLoop <= maxValue) {
				monitor.printEven(iLoop);
				iLoop += 2;
			}
			break;
		case ODD:
			iLoop = 1;
			while (iLoop <= maxValue) {
				monitor.printOdd(iLoop);
				iLoop += 2;
			}
			break;
		}
	}
}

public class EvenOddProblemUsingLockAndCondition {
	public static void main(String[] args) {
		EvenOddProblemUsingLockAndConditionMonitor monitor = new EvenOddProblemUsingLockAndConditionMonitor(
				EvenOddThreadType.ODD);
		new Thread(new EvenOddProblemUsingLockAndConditionMonitorThread(14, EvenOddThreadType.ODD, monitor)).start();
		new Thread(new EvenOddProblemUsingLockAndConditionMonitorThread(14, EvenOddThreadType.EVEN, monitor)).start();
	}
}
