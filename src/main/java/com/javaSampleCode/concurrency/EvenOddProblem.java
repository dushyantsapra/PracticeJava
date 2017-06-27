package com.javaSampleCode.concurrency;

class EvenOddMonitor {
	private EvenOddThreadType currentThreadType;

	public EvenOddMonitor(EvenOddThreadType currentThreadType) {
		super();
		this.currentThreadType = currentThreadType;
	}

	public synchronized void printEvenNumber(int num) {
		try {
			while (!(currentThreadType == EvenOddThreadType.EVEN))
				wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		currentThreadType = EvenOddThreadType.ODD;
		notifyAll();
	}

	public synchronized void printOddNumber(int num) {
		try {
			while (!(currentThreadType == EvenOddThreadType.ODD))
				wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		currentThreadType = EvenOddThreadType.EVEN;
		notifyAll();
	}

}

class EvenOddThread extends Thread {
	private EvenOddMonitor monitor;
	private EvenOddThreadType threadType;
	private int printCount;

	public EvenOddThread(EvenOddMonitor monitor, EvenOddThreadType threadType, int printCount) {
		super();
		this.monitor = monitor;
		this.threadType = threadType;
		this.printCount = printCount;
	}

	@Override
	public void run() {
		int iLoop = 0;
		switch (threadType) {
		case EVEN:
			iLoop = 2;
			while (iLoop <= printCount) {
				monitor.printEvenNumber(iLoop);
				iLoop += 2;
			}
			break;
		case ODD:
			iLoop = 1;
			while (iLoop <= printCount) {
				monitor.printOddNumber(iLoop);
				iLoop += 2;
			}
			break;
		}
	}
}

public class EvenOddProblem {
	public static void main(String[] args) {
		EvenOddMonitor monitor = new EvenOddMonitor(EvenOddThreadType.ODD);
		new Thread(new EvenOddThread(monitor, EvenOddThreadType.ODD, 14)).start();
		new Thread(new EvenOddThread(monitor, EvenOddThreadType.EVEN, 15)).start();
	}
}
