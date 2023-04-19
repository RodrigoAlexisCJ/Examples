package com.example.rest.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rest.example.model.User;
import com.example.rest.example.model.UserRepository;

@SpringBootTest
class RestExampleApplicationTests {

	@Autowired
	private UserRepository repository;
	
	private static Logger log = LoggerFactory.getLogger(RestExampleApplicationTests.class);
	
//	@BeforeEach
//	public void onInit() {
//		repository.saveAll(Stream.of(
//                new User("pashu", "calderon", "pashuCalderon@gmail.com"),
//                new User("cuquito", "calderon", "cuquitoCalderon@gmail.com")
//        ).
//        collect(Collectors.toList()));
//	}
	
	@DisplayName("Single not empty repository test successful")
	@Test
	void contextLoads() {
		assertThat(repository).isNotNull();
	}
	
	@DisplayName("Single user test successful")
	@Test
	//@Disabled("Not Implemented Yet")
	void assertNameById() {
//		assertEquals(repository.findById(1).get().getFirstName(), "pashu");
		assertEquals(repository.findUserById(1).getFirstName(), "pashu");
	}
	
	@Test
	@Disabled("Not Implemented Yet")
	void assertName() {
//		assertEquals(repository.findById(1).get().getFirstName(), "pashu");
		assertEquals(repository.findUserById(1).getFirstName(), "pashu");
	}
	
	@Test
	void lambdaExpressions() {
	    List<Integer> numbers = Arrays.asList(1, 2, 3);
	    assertTrue(numbers.stream()
	      .mapToInt(Integer::intValue)
	      .sum() > 5, () -> "Sum should be greater than 5");
	}
	
	@Test
	 void groupAssertions() {
	     int[] numbers = {0, 1, 2, 3, 4};
	     assertAll("numbers",
	         () -> assertEquals(numbers[1], 1),
	         () -> assertEquals(numbers[3], 3),
	         () -> assertEquals(numbers[1], 1)
	     );
	 }
	
	@AfterAll
	static void done() {
	    log.info("@AfterAll - executed after all test methods.");
	}
	
	@Test
	void trueAssumption() {
	    assumeTrue(5 > 1);
	    assertEquals(5 + 2, 7);
	}

	@Test
	void falseAssumption() {
	    assumeFalse(5 < 1);
	    assertEquals(5 + 2, 7);
	}

	@Test
	void assumptionThat() {
	    String someString = "Just a string";
	    assumingThat(
	        someString.equals("Just a string"),
	        () -> assertEquals(2 + 2, 4)
	    );
	}
	
	@Test
	void shouldThrowException() {
	    Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
	      throw new UnsupportedOperationException("Not supported");
	    });
	    assertEquals("Not supported", exception.getMessage());
	}

	@Test
	void assertThrowsException() {
	    String str = null;
	    assertThrows(IllegalArgumentException.class, () -> {
	      Integer.valueOf(str);
	    });
	}

//	@TestFactory
//	Stream<DynamicTest> translateDynamicTestsFromStream() {
//	    return in.stream()
//	      .map(word ->
//	          DynamicTest.dynamicTest("Test translate " + word, () -> {
//	            int id = in.indexOf(word);
//	            assertEquals(out.get(id), translate(word));
//	          })
//	    );
//	}
}
