package com.javaSampleCode.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SuperSerializableClass1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int iValue;

	public SuperSerializableClass1() {
		super();
	}

	public SuperSerializableClass1(int iValue) {
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
		return "SuperSerializableClass1 [iValue=" + iValue + "]";
	}
}

class SubSerializableClass1 extends SuperSerializableClass1 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public SubSerializableClass1() {
		super();
	}

	public SubSerializableClass1(int iValue, String name) {
		super(iValue);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeInt(iValue);
		oos.writeObject(name);
	}

	protected void readObject(ObjectInputStream ois) throws IOException, ClassCastException, ClassNotFoundException {
		super.iValue = ois.readInt();
		name = (String) ois.readObject();
	}

	@Override
	public String toString() {
		return super.toString() + " SubSerializableClass1 [name=" + name + "]";
	}

}

public class ManualSerializationSampleCode2 {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new SubSerializableClass1(1, "Dushyant Sapra"));

		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SubSerializableClass1 obj = (SubSerializableClass1) ois.readObject();

		System.out.println(obj);

		fis.close();
		ois.close();
	}
}