package com.javaSampleCode.mockito;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.Assert;
import org.testng.annotations.Test;

//void method cannot be stubbed with a return value. Voids are usually stubbed with Throwables: doThrow(exception).when(mock).someVoidMethod();

public class MockitoSampleCode {
	@Test
	public void whenWithThenReturnTest() {
		MyList mockedList = mock(MyList.class);
		when(mockedList.add("A")).thenReturn(true);
		mockedList.add("A");
	}

	@Test
	public void whenWithDoReturnTest() {
		MyList mockedList = mock(MyList.class);
		doReturn(true).when(mockedList).add("A");

		mockedList.add("A");
	}

	@Test
	public void whenWithThenCallRealMethodTest() {
		MyList mockedList = mock(MyList.class);
		when(mockedList.add("A")).thenCallRealMethod();
		mockedList.add("A");
	}

	@Test
	public void whenWithDoCallRealMethodTest() {
		MyList mockedList = mock(MyList.class);
		doCallRealMethod().when(mockedList).add("A");
		mockedList.add("A");
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void whenWithThenThrowTest() {
		MyList mockedList = mock(MyList.class);
		when(mockedList.size()).thenThrow(NullPointerException.class);
		mockedList.size();
	}

	@Test(expectedExceptions = { IllegalArgumentException.class, NullPointerException.class })
	public void whenWithDoThrowTest() {
		MyList mockedList = mock(MyList.class);
		doThrow(IllegalArgumentException.class).when(mockedList).size();
		mockedList.size();
	}

	@Test
	public void whenWithAnswerTest() {
		MyList mockedList = mock(MyList.class);
		when(mockedList.get(1)).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				Integer i = (Integer) invocation.getArguments()[0];
				return "Hello " + String.valueOf(i);
			}
		});
		String op = mockedList.get(1);
		Assert.assertEquals("Hello 1", op);
	}

	@Test
	public void whenWithDoAnswerTest() {
		MyList mockedList = mock(MyList.class);
		doAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				Integer i = (Integer) invocation.getArguments()[0];
				return "Hello " + String.valueOf(i);
			}
		}).when(mockedList).get(1);
		String op = mockedList.get(1);
		Assert.assertEquals("Hello 1", op);
	}

	// @Test
	// public void whenTest() {
	// MyList mockedList = mock(MyList.class);
	// when(mockedList.add("A")).thenReturn(true);
	// when(mockedList.add("B")).thenCallRealMethod();
	// when(mockedList.size()).thenThrow(NullPointerException.class);
	// when(mockedList.add("C")).thenAnswer(new Answer<String>() {
	// public String answer(InvocationOnMock invocation) throws Throwable {
	// String string = (String) invocation.getArguments()[0];
	// return "Hello " + string;
	// }
	// });
	//
	// doReturn(true).when(mockedList).add("D");
	// doCallRealMethod().when(mockedList).add("E");
	// doThrow(IllegalArgumentException.class).when(mockedList).size();
	// doNothing().when(mockedList).clear();
	// doAnswer(new Answer<String>() {
	// public String answer(InvocationOnMock invocation) throws Throwable {
	// String string = (String) invocation.getArguments()[0];
	// return "Hello " + string;
	// }
	// }).when(mockedList).add("F");
	// }
}
