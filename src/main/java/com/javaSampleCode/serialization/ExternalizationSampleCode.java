package com.javaSampleCode.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class ExternalizationPojo implements Externalizable {
	private int id;
	private String name;

	public ExternalizationPojo() {
		super();
	}

	public ExternalizationPojo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = in.readInt();
		name = (String) in.readObject();
	}

	@Override
	public String toString() {
		return "ExternalizationPojo [id=" + id + ", name=" + name + "]";
	}
}

public class ExternalizationSampleCode {
	public static void main(String[] args) throws IOException, ClassCastException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(new ExternalizationPojo(1, "Dushyant Sapra"));
		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		ExternalizationPojo pojo = (ExternalizationPojo) ois.readObject();
		System.out.println(pojo);

		fis.close();
		ois.close();
	}
}
