package com.javaSampleCode.util;

//http://javarevisited.blogspot.in/2011/12/final-variable-method-class-java.html

/* 1. Final Variable
 * 2. Final Method
 * 3. Final Class
 * 
 * Note : Once you make a reference final you are not allowed to change that reference and compiler will verify this and raise compilation error if you try to re-initialized final variables in java.
 * 
 * 1.1 Final Variable can only be initialized at declaration, in init block, or in Constructors.
 * 1.2 If Reference is an object then we can change the Objects member variables but we can't refer to another Object.
 * 1.3 Generally Final variables are declare static in to use it as constant
 * 
 * 2.1 Final Methods can't be Overridden
 * 2.2 Final Methods have Compile Time/Static Binding
 * 
 * 3.1 Final Classes can't be sub-classed
 * 3.2 Final Class Member Variables are non Final by default.
 * 3.3 Final with Class is used to declare Immutable classes.
 * 
 * */

class FinalTestBean {
	private int i;
	private String s;

	public FinalTestBean() {
		super();
	}

	public FinalTestBean(int i, String s) {
		super();
		this.i = i;
		this.s = s;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "FinaTestBean [i=" + i + ", s=" + s + "]";
	}
}

class FinalVariableSampleCode {
	private final int i;
	// {
	// i = 10;
	// }

	private final FinalTestBean finalTestBean = new FinalTestBean(1, "asdads");

	public FinalVariableSampleCode() {
		i = 20;
	}

	public int getI() {
		return i;
	}

	public FinalTestBean getFinalTestBean() {
		return finalTestBean;
	}

	public void method() {
		finalTestBean.setS("asdasdad");
	}
}

final class FinalClass {
	private int i;
	private FinalTestBean finalTestBean;

	public FinalClass(int i, FinalTestBean finalTestBean) {
		super();
		this.i = i;
		this.finalTestBean = finalTestBean;
	}

}

public class FinalInJavaSampleCode {
	public static void main(String[] args) {
		FinalClass finalClass = new FinalClass(1, new FinalTestBean(1, "aa"));

	}
}
