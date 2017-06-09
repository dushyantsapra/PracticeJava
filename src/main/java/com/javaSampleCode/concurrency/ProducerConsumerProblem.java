package com.javaSampleCode.concurrency;

enum ThreadType {
	PRODUCERTHREAD, CONSUMERTHREAD;
}

class Monitor {
	private int maxValue;
	private int currentValue;

	public Monitor(int maxValue) {
		this.maxValue = maxValue;
		currentValue = 0;
	}

	public synchronized void inc() {
		System.out.println(Thread.currentThread().getName() + " : Got Lock");
		try {
			if (currentValue > maxValue) {
				System.out.println(Thread.currentThread().getName() + " : Waiting");
				wait();
			}
			System.out.println(Thread.currentThread().getName() + " : Incrementing");
			currentValue += 1;
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName());
			e.printStackTrace();
		} finally {
			notifyAll();
			System.out.println(Thread.currentThread().getName() + " : Released Lock");
		}
	}

	public synchronized void dec() {
		System.out.println(Thread.currentThread().getName() + " : Got Lock");
		try {
			if (currentValue < 0) {
				System.out.println(Thread.currentThread().getName() + " : Waiting");
				wait();
			}
			System.out.println(Thread.currentThread().getName() + " : decrementing");
			currentValue -= 1;
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName());
			e.printStackTrace();
		} finally {
			notifyAll();
			System.out.println(Thread.currentThread().getName() + " : Released Lock");
		}
	}
}

class ProducerConsumerThread implements Runnable {
	private Monitor monitor;
	private String threadType;
	private int loopCount;

	public ProducerConsumerThread(Monitor monitor, String threadType, int loopCount) {
		this.monitor = monitor;
		this.threadType = threadType;
		this.loopCount = loopCount;
	}

	@Override
	public void run() {
		for (int iLoop = 0; iLoop < loopCount; iLoop += 1) {
			if (ThreadType.valueOf(threadType) == ThreadType.PRODUCERTHREAD) {
				monitor.inc();
			} else if (ThreadType.valueOf(threadType) == ThreadType.CONSUMERTHREAD) {
				monitor.dec();
			}
		}
	}
}

public class ProducerConsumerProblem {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread Started");
		Monitor monitor = new Monitor(5);
		new Thread(new ProducerConsumerThread(monitor, "PRODUCERTHREAD", 5)).start();
		new Thread(new ProducerConsumerThread(monitor, "CONSUMERTHREAD", 5)).start();
	}

}