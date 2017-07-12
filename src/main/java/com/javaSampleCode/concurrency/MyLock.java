package com.javaSampleCode.concurrency;

public class MyLock {
	private volatile boolean isLocked;

	public MyLock() {
		isLocked = false;
	}

	public synchronized void lock() {
		try {
			while (isLocked) {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.format("Thread : %s Aquired Lock \n", Thread.currentThread().getName());
		isLocked = true;
	}

	public synchronized void unlock() {
		System.out.format("Thread : %s Released Lock \n", Thread.currentThread().getName());
		isLocked = false;
		notifyAll();
	}
}
