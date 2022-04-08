package com.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


//@TestInstance(Lifecycle.PER_CLASS)  //to create one instance copy
@DisplayName("MathUtils Testing")
class MathUtilsTest {

	MathUtils m ;
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("before all ");
	}
	
	@BeforeEach
	void init() {
		m = new MathUtils();
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("cleaning up...!!!");
	}
	
	
	
	@Nested
	@DisplayName("Testing Add Method")
	@Tag("Math")
	class testAdd {
		
		@Test
		@DisplayName("adding two positive no")
		void addOne() {
			assertEquals(4, m.add(2, 2),"the addtion is not matched");
		}
		
		@Test
		@DisplayName("adding two negative no")
		void addtwo() {
			int expected = -2;
			int actual = m.add(-1, -1);
			assertEquals(expected, actual, () -> "the addtion is not matched expected: "+expected+" the actual value :"+actual);
		}
		
	}

	@Test
	@DisplayName("Testing Multiply Method")
	@Tag("Math")
	void multiply() {
		assertAll(
				() -> assertEquals(2,m.multiply(2, 1)),
				() -> assertEquals(4,m.multiply(2, 2)),
				() -> assertEquals(2,m.multiply(2, 1))
				);  //for multiple testing
	}
	

	//@RepeatedTest(3) //for repeated test 
	//@EnabledOnOs(OS.LINUX)  //its skip the test if OS doesn't match 
	@Test
	@DisplayName("Testing ComputeCircleArea Method")
	@Tag("Circle")
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, m.computeCircleArea(10),"area of circle not matched");
	}
	
	
	@Test
	@DisplayName("Testing divide Method")
	@Tag("Math")
	void testDivide() {
		//assumeTrue(false); //its skip the test if assume is false
		assertThrows(ArithmeticException.class, () -> m.divide(1, 0),"divide by zero should throws an exception");
	}
	
	@Test
	@Disabled //its skip the test
	void disableTest() {
		fail("fails......");
	}
}

