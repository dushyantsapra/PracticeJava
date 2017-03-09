package com.javaSampleCode.concurrency;

import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	@Override
	public void run() {
		try {
			startSignal.await();
			doWork();
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		} // return;
	}

	void doWork() {
		System.out.println(Thread.currentThread().getName() + " do Work");
	}
}

public class CountDownLatchSampleCode {
	static void doSomethingElse() {
		System.out.println(Thread.currentThread().getName() + " Do Something");
	}

	public static void main(String[] args) throws InterruptedException {
		int threadCount = 10;
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(threadCount);

		for (int i = 0; i < threadCount; ++i)
			new Thread(new Worker(startSignal, doneSignal)).start();

		doSomethingElse(); // don't let run yet
		startSignal.countDown(); // let all threads proceed
		doneSignal.await(); // wait for all to finish
		System.out.println(Thread.currentThread().getName() + " Work Done");
	}
}
