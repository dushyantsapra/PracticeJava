package com.javaSampleCode.concurrency;

public class Task implements Runnable {
	private int taskId;

	public Task() {
	}

	public Task(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.format("Task : %d is Completed\n", taskId);
	}

}
