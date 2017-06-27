package com.javaSampleCode.testng;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactorySampleCode {
	private String userName;
	private String pwd;

	public FactorySampleCode() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Factory(dataProvider="dataProvider", dataProviderClass = DataProviderClassTest.class)
	public FactorySampleCode(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}

	@Test
	public void testMethod() {
		System.out.println(userName + " " + pwd);
	}
}
