package com.qafocus.core;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;

public class TestcaseFinder<T extends Testcase> {

	
	
	private static final MethodAnnotationsScanner METHOD_ANNOTATIONS_SCANNER = new MethodAnnotationsScanner();


	public Set<Method> findCasesCurrentClasspath(String packageStr) {
		
		Reflections reflections = new Reflections(packageStr,METHOD_ANNOTATIONS_SCANNER);

		return getAllMethodWithTestcaseAnnotation(reflections);
	}


	private Set<Method> getAllMethodWithTestcaseAnnotation(Reflections reflections) {
		Set<Method>  methods = reflections.getMethodsAnnotatedWith(Testcase.class);

		methods.stream().forEach( e -> System.out.println(e.getName()));
		return methods;
	}
	
	
	public Set<Method> findCases(Set<URL> urls){
		 ConfigurationBuilder configBuilder = new ConfigurationBuilder();
		 configBuilder.addUrls(urls).addScanners(METHOD_ANNOTATIONS_SCANNER);
		Reflections reflections = new Reflections(configBuilder);
		return getAllMethodWithTestcaseAnnotation(reflections);
	}
}
