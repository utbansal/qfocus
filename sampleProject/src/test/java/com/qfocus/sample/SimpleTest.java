package com.qfocus.sample;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.qafocus.core.ExecutionPlanCondition;
import com.qafocus.core.Testcase;

@ExtendWith(ExecutionPlanCondition.class)
@Testcase
public class SimpleTest {

	@Testcase
	@Test
	@RepeatedTest(value = 5)
	public void sampleTestForAnnotation() {
		System.out.println("Sample testing. To be executed");
//		assertTrue(true);
	}

	@Test
	@Testcase
	public void anotherUsecaseTest() {
		
		System.out.println("Sample testing. DO not run");
	}
	
	
}
