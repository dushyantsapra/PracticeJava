package com.javaSampleCode.enums;

import java.util.PriorityQueue;

class Book implements Comparable<Book> {
	private int id;

	public Book(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Book o) {
		if (this.id < o.id) {
			return -1;
		} else if (this.id == o.id) {
			return 0;
		} else {
			return 1;
		}
	}
}

public class Test {
	public static void main(String[] args) {
		PriorityQueue<Book> pq = new PriorityQueue<>(14);
	}
}