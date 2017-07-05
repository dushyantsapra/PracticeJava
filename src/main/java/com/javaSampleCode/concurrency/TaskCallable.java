package com.javaSampleCode.concurrency;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Integer> {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TaskCallable() {

	}

	public TaskCallable(int id) {
		this.id = id;
	}

	@Override
	public Integer call() {
		System.out.println("Running task " + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// ignore
		}
		System.out.println("Task " + id + " ends");
		return id;
	}
}
