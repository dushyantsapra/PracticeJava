package com.javaSampleCode.mockito;

public class MockingSampleClass {
	public boolean get() {
		return false;
	}

	public boolean getWithException() throws IllegalArgumentException {
		return false;
	}

	public Integer methodForAnswer(int i) {
		return 1;
	}
}
