package com.javaSampleCode.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class SuperClass {
	protected int iValue;

	public SuperClass() {
		super();
	}

	public SuperClass(int iValue) {
		super();
		this.iValue = iValue;
	}

	public int getiValue() {
		return iValue;
	}

	public void setiValue(int iValue) {
		this.iValue = iValue;
	}

	@Override
	public String toString() {
		return "SuperClass [iValue=" + iValue + "]";
	}
}

class SubClass extends SuperClass implements Externalizable {
	private String name;

	public SubClass() {
		super();
	}

	public SubClass(int iValue, String name) {
		super(iValue);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(super.iValue);
		out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassCastException, ClassNotFoundException {
		super.iValue = in.readInt();
		name = (String) in.readObject();
	}

	@Override
	public String toString() {
		return super.toString() + "SubClass [name=" + name + "]";
	}
}

public class ExternalizationWithInheritanceSampleCode2 {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new SubClass(1, "Dushyant Sapra"));

		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SubClass subClass = (SubClass) ois.readObject();

		System.out.println(subClass);

		fis.close();
		ois.close();
	}
}
