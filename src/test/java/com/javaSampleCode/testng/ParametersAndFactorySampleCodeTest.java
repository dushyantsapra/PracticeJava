package com.javaSampleCode.testng;

import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

public class ParametersAndFactorySampleCodeTest {
	@Parameters({ "userName", "pwd" })
	@Factory
	public Object[] testFactory(String userName, String pwd) {
		System.out.println("userName : " + userName);
		return new Object[] { new DataProviderAndFactorySampleCodeServiceTest(userName, pwd) };
	}
}
