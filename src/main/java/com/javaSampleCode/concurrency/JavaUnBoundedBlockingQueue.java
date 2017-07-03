package com.javaSampleCode.concurrency;

import java.util.LinkedList;
import java.util.List;

public class JavaUnBoundedBlockingQueue {
	private List<Runnable> list = null;
	private MyLock lock = null;

	public JavaUnBoundedBlockingQueue() {
		list = new LinkedList<Runnable>();
		lock = new MyLock();
	}

	public void put(Runnable task) {
		lock.lock();

		System.out.format("Thread : %s added, Current Size is : %d\n", Thread.currentThread().getName(), list.size());
		list.add(task);

		lock.unlock();
	}

	public Runnable take() {
		Runnable value = null;
		lock.lock();

		System.out.format("Thread : %s removed, Current Size is : %d\n", Thread.currentThread().getName(), list.size());
		value = list.remove(list.size() - 1);
		lock.unlock();
		return value;
	}
}
