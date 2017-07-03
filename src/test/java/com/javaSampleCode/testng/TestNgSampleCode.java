package com.javaSampleCode.testng;

import org.testng.annotations.Test;

public class TestNgSampleCode extends UtilityBaseClass {
	@Test
	public void method1() {
		System.out.println("Method 1");
	}

	@Test
	public void method2() {
		System.out.println("Method 2");
	}

	@Test
	public void method3() {
		System.out.println("Method 3");
	}

	@Test(expectedExceptions = { IllegalArgumentException.class, NullPointerException.class })
	public void method4() {
		innerMethod();
	}

	private void innerMethod() throws IllegalArgumentException, NullPointerException {
		throw new IllegalArgumentException();
	}
}
