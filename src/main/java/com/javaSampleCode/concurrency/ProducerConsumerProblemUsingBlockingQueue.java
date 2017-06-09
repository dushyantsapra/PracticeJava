package com.javaSampleCode.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerConsumerThreadForBlockingQueue implements Runnable {
	private String threadType;
	private BlockingQueue<String> blockingQueue;

	public ProducerConsumerThreadForBlockingQueue(String threadType, BlockingQueue<String> blockingQueue) {
		this.threadType = threadType;
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		int iCount = 0;
		try {
			for (int iLoop = 0; iLoop < 5; iLoop += 1) {
				if (ThreadType.valueOf(threadType) == ThreadType.PRODUCERTHREAD) {
					blockingQueue.put("P" + iCount);
					System.out.println(Thread.currentThread().getName() + " : Produced : " + "P" + iCount);
					iCount += 1;
				} else if (ThreadType.valueOf(threadType) == ThreadType.CONSUMERTHREAD) {
					String consumed = blockingQueue.take();
					System.out.println(Thread.currentThread().getName() + " : Consumed : " + consumed);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ProducerConsumerProblemUsingBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(5);

		new Thread(new ProducerConsumerThreadForBlockingQueue("PRODUCERTHREAD", blockingQueue)).start();
		new Thread(new ProducerConsumerThreadForBlockingQueue("CONSUMERTHREAD", blockingQueue)).start();
	}
}
