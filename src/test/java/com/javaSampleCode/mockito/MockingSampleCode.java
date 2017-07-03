package com.javaSampleCode.mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;
import static org.testng.Assert.assertEquals;

import org.mockito.Mockito;
import org.testng.annotations.Test;

//void method cannot be stubbed with a return value. Voids are usually stubbed with Throwables: doThrow(exception).when(mock).someVoidMethod();

public class MockingSampleCode {

	@Test
	public void whenWithReturn() {
		MyList listMock = mock(MyList.class);
		when(listMock.add("ABC")).thenReturn(true);
		boolean added = listMock.add("ABC");
		assertEquals(added, true);
	}

	@Test
	public void whenWithDoReturn() {
		MyList listMock = mock(MyList.class);
		doReturn(true).when(listMock).add("ABC");
		boolean added = listMock.add("ABC");
		assertEquals(added, true);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void doThrowWithWhenUsingMethodWithVoidReturnType() {
		MyList listMock = mock(MyList.class);
		doThrow(NullPointerException.class).when(listMock).clear();
		listMock.clear();
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void doThrowWithWhenUsingMethodWithReturnType() {
		MyList listMock = mock(MyList.class);
		doThrow(NullPointerException.class).when(listMock).add("ABC");
		listMock.add("ABC");
	}

	@Test(expectedExceptions = { NullPointerException.class, IllegalArgumentException.class })
	public void whenWithThenThrow() {
		MyList listMock = mock(MyList.class);
		when(listMock.add("ABC")).thenThrow(IllegalArgumentException.class);

		listMock.add("ABC");
	}

	@Test
	public void whenThenForMultipleCall() {
		MyList listMock = mock(MyList.class);
		when(listMock.add("ABC")).thenReturn(true).thenReturn(false);

		assertEquals(listMock.add("ABC"), true);
		assertEquals(listMock.add("ABCA"), false);
	}

	@Test(expectedExceptions = { NullPointerException.class, IllegalArgumentException.class })
	public void spy() {
		MyList instance = new MyList();
		MyList spy = Mockito.spy(instance);

		doThrow(NullPointerException.class).when(spy).size();
		spy.size();

	}

}
