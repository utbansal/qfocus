package com.qafocus.core;

import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestcaseFinderTest {

	
	@Test
	public void findCases() throws MalformedURLException {
		
		TestcaseFinder<Testcase> tcFinder = new TestcaseFinder<>();
		Set<URL> urls = new HashSet<>();
		urls.add(Paths.get("D:\\dev\\code\\qafocus\\core-common-1.0.jar").toUri().toURL());
		Set<Method> findCases = tcFinder.findCases(urls);
		assertNotNull(findCases);
	}
}
