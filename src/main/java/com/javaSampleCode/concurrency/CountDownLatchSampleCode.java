package com.javaSampleCode.concurrency;

import java.util.concurrent.CountDownLatch;

//Latches are for waiting for events; barriers are for waiting for other threads. - Java Concurrency in Practice

class Worker implements Runnable {
	private final CountDownLatch latch;

	Worker(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
		CountDownLatch latch = new CountDownLatch(threadCount);

		for (int i = 0; i < threadCount; ++i)
			new Thread(new Worker(latch)).start();

		latch.await();
		doSomethingElse();
		System.out.println(Thread.currentThread().getName() + " Work Done");
	}
}
