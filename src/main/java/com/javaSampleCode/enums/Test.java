package com.javaSampleCode.enums;

public class Test extends AbstractClassTest {
	@Override
	public void abc() {
		System.out.println("From Package Enums");
	}

	protected void def() {
		System.out.println("From Package Enums Method def");
	}

	public static void main(String[] args) {
		AbstractClassTest obj = new Test();
		obj.abc();
	}
}