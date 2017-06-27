package com.javaSampleCode.testng;

import org.testng.annotations.Factory;

public class DataProviderAndFactorySampleCodeTest {
	@Factory(dataProvider = "dataProvider", dataProviderClass = DataProviderClassTest.class)
	public Object[] testFactory(String userName, String pwd) {
		return new Object[] { new DataProviderAndFactorySampleCodeServiceTest(userName, pwd) };
	}
}
