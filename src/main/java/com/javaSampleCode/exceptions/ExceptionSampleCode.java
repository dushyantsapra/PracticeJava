package com.javaSampleCode.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * We can omit to add "throws" statement from method definition if that method is expected/throwing Unchecked Exception(RuntimeException) as
 * public void testMethod() {
 * 		throw new RuntimeException("Hello From RuntimeExecption");
 * }  
 * Now calling function can also choose whether to handle the Unchecked Method. e.g.
 * 
 * private void abc1() {
		throw new NullPointerException("Hello From NullPointerExecption");
   }
   
   private void abc2() throws NullPointerException {
		throw new NullPointerException("Hello From NullPointerExecption");
   }

   public void abcHelper() {
		abc1();
		abc2();
   }
 * 
 *  */

public class ExceptionSampleCode {
	private void exceptionGeneratorHelper() throws CustomException {
		try {
			System.out.println(1 / 0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
			throw new CustomException(1, "ArithmeticException");
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(1, "GeneralException");
		}
	}

	// Here Exception Thrown from the Try Block would be overloaded by the
	// exception thrown from the finally block.
	// This can be Overcome using Suppressed Exception(introduced in java 7).
	private void exceptionGeneratorSuppressedByFinallyHelper() throws CustomException, IOException {
		BufferedReader reader = null;
		FileReader file = null;
		try {
			file = new FileReader("ABC.txt");
			reader = new BufferedReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new CustomException(1, "FileNotFoundException");
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(1, "GeneralException");
		} finally {
			file.close();
			reader.close();
		}
	}

	public void exceptionGenerator() {
		try {
			exceptionGeneratorHelper();
		} catch (CustomException e) {
			System.out.println("Custom Exception: " + e.getErrorCode() + "_" + e.getErrorMessage());
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public void exceptionGeneratorSuppressedByFinally() {
		try {
			exceptionGeneratorSuppressedByFinallyHelper();
		} catch (CustomException e) {
			System.out.println("Custom Exception: " + e.getErrorCode() + "_" + e.getErrorMessage());
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public static void main(String[] args) {
		new ExceptionSampleCode().exceptionGenerator();
		new ExceptionSampleCode().exceptionGeneratorSuppressedByFinally();
	}
}
