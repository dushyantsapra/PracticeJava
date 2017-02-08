package com.javaSampleCode.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Here If SuperClass is not Serializable then its member variable would not be Serialized.

class SuperClass1 {
	private int iValue;

	public SuperClass1() {
		super();
		System.out.println(1);
	}

	public SuperClass1(int iValue) {
		super();
		this.iValue = iValue;
		System.out.println(2);
	}

	public int getiValue() {
		return iValue;
	}

	public void setiValue(int iValue) {
		this.iValue = iValue;
	}

	@Override
	public String toString() {
		return "SuperClass1 [iValue=" + iValue + "]";
	}
}

class SubClass1 extends SuperClass1 implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	public SubClass1() {
		super();
		System.out.println(3);
	}

	public SubClass1(int iValue, String name) {
		super(iValue);
		System.out.println(4);
		this.name = name;
		System.out.println(4);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + " SubClass1 [name=" + name + "]";
	}

}

public class SerializationWithInheritanceSampleCode {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new SubClass1(1, "Dushyant Sapra"));

		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SubClass1 obj = (SubClass1) ois.readObject();

		System.out.println(obj);

		fis.close();
		ois.close();
	}
}