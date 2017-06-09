package com.javaSampleCode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MonitorForLockAndCondition {
	private int maxValue;
	private int currentValue;
	private Lock lock;

	private Condition producerCondition;
	private Condition consumerCondition;

	public MonitorForLockAndCondition(int maxValue) {
		this.maxValue = maxValue;
		currentValue = 0;

		lock = new ReentrantLock();
		producerCondition = lock.newCondition();
		consumerCondition = lock.newCondition();
	}

	public void inc() {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + " : Got Lock");
		try {
			if (currentValue > maxValue) {
				System.out.println(Thread.currentThread().getName() + " : Waiting");
				producerCondition.await();
			}
			System.out.println(Thread.currentThread().getName() + " : Incrementing");
			currentValue += 1;
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName());
			e.printStackTrace();
		} finally {
			lock.unlock();
			consumerCondition.signalAll();
			System.out.println(Thread.currentThread().getName() + " : Released Lock");
		}
	}

	public void dec() {
		lock.lock();
		System.out.println(Thread.currentThread().getName() + " : Got Lock");
		try {
			if (currentValue < 0) {
				System.out.println(Thread.currentThread().getName() + " : Waiting");
				consumerCondition.await();
			}
			System.out.println(Thread.currentThread().getName() + " : decrementing");
			currentValue -= 1;
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName());
			e.printStackTrace();
		} finally {
			lock.unlock();
			producerCondition.signalAll();
			System.out.println(Thread.currentThread().getName() + " : Released Lock");
		}
	}
}

class ProducerConsumerThreadForLockAndCondition implements Runnable {
	private Monitor monitor;
	private String threadType;
	private int loopCount;

	public ProducerConsumerThreadForLockAndCondition(Monitor monitor, String threadType, int loopCount) {
		this.monitor = monitor;
		this.threadType = threadType;
		this.loopCount = loopCount;
	}

	@Override
	public void run() {
		for (int iLoop = 0; iLoop < loopCount; iLoop += 1) {
			if (ThreadType.valueOf(threadType) == ThreadType.PRODUCERTHREAD) {
				monitor.inc();
			} else if (ThreadType.valueOf(threadType) == ThreadType.CONSUMERTHREAD) {
				monitor.dec();
			}
		}
	}
}

public class ProducerConsumerProblemUsingLockAndCondition {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread Started");
		Monitor monitor = new Monitor(5);
		new Thread(new ProducerConsumerThread(monitor, "PRODUCERTHREAD", 5)).start();
		new Thread(new ProducerConsumerThread(monitor, "CONSUMERTHREAD", 5)).start();
	}
}
