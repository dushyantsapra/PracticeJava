package com.javaSampleCode.concurrency;

public class WorkerThread extends Thread {

	private boolean isWorking;
	private JavaUnBoundedBlockingQueue javaUnBoundedBlockingQueue;

	public WorkerThread() {
	}

	public WorkerThread(JavaUnBoundedBlockingQueue javaUnBoundedBlockingQueue) {
		isWorking = true;
		this.javaUnBoundedBlockingQueue = javaUnBoundedBlockingQueue;
	}

	@Override
	public void run() {
		while (isWorking()) {
			Runnable task = javaUnBoundedBlockingQueue.take();
			if (task != null)
				task.run();
		}
	}

	public synchronized void stopThread() {
		isWorking = false;
	}

	public synchronized boolean isWorking() {
		return isWorking;
	}

}
