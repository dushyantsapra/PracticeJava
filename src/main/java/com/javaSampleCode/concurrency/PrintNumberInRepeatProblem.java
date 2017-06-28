package com.javaSampleCode.concurrency;

class PrintNumberMonitor {
	private PrintNumberThreadType currentThreadType;

	public PrintNumberMonitor(PrintNumberThreadType currentThreadType) {
		this.currentThreadType = currentThreadType;
	}

	public synchronized void printOne() {
		try {
			while (currentThreadType != PrintNumberThreadType.ONE) {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(1);
		currentThreadType = PrintNumberThreadType.TWO;
		notifyAll();
	}

	public synchronized void printTwo() {
		try {
			while (currentThreadType != PrintNumberThreadType.TWO) {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(2);
		currentThreadType = PrintNumberThreadType.THREE;
		notifyAll();
	}

	public synchronized void printThree() {
		try {
			while (currentThreadType != PrintNumberThreadType.THREE) {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(3);
		currentThreadType = PrintNumberThreadType.ONE;
		notifyAll();
	}
}

class PrintNumberThread extends Thread {
	private int loopCount;
	private PrintNumberThreadType printNumberThreadType;
	private PrintNumberMonitor monitor;

	public PrintNumberThread(int loopCount, PrintNumberThreadType printNumberThreadType, PrintNumberMonitor monitor) {
		this.loopCount = loopCount;
		this.printNumberThreadType = printNumberThreadType;
		this.monitor = monitor;
	}

	@Override
	public void run() {
		switch (printNumberThreadType) {
		case ONE:
			while (loopCount > 0) {
				monitor.printOne();
				loopCount--;
			}
			break;
		case TWO:
			while (loopCount > 0) {
				monitor.printTwo();
				loopCount--;
			}
			break;
		case THREE:
			while (loopCount > 0) {
				monitor.printThree();
				loopCount--;
			}
			break;
		}
	}
}

public class PrintNumberInRepeatProblem {
	public static void main(String[] args) {
		PrintNumberMonitor monitor = new PrintNumberMonitor(PrintNumberThreadType.ONE);
		new Thread(new PrintNumberThread(5, PrintNumberThreadType.ONE, monitor)).start();
		new Thread(new PrintNumberThread(5, PrintNumberThreadType.TWO, monitor)).start();
		new Thread(new PrintNumberThread(5, PrintNumberThreadType.THREE, monitor)).start();
	}
}
