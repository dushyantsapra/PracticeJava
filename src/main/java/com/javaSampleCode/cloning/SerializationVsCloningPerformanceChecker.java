package com.javaSampleCode.cloning;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Deep Cloning can be done using Serialization but it takes around 99% more time then deep copy described below
 * */

public class SerializationVsCloningPerformanceChecker {

	static public Object deepCopy(Object oldObj) throws Exception {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(); // A
			oos = new ObjectOutputStream(bos); // B

			// serialize and pass the object
			oos.writeObject(oldObj); // C
			oos.flush(); // D

			ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray()); // E
			ois = new ObjectInputStream(bin); // F

			// return the new object
			return ois.readObject(); // G

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in ObjectCloner = " + e);
			throw (e);
		} finally {
			oos.close();
			ois.close();
		}

	}

	static public void main(String[] args) {
		try {
			final int iter = 1000000;

			AddressBean addressBean = null;
			EmployeeBean employeeBean = null;
			addressBean = new AddressBean("Gurgaon", "Haryana");
			employeeBean = new EmployeeBean("Dushyant", addressBean);

			// Car c1 = new Car("Chevy", new Engine(6), new Trunk("Large"));

			long start1 = System.currentTimeMillis();
			for (int i = 0; i < iter; i++) {
				deepCopy(employeeBean);
			}
			long time1 = System.currentTimeMillis() - start1;

			long start2 = System.currentTimeMillis();
			for (int i = 0; i < iter; i++) {
				employeeBean.clone();
			}
			long time2 = System.currentTimeMillis() - start2;

			double d1 = time1;
			double d2 = time2;
			double percentDiff = 100 - ((d2 / d1) * 100);
			System.out.println("For " + iter + " iterations:");
			System.out.println("Serialize deep copy time = " + d1 + " ms");
			System.out.println("Clone deep copy time =     " + d2 + " ms");
			System.out.println("Clone is " + String.valueOf(percentDiff) + "% faster");
		} catch (CloneNotSupportedException ex) {
			System.out.println("Clone not supported exception = " + ex);
		} catch (Exception ee) {
			System.out.println("General Exception = " + ee);
		}

	}
}