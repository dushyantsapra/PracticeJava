package com.javaSampleCode.mockito;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MockingSampleCode {
	// configure simple return behavior for mock
	@Test
	public void whenForMethodHavingReturn() {
		MyList listMock = mock(MyList.class);
		when(listMock.add("ABC")).thenReturn(false);
		boolean added = listMock.add("A");
		assertEquals(added, false);
	}

	@Test
	public void returnForMethodHavingReturn() {
		MyList listMock = mock(MyList.class);
//		doReturn(false).when(listMock).add("ABC");
		doReturn(false).when(listMock).clear();

//		boolean added = listMock.add("ABC");
		listMock.clear();
		assertEquals(added, false);
	}

	@Test(expectedExceptions = IllegalStateException.class)
	public void exceptionForMethodHavingReturn() {
		MyList listMock = mock(MyList.class);
		when(listMock.add("ABC")).thenThrow(IllegalStateException.class);

		listMock.add("ABC");
	}

}
