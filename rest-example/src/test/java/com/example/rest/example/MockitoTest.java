package com.example.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
	
	@Test
	public void whenNotUseMockAnnotation_thenCorrect() {
	    @SuppressWarnings("unchecked")
		List<String> mockList = Mockito.mock(ArrayList.class);
	    
	    mockList.add("one");
	    Mockito.verify(mockList).add("one");
	    assertEquals(0, mockList.size());

	    Mockito.when(mockList.size()).thenReturn(100);
	    assertEquals(100, mockList.size());
	}
	
	@Mock
	List<String> mockedList;

	@Test
	public void whenUseMockAnnotation_thenMockIsInjected() {
	    mockedList.add("one");
	    Mockito.verify(mockedList).add("one");
	    assertEquals(0, mockedList.size());

	    Mockito.when(mockedList.size()).thenReturn(100);
	    assertEquals(100, mockedList.size());
	}
	
	@Test
	void shouldThrowException() {
	    Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
	      throw new UnsupportedOperationException("Not supported");
	    });
	    assertEquals("Not supported", exception.getMessage());
	}
	
	@Test
	public void whenNotUseSpyAnnotation_thenCorrect() {
	    List<String> spyList = Mockito.spy(new ArrayList<String>());
	    
	    spyList.add("one");
	    spyList.add("two");

	    Mockito.verify(spyList).add("one");
	    Mockito.verify(spyList).add("two");

	    assertEquals(2, spyList.size());

	    Mockito.doReturn(100).when(spyList).size();
	    assertEquals(100, spyList.size());
	}
	
	@Spy
	List<String> spiedList = new ArrayList<String>();

	@Test
	public void whenUseSpyAnnotation_thenSpyIsInjectedCorrectly() {
	    spiedList.add("one");
	    spiedList.add("two");

	    Mockito.verify(spiedList).add("one");
	    Mockito.verify(spiedList).add("two");

	    assertEquals(2, spiedList.size());

	    Mockito.doReturn(100).when(spiedList).size();
	    assertEquals(100, spiedList.size());
	}

	
}
