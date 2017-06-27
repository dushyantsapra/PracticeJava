package com.javaSampleCode.exceptions;

import java.io.Closeable;

public class CustomResource implements Closeable {
	public void accessResource() throws RuntimeException {
		throw new RuntimeException("I wanted to access this resource. Bad luck. Its dirty resource !!!");
	}

	@Override
	public void close() throws NullPointerException {
		throw new NullPointerException("Remember me. I am your worst nightmare !! I am Null pointer exception !!");
	}
}
