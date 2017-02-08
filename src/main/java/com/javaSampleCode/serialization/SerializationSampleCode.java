package com.javaSampleCode.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Adding or Deleting Fields from POJO class has no effect on Serialization 

class TestBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int iCount;
	private int autoId;
	private String fName;
	private String lName;
	private transient int fee;

	static {
		iCount = 1;
	}

	public TestBean() {
		super();
	}

	public TestBean(int autoId, String fName, String lName, int fee) {
		super();
		this.autoId = autoId;
		this.fName = fName;
		this.lName = lName;
		this.fee = fee;
	}

	public int getAutoId() {
		return autoId;
	}

	public void setAutoId(int autoId) {
		this.autoId = autoId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "TestBean [autoId=" + autoId + ", fName=" + fName + ", lName=" + lName + ", fee=" + fee + "]";
	}
}

public class SerializationSampleCode {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new TestBean(1, "Dushyant", "Sapra", 1000));

		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		TestBean testBean = (TestBean) ois.readObject();
		System.out.println(testBean);

		fis.close();
		ois.close();
	}
}