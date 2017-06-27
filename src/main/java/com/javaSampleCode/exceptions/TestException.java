package com.javaSampleCode.exceptions;

import java.io.IOException;

public class TestException {
	void testReturn() throws IOException, Exception {
		try {
			int i = 1 / 0;
		} finally {
			System.out.println("Hello");
			throw new IOException();
		}

	}

	public static void main(String[] args) {
		try {
			new TestException().testReturn();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
