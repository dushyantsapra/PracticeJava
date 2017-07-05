package com.javaSampleCode.concurrency;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class DiscardOldestPolicyExample implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
		if (!e.isShutdown()) {
			Runnable rejected = e.getQueue().poll();
			if (rejected instanceof Future) {
				((Future<?>) rejected).cancel(false);
			}
			e.execute(r);
		}
	}
}
