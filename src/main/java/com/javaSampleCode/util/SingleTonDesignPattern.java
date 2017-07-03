package com.javaSampleCode.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingleTon implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private static SingleTon instance = new SingleTon(); // Eager
	private static volatile SingleTon instance = null;

	private SingleTon() {
		if (instance != null) {
			throw new RuntimeException("Cannot create, Please Use getInstance");
		}
		System.out.println("Creating..");
	}

	public static SingleTon getInstance() {
		if (instance == null)
			synchronized (SingleTon.class) {
				if (instance == null)
					instance = new SingleTon();
			}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone Not Supported");
	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("Read Resolve");
		return instance;
	}
}

public class SingleTonDesignPattern {
	static void useSingleTon() {
		SingleTon singleTon = SingleTon.getInstance();
		print("SingleTon", singleTon);
	}

	static void breakUsingReflection() throws Exception {
		System.out.println("*****Reflection Example*****");
		SingleTon s1 = SingleTon.getInstance();
		SingleTon s2 = SingleTon.getInstance();

		print("s1", s1);
		print("s2", s2);

		try {
			Class clazz = Class.forName("com.javaSampleCode.util.SingleTon");
			Constructor<SingleTon> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			SingleTon s3 = constructor.newInstance();
			print("s3", s3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void breakUsingSerialization() throws Exception {
		System.out.println("*****Serialization Example*****");
		SingleTon s1 = SingleTon.getInstance();
		SingleTon s2 = SingleTon.getInstance();

		print("s1", s1);
		print("s2", s2);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/home/sapra/Documents/seralize.txt"));
		oos.writeObject(s1);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/sapra/Documents/seralize.txt"));
		SingleTon s3 = (SingleTon) ois.readObject();
		print("s3", s3);
	}

	static void breakUsingCloning() throws Exception {
		System.out.println("*****Cloning Example*****");
		SingleTon s1 = SingleTon.getInstance();
		SingleTon s2 = SingleTon.getInstance();

		print("s1", s1);
		print("s2", s2);

		try {
			SingleTon s3 = (SingleTon) s1.clone();
			print("s3", s3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void breakUsingMultiThread() {
		System.out.println("*****Multi Thread Example*****");
		ExecutorService service = Executors.newFixedThreadPool(10);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);
		service.execute(SingleTonDesignPattern::useSingleTon);

		service.shutdown();
	}

	static void print(String name, SingleTon object) {
		System.out.format("Object : %s, HashCode : %d\n", name, object.hashCode());
	}

	public static void main(String[] args) throws Exception {
		// breakUsingReflection();
		// breakUsingSerialization();
		// breakUsingCloning();
		breakUsingMultiThread();
	}

}
