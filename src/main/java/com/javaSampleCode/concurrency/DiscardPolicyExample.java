package com.javaSampleCode.concurrency;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class DiscardPolicyExample implements RejectedExecutionHandler {

	public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
		if (r instanceof Future) {
			((Future<?>) r).cancel(false);
		}
	}
}
