package com.javaSampleCode.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class ExternalizationSuperClass implements Externalizable {
	protected int id;

	public ExternalizationSuperClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExternalizationSuperClass(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		id = in.readInt();
	}

	@Override
	public String toString() {
		return "ExternalizationSuperClass [id=" + id + "]";
	}
}

class ExternalizationSubClass extends ExternalizationSuperClass implements Externalizable {
	private String name;

	public ExternalizationSubClass() {
		super();
	}

	public ExternalizationSubClass(int id, String name) {
		super(id);
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
		super.writeExternal(out);
		out.writeObject(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
		name = (String) in.readObject();
	}

	@Override
	public String toString() {
		return "ExternalizationSubClass [name=" + name + ", id=" + id + "]";
	}
}

public class ExternalizationWithInheritanceSampleCode1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(new ExternalizationSubClass(1, "Dushyant Sapra"));
		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream("C:\\Users\\xdussap\\workspace\\ABC.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);

		ExternalizationSubClass obj = (ExternalizationSubClass) ois.readObject();
		System.out.println(obj);
		
		fis.close();
		ois.close();
	}
}
