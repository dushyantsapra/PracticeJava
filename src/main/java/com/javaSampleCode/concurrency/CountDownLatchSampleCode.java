package com.javaSampleCode.concurrency;

import java.util.concurrent.CountDownLatch;

//Latches are for waiting for events; barriers are for waiting for other threads. - Java Concurrency in Practice

//CountDownLatch can be used while starting server, here it can prevent server to start listening to request 
//before all the specified service are up and running

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

	void doWork() throws InterruptedException {
		Thread.sleep(1000);
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

		for (int i = 1; i < threadCount + 1; ++i)
			new Thread(new Worker(latch), String.valueOf(i)).start();

		latch.await();
		doSomethingElse();
		System.out.println(Thread.currentThread().getName() + " Work Done");

		System.out.println("\n\n\n\n\n\n\n");
		for (int i = 1; i < threadCount + 1; ++i)
			new Thread(new Worker(latch), String.valueOf(i)).start();
		latch.await();
		System.out.println(":Adadasdasdsad:");

	}
}
