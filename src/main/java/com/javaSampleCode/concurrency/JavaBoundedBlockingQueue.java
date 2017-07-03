package com.javaSampleCode.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaBoundedBlockingQueue {

	private List<String> list = null;
	private int length;
	private MyLock lock = null;

	public JavaBoundedBlockingQueue() {
		list = new LinkedList<String>();
		lock = new MyLock();
	}

	public JavaBoundedBlockingQueue(int size) {
		list = new ArrayList<String>(size);
		lock = new MyLock();
		length = 0;
	}

	public boolean put(String str) {
		lock.lock();
		boolean isAdded = true;
		if (length < list.size()) {
			System.out.format("Thread %s added : %s", str);
			list.add(str);
		} else {
			isAdded = false;
		}
		lock.unlock();
		return isAdded;
	}

	public String take() {
		String value = null;
		lock.lock();

		if (length != 0) {
			System.out.format("Thread %s removed : %s", list.get(list.size() - 1));
			value = list.remove(list.size() - 1);
		}
		lock.unlock();
		return value;
	}
}
