package com.javaSampleCode.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FaultySingleTon implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static FaultySingleTon instance = new FaultySingleTon(); // Eager
	private static FaultySingleTon instance = null;

	private FaultySingleTon() {
		System.out.println("Creating..");
	}

	public static FaultySingleTon getInstance() {
		if (instance == null)
			instance = new FaultySingleTon();
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class FaultySingleTonDesignPattern {
	static void useSingleTon() {
		FaultySingleTon faultySingleTon = FaultySingleTon.getInstance();
		print("FaultySingleTon", faultySingleTon);
	}

	static void breakUsingReflection() throws Exception {
		System.out.println("*****Reflection Example*****");
		FaultySingleTon s1 = FaultySingleTon.getInstance();
		FaultySingleTon s2 = FaultySingleTon.getInstance();

		print("s1", s1);
		print("s2", s2);

		Class clazz = Class.forName("com.javaSampleCode.util.FaultySingleTon");
		Constructor<FaultySingleTon> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		FaultySingleTon s3 = constructor.newInstance();

		print("s3", s3);
	}

	static void breakUsingSerialization() throws Exception {
		System.out.println("*****Serialization Example*****");
		FaultySingleTon s1 = FaultySingleTon.getInstance();
		FaultySingleTon s2 = FaultySingleTon.getInstance();

		print("s1", s1);
		print("s2", s2);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/sapra/Documents/seralize.txt"));
		oos.writeObject(s1);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/sapra/Documents/seralize.txt"));
		FaultySingleTon s3 = (FaultySingleTon) ois.readObject();
		print("s3", s3);
	}

	static void breakUsingCloning() throws Exception {
		System.out.println("*****Cloning Example*****");
		FaultySingleTon s1 = FaultySingleTon.getInstance();
		FaultySingleTon s2 = FaultySingleTon.getInstance();

		print("s1", s1);
		print("s2", s2);
		FaultySingleTon s3 = (FaultySingleTon) s1.clone();
		print("s3", s3);
	}

	static void breakUsingMultiThread() {
		System.out.println("*****Multi Thread Example*****");
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(FaultySingleTonDesignPattern::useSingleTon);
		service.execute(FaultySingleTonDesignPattern::useSingleTon);

		service.shutdown();
	}

	public static void main(String[] args) throws Exception {
		breakUsingSerialization();
		breakUsingCloning();
		breakUsingReflection();
		// To Prove, Comment above 3 method Call
		breakUsingMultiThread();
	}

	static void print(String name, FaultySingleTon object) {
		System.out.format("Object : %s, HashCode : %d\n", name, object.hashCode());
	}
}
