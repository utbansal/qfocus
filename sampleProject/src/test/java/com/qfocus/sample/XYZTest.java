package com.qfocus.sample;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.qafocus.core.ExecutionPlanCondition;
import com.qafocus.core.Testcase;

@ExtendWith(ExecutionPlanCondition.class)
@Testcase
public class XYZTest {

	
	@Testcase
	@Test
	public void xyz_test1() {
		System.out.println("Sample testing. To be executed");
//		assertTrue(true);
	}

	@Test
	@Testcase
	public void xyz_test2() {
		
		System.out.println("Sample testing. DO not run");
	}
	
}
