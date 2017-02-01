package com.javaSampleCode.exceptions;

/* Sample Code for "try-with-resource" and "Suppressed Exception".
 * 1. try-with-resource remove the need of finally as it it self call/close the open resource, given the resource implementing Closeable OR AutoCloseable interface.
 * 2. Suppressed Exception(introduced in java7) enables to add/suppress exception occurred in finally block in the exception object occurred in try block. 
 * */

public class SuppressedExceptionSampleCode {
	// Here Exception thrown from the try is overloaded by the exception thrown
	// from the finally block
	private void beforeSuppressedExceptionConcept() {
		CustomResource resource = null;
		try {
			resource = new CustomResource();
			resource.accessResource();
		} finally {
			resource.close();
		}
	}

	public void beforeSuppressedExceptionConceptHelper() {
		try {
			beforeSuppressedExceptionConcept();
		} catch (NullPointerException ex) {
			System.out.println("Inside NullPointerException Catch Block");
			System.out.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.out.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.out.println(exception.toString());
				}
			}
		} catch (RuntimeException ex) {
			System.out.println("Inside RuntimeException Catch Block");
			System.out.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.out.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.out.println(exception.toString());
				}
			}
		} catch (Exception ex) {
			System.out.println("Inside Exception Catch Block");
			System.out.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.out.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.out.println(exception.toString());
				}
			}
		}
	}

	/*
	 * An exception can be thrown from the block of code associated with the
	 * try-with-resources statement. In the example
	 * "suppressedExceptionGenerator", an exception can be thrown from the try
	 * block, and up to one exceptions can be thrown from the try-with-resources
	 * statement when it tries to close the "CustomResource" objects. If an
	 * exception is thrown from the try block and one or more exceptions are
	 * thrown from the try-with-resources statement, then those exceptions
	 * thrown from the try-with-resources statement are suppressed, and the
	 * exception thrown by the block is the one that is thrown by the
	 * suppressedExceptionGenerator method. You can retrieve these suppressed
	 * exceptions by calling the Throwable.getSuppressed method from the
	 * exception thrown by the try block.
	 */
	private void suppressedExceptionGeneratorAuto() {
		try (CustomResource resource = new CustomResource()) {
			resource.accessResource();
		}
	}

	public void suppressedExceptionGeneratorHelper() {
		try {
			suppressedExceptionGeneratorAuto();
		} catch (NullPointerException ex) {
			System.out.println("Inside NullPointerException Catch Block");
			System.out.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.out.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.out.println(exception.toString());
				}
			}
		} catch (RuntimeException ex) {
			System.out.println("Inside RuntimeException Catch Block");
			System.out.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.out.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.out.println(exception.toString());
				}
			}
		} catch (Exception ex) {
			System.out.println("Inside Exception Catch Block");
			System.out.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.out.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.out.println(exception.toString());
				}
			}
		}
	}

	private void suppressedExceptionGeneratorManual() {
		RuntimeException exception = null;
		CustomResource resource = null;
		try {
			resource = new CustomResource();
			resource.accessResource();
		} catch (RuntimeException ex) {
			if (exception == null) {
				exception = ex;
			}
		} finally {
			try {
				resource.close();
			} catch (NullPointerException e) {
				exception.addSuppressed(e);
				throw exception;
			}
		}
	}

	public void suppressedExceptionGeneratorManualHelper() {
		try {
			suppressedExceptionGeneratorManual();
		} catch (RuntimeException ex) {
			System.out.println("Inside RuntimeException Catch Block");
			System.out.println("Exception encountered: " + ex.toString());
			final Throwable[] suppressedExceptions = ex.getSuppressed();
			final int numSuppressed = suppressedExceptions.length;
			if (numSuppressed > 0) {
				System.out.println("There are " + numSuppressed + " suppressed exceptions:");
				for (final Throwable exception : suppressedExceptions) {
					System.out.println(exception.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arguments) throws Exception {
		SuppressedExceptionSampleCode obj = new SuppressedExceptionSampleCode();
		System.out.println("Calling beforeSuppressedExceptionConceptHelper Method\n");
		obj.beforeSuppressedExceptionConceptHelper();
		System.out.println();
		System.out.println("Calling suppressedExceptionGeneratorHelper Method\n");
		obj.suppressedExceptionGeneratorHelper();
		System.out.println();
		System.out.println("Calling suppressedExceptionGeneratorManualHelper Method\n");
		obj.suppressedExceptionGeneratorManualHelper();
		System.out.println();
		System.out.println("Auto Generating and Printing SuppressedException");
		try (CustomResource resource = new CustomResource()) {
			resource.accessResource();
		}
	}
}