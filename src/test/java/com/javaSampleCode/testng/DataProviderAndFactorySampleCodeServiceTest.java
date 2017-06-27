package com.javaSampleCode.testng;

import org.testng.annotations.Test;

public class DataProviderAndFactorySampleCodeServiceTest {
	private String userName;
	private String pwd;

	public DataProviderAndFactorySampleCodeServiceTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataProviderAndFactorySampleCodeServiceTest(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}

	@Test
	public void testMethod() {
		System.out.println(userName + " " + pwd);
	}
}
