package com.qfocus.sample;


import org.junit.jupiter.api.Test;

import com.qafocus.core.Testcase;

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
