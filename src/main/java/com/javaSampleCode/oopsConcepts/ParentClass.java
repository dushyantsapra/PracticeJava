package com.javaSampleCode.oopsConcepts;

public class ParentClass {
	private int id;
	private String name;

	public static int Id;

	{
		System.out.println("From Init Block");
	}

	static {
		Id = 20;
	}

	public ParentClass() {
		System.out.println("PC 1");
	}

	public ParentClass(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("PC 2");
	}

	public static void staticMethod() {
		System.out.println("From Parent Static Method");
	}

	public static void main(String[] args) {
		new ParentClass();
		new ParentClass(1, "Name");
	}
}