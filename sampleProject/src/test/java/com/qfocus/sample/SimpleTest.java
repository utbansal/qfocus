package com.qfocus.sample;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.qafocus.core.ExecutionPlanCondition;
import com.qafocus.core.Testcase;

@ExtendWith(ExecutionPlanCondition.class)
public class SimpleTest {

	
	@Testcase
	@Test
	public void sampleTestForAnnotation() {
		System.out.println("Sample testing");
//		assertTrue(true);
	}

	@Testcase
	@Test
	public void anotherUsecaseTest() {
		
	}
	
}
