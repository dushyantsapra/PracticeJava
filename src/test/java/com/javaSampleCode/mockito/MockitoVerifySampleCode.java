package com.javaSampleCode.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;

import java.util.List;

import org.mockito.InOrder;
import org.mockito.Mockito;
import org.testng.annotations.Test;

public class MockitoVerifySampleCode {
	// Verify whether a stub has be invoked or not, Will Fail If Same Argument
	// is not Passed
	@Test
	public void verifyTest() {
		List<String> listMock = mock(MyList.class);
		listMock.size();
		listMock.add("ABC");

		verify(listMock).add("ABC");
		verify(listMock).size();
	}

	// Here If We Pass 0 then it would act same as of <verifyZeroInteractions>
	@Test
	public void verifyForNumberOfIterationTest() {
		List<String> listMock = mock(MyList.class);
		listMock.add("ABC");
		verify(listMock, times(1)).add("ABC");
	}

	@Test
	public void verifyForNoIterationTest() {
		List<String> listMock = mock(MyList.class);
		verifyZeroInteractions(listMock);
	}

	// Will Fail as After add No More Interaction needed
	@Test
	public void verifyNoMoreInteractionsTest() {
		List<String> listMock = mock(MyList.class);
		listMock.add("ABC");
		listMock.clear();

		verify(listMock).add("ABC");
		verifyNoMoreInteractions(listMock);
	}

	@Test
	public void verifyOrderOfInterationTest() {
		List<String> listMock = mock(MyList.class);
		listMock.add("ABC");
		listMock.size();
		listMock.clear();

		InOrder inOrder = Mockito.inOrder(listMock);
		inOrder.verify(listMock).add("ABC");
		inOrder.verify(listMock).size();
		inOrder.verify(listMock).clear();
	}

	@Test
	public void verifyAnInterationNeverOccurredTest() {
		List<String> listMock = mock(MyList.class);
		listMock.add("ABC");
		listMock.size();

		verify(listMock, never()).clear();
	}

	@Test
	public void verifyLeastAndMostNumberOfIterationTest() {
		List<String> mockedList = mock(MyList.class);
		mockedList.clear();
		mockedList.clear();
		mockedList.clear();

		verify(mockedList, atLeast(1)).clear();
		verify(mockedList, atMost(10)).clear();
	}

}
