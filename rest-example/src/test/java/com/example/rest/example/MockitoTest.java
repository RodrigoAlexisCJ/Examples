package com.example.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

}
