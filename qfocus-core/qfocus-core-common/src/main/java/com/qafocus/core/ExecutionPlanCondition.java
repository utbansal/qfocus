package com.qafocus.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ClassUtils;

import com.qafocus.core.util.CsvLoader;

import sun.reflect.annotation.AnnotationType;

public class ExecutionPlanCondition implements ExecutionCondition {

	private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("@Testcase to be executed");
	private static final ConditionEvaluationResult DISABLED = ConditionEvaluationResult.enabled("@Testcase NOT to be executed");

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		System.out.println("######################3evaluateExecutionCondition######################");
		try {
			Optional<AnnotatedElement> element = context.getElement();
			Optional<Testcase> annotationPresent = AnnotationUtils.findAnnotation(element, Testcase.class);
			if(!annotationPresent.isPresent()) return ENABLED;
			AnnotatedElement annotatedElement = element.get();
			String identifier = getIdentifier(annotatedElement);
			
			Optional<com.qafocus.data.Testcase> findTestDataOptional = findTestData(identifier);
			if(!findTestDataOptional.isPresent())  {
				return ENABLED; 
			}
			com.qafocus.data.Testcase testcase = findTestDataOptional.get();
			return testcase.isEnabled()?  ENABLED : DISABLED;
			
		} catch (IOException e) {
			e.printStackTrace();
			return ENABLED;
		}
	}

	private String getIdentifier(AnnotatedElement annotatedElement) {
		String identifier = "";
		if (annotatedElement instanceof Method) {
			Method m = (Method) annotatedElement;
			System.out.println(m.getName());
			identifier = m.getDeclaringClass().getName() + "." + m.getName();
		}
		if (annotatedElement instanceof Class) {

			Class cls = (Class) annotatedElement;
			identifier = cls.getName();
		}
		return identifier;
	}

	private Optional<com.qafocus.data.Testcase> findTestData(String identifier) throws IOException {
//		File planFile = new File(this.getClass().getClassLoader().getResource("sample/execution_plan.csv").getFile());
		List<com.qafocus.data.Testcase> readCSV = CsvLoader.readCSV(planFile);
		Map<String, com.qafocus.data.Testcase> map = readCSV.stream()
				.collect(Collectors.toMap(e -> e.getIdentifier(), e -> e));
		com.qafocus.data.Testcase value = map.get(identifier);
		return Optional.ofNullable(value);
	}

	private File planFile = new File("D:/execution_plan.csv");

}