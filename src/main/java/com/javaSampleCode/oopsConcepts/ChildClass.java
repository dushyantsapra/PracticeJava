package com.javaSampleCode.oopsConcepts;

public class ChildClass extends ParentClass {
	private int id;
	public static int Id;
	
	{
		id = -1;
		System.out.println("From Child Init Block " + id);
	}

	static {
		Id = 10;
	}

	public ChildClass() {
		super();
		id = 1;
		System.out.println("CC 1 " + id);
	}

	public ChildClass(int id, String name) {
		super(id, name);
		System.out.println("CC 2");
	}

	public ChildClass(int id) {
		super();
		this.id = id;
		System.out.println("CC 3");
	}

	public static void staticMethod() {
		System.out.println("From Child Static Method");
	}
	
	public static void main(String[] args) {
		new ChildClass();
		new ChildClass(1, "Child Class");
		new ChildClass(2);
		System.out.println();
		System.out.println(new ChildClass().Id);
		
		System.out.println();
		new ChildClass().staticMethod();
		
		System.out.println();
		
		System.out.println();
		ParentClass obj = new ChildClass();
		System.out.println(obj.Id);
		obj.staticMethod();
	}
}
