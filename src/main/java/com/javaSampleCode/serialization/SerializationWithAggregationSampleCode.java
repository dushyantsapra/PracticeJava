package com.javaSampleCode.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class TestPojo {
	private int id;

	public TestPojo() {
		super();
		System.out.println("1");
	}

	public TestPojo(int id) {
		super();
		this.id = id;
		System.out.println("2");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TestPojo [id=" + id + "]";
	}
}

class MainClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TestPojo testPojo;
	private String name;

	public MainClass() {
		super();
		System.out.println(3);
	}

	public MainClass(TestPojo testPojo, String name) {
		super();
		this.testPojo = testPojo;
		this.name = name;
		System.out.println(4);
	}

	public TestPojo getTestPojo() {
		return testPojo;
	}

	public void setTestPojo(TestPojo testPojo) {
		this.testPojo = testPojo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		// Would Not work as TestPojo is not Serializable
		// oos.writeObject(testPojo);

		oos.writeInt(testPojo.getId());
		oos.writeObject(name);
	}

	private void readObject(ObjectInputStream ois) throws IOException, ClassCastException, ClassNotFoundException {
		// Would Not work as TestPojo is not Serializable
		// testPojo = (TestPojo) ois.readObject();

		testPojo = new TestPojo(ois.readInt());
		name = (String) ois.readObject();
	}

	@Override
	public String toString() {
		return "MainClass [testPojo=" + testPojo + ", name=" + name + "]";
	}

}

public class SerializationWithAggregationSampleCode {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new MainClass(new TestPojo(1), "Dushyant"));
		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		MainClass mainClass = (MainClass) ois.readObject();
		System.out.println(mainClass);
		fis.close();
		ois.close();
	}
}