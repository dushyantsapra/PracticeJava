package com.javaSampleCode.cloning;

import java.io.IOException;

public class CloningSampleCode {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		AddressBean addressBean = null;
		StudentBean studentBean = null;
		EmployeeBean employeeBean = null;

		// Shallow Copy Starts
		System.out.println("Shallow Copy Starts");
		addressBean = new AddressBean("Gurgaon", "Haryana");
		studentBean = new StudentBean("Dushyant", addressBean);

		StudentBean shallowObj = (StudentBean) studentBean.clone();
		System.out.println(shallowObj);

		// Changing Original Address Object through Shallow Cloned Object
		shallowObj.getAddressBean().setCityName("Noida");
		System.out.println(addressBean);
		System.out.println("Shallow Copy End");
		// Shallow Copy Ends

		// Deep Copy Using Clone Method of Object Class Starts
		System.out.println("\nDeep Copy Starts");
		addressBean = new AddressBean("Gurgaon", "Haryana");
		employeeBean = new EmployeeBean("Dushyant", addressBean);

		EmployeeBean deepCopy = (EmployeeBean) employeeBean.clone();
		System.out.println(deepCopy);
		deepCopy.getAddressBean().setCityName("Noida");
		System.out.println(addressBean);
		System.out.println("Deep Copy End");
		// Deep Copy Using Clone Method of Object Class Ends
	}
}
