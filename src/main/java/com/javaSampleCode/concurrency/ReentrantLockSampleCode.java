package com.javaSampleCode.concurrency;

public class ReentrantLockSampleCode {
	private volatile boolean isLocked;
	private volatile int lockCount;
	private volatile Thread lockingThread;

	public ReentrantLockSampleCode() {
		isLocked = false;
		lockCount = 0;
	}

	public synchronized void lock() {
		try {
			while (isLocked && (lockingThread != Thread.currentThread()))
				wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
		lockCount++;
		lockingThread = Thread.currentThread();
		isLocked = true;
	}

	public synchronized void unLock() {
		if (Thread.currentThread() == this.lockingThread) {
			lockCount--;
		}

		if (lockCount == 0) {
			isLocked = false;
			lockingThread = null;
			notifyAll();
		}
	}
}
