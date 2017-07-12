package com.javaSampleCode.concurrency;

class Thread1 implements Runnable {
	private String str1;
	private String str2;

	public Thread1(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	public void run() {
		try {
			abc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void abc() throws InterruptedException {
		synchronized (str1) {
			System.out.println(Thread.currentThread().getName() + ": Got First Lock");
			Thread.sleep(1000);
			synchronized (str2) {
				System.out.println(Thread.currentThread().getName() + ": Got Second Lock");
			}
			System.out.println(Thread.currentThread().getName() + ": Released Second Lock");
		}
		System.out.println(Thread.currentThread().getName() + ": Released First Lock");
	}
}

class Thread2 implements Runnable {
	private String str1;
	private String str2;

	public Thread2(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
	}

	public void run() {
		try {
			abc();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void abc() throws InterruptedException {
		synchronized (str2) {
			System.out.println(Thread.currentThread().getName() + ": Got Second Lock");
			synchronized (str1) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + ": Got First Lock");
			}
			System.out.println(Thread.currentThread().getName() + ": Released First Lock");
		}
		System.out.println(Thread.currentThread().getName() + ": Released Second Lock");
	}
}

public class CreateDeadLockSampleCode {
	public static void main(String[] args) {
		String str1 = "str1";
		String str2 = "str2";

		new Thread(new Thread1(str1, str2)).start();
		new Thread(new Thread2(str1, str2)).start();
	}
}
