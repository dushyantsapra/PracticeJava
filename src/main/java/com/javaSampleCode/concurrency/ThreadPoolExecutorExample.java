package com.javaSampleCode.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * 
 * 1. We have 4 pre-defined policy(Nested Classes of ThreadPoolExecutor Class) of handling rejected task if blocking queue is full
 *	i) Abort Policy(AbortPolicy) : This throws RejectedExecutionException exception when a task is rejected and executor continue with other Tasks 
 *	ii) Caller Run Policy(CallerRunsPolicy) : This class runs the rejected task directly in the calling thread of the "execute" method of ThreadPoolExecutor
 *	iii) Discard Policy(DiscardPolicy) : A handler for rejected tasks that silently discards the rejected task so that other task continues.
 *	iv) Discard Oldest Policy(DiscardOldestPolicy) : This class favours newer tasks over older tasks, if the queue has reached its capacity by removing the Old tasks.
 *
 * 2. If we call get on Callable task's with DiscardOldestPolicy and DiscardPolicy classes, then program may hang as main thread will wait for the
 * 		result to be returned by get, but the problem will arise if a task has been removed. Check 
 * */

public class ThreadPoolExecutorExample {

	static void userDefinedRejectionHandler(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 100, TimeUnit.MILLISECONDS, blockingQueue, threadFactory, new RejectedExecutionHandlerImpl());
		for (int iLoop = 0; iLoop < Character.MAX_VALUE; iLoop++)
			executor.execute(new Task(iLoop + 1));

		executor.shutdown();
	}

	static void callerRunRejectionHandler(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 100, TimeUnit.MILLISECONDS, blockingQueue, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
		for (int iLoop = 0; iLoop < Character.MAX_VALUE; iLoop++)
			executor.execute(new Task(iLoop + 1));

		executor.shutdown();
	}

	static void abortPolicyRejectionHandler(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.MILLISECONDS, blockingQueue, threadFactory, new ThreadPoolExecutor.AbortPolicy());
		for (int iLoop = 0; iLoop < Character.MAX_VALUE; iLoop++)
			executor.execute(new Task(iLoop + 1));

		executor.shutdown();
	}

	static void customDiscardPolicyRejectionHandler(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.MILLISECONDS, blockingQueue, threadFactory, new DiscardPolicyExample());
		for (int iLoop = 0; iLoop < Character.MAX_VALUE; iLoop++)
			executor.execute(new Task(iLoop + 1));

		executor.shutdown();
	}

	static void discardPolicyRejectionHandler(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.MILLISECONDS, blockingQueue, threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
		for (int iLoop = 0; iLoop < Character.MAX_VALUE; iLoop++)
			executor.execute(new Task(iLoop + 1));

		executor.shutdown();
	}

	static void customDiscarOldestPolicyRejectionHandler(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) throws InterruptedException, ExecutionException {
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, blockingQueue, threadFactory, new DiscardOldestPolicyExample());

		for (int iLoop = 0; iLoop < 30; ++iLoop)
			futures.add(executor.submit(new TaskCallable(iLoop + 1)));

		for (Future<Integer> f : futures)
			try {
				System.out.println("Result: " + f.get());	
			} catch (Exception e) {
				System.out.println("Task Cancelled");
			}
		executor.shutdown();
	}

	static void discarOldestPolicyRejectionHandler(ThreadFactory threadFactory, BlockingQueue<Runnable> blockingQueue) {
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, blockingQueue, threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());

		for (int iLoop = 0; iLoop < 30; ++iLoop)
			futures.add(executor.submit(new TaskCallable(iLoop + 1)));

		for (Future<Integer> f : futures)
			try {
				System.out.println("Result: " + f.get());	
			} catch (Exception e) {
				System.out.println("Task Cancelled");
			}
		executor.shutdown();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>(10);
		
		customDiscarOldestPolicyRejectionHandler(threadFactory, new ArrayBlockingQueue<Runnable>(10));
//		discarOldestPolicyRejectionHandler(threadFactory, new ArrayBlockingQueue<Runnable>(10));

	}
}