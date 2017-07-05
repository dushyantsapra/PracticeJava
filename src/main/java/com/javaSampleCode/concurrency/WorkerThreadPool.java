package com.javaSampleCode.concurrency;

import java.util.ArrayList;
import java.util.List;

public class WorkerThreadPool {
	public static void main(String[] args) {
		List<WorkerThread> workerThreads = new ArrayList<WorkerThread>();
		JavaUnBoundedBlockingQueue javaUnBoundedBlockingQueue = new JavaUnBoundedBlockingQueue();

		for (int iLoop = 1; iLoop <= 30; iLoop++) {
			javaUnBoundedBlockingQueue.put(new Task(iLoop));
		}
		
		for (int iLoop = 0; iLoop < 5; iLoop++) {
			workerThreads.add(new WorkerThread(javaUnBoundedBlockingQueue));
		}

		int count = 1;
		for (WorkerThread workerThread : workerThreads) {
			workerThread.setName("Thread_" + count);
			workerThread.start();
			count++;
		}

		
	}
}
