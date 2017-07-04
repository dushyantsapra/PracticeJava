package com.javaSampleCode.mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

//Spy is used to call Real Methods instead of stubs, We can also define and call stubs on spy
public class MockitoSpySampleCode {
	@Spy
	private List<String> aSpyList = new ArrayList<String>();

	@Test
	public void whenSpyingOnList_thenCorrect() {
		final List<String> list = new ArrayList<String>();
		final List<String> spyList = spy(list);

		spyList.add("one");
		spyList.add("two");

		verify(spyList).add("one");
		verify(spyList).add("two");

		assertEquals(2, spyList.size());
	}

	@Test
	public void whenUsingTheSpyAnnotation_thenObjectIsSpied() {
		MockitoAnnotations.initMocks(MockitoSpySampleCode.class);
		aSpyList.add("one");
		aSpyList.add("two");

		verify(aSpyList).add("one");
		verify(aSpyList).add("two");

		assertEquals(2, aSpyList.size());
	}

	@Test
	public void whenStubASpy_thenStubbed() {
		final List<String> list = new ArrayList<String>();
		final List<String> spyList = spy(list);

		assertEquals(0, spyList.size());

		doReturn(100).when(spyList).size();
		assertEquals(100, spyList.size());
	}

	@Test
	public void whenCreateMock_thenCreated() {
		final List<String> mockedList = mock(ArrayList.class);

		mockedList.add("one");
		verify(mockedList).add("one");

		assertEquals(0, mockedList.size());
	}

	@Test
	public void whenCreateSpy_thenCreate() {
		final List<String> spyList = spy(new ArrayList<String>());

		spyList.add("one");
		verify(spyList).add("one");

		assertEquals(1, spyList.size());
	}

}
