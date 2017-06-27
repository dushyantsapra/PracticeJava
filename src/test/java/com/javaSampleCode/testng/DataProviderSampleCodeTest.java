package com.javaSampleCode.testng;

import org.testng.annotations.Test;

public class DataProviderSampleCodeTest {
	@Test(dataProvider = "dataProvider", dataProviderClass = DataProviderClassTest.class)
	public void testMethod(String userName, String pwd) {
		System.out.println(userName + " " + pwd);
	}
}
