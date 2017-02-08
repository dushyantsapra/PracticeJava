package com.javaSampleCode.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SuperSerializableClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iValue;

	public SuperSerializableClass() {
		super();
	}

	public SuperSerializableClass(int iValue) {
		super();
		this.iValue = iValue;
	}

	public int getiValue() {
		return iValue;
	}

	public void setiValue(int iValue) {
		this.iValue = iValue;
	}

	protected void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeInt(iValue);
	}

	protected void readObject(ObjectInputStream ois) throws IOException, ClassCastException, ClassNotFoundException {
		iValue = ois.readInt();
	}

	@Override
	public String toString() {
		return "SuperSerializableClass [iValue=" + iValue + "]";
	}
}

class SubSerializableClass extends SuperSerializableClass {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public SubSerializableClass() {
		super();
	}

	public SubSerializableClass(int iValue, String name) {
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
		super.writeObject(oos);
		oos.writeObject(name);
	}

	protected void readObject(ObjectInputStream ois) throws IOException, ClassCastException, ClassNotFoundException {
		super.readObject(ois);
		name = (String) ois.readObject();
	}

	@Override
	public String toString() {
		return super.toString() + " SubSerializableClass [name=" + name + "]";
	}

}

public class ManualSerializationSampleCode1 {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new SubSerializableClass(1, "Dushyant Sapra"));

		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SubSerializableClass obj = (SubSerializableClass) ois.readObject();

		System.out.println(obj);

		fis.close();
		ois.close();
	}
}
