package com.qafocus.core;

import java.lang.reflect.AnnotatedElement;
import java.util.Optional;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.AnnotationUtils;

public class ExecutionPlanCondition implements ExecutionCondition {
	
	private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("@Testcase is not present");

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
		System.out.println("######################3evaluateExecutionCondition######################");
		Optional<AnnotatedElement> element = context.getElement();
		 Optional<Testcase> disabled = AnnotationUtils.findAnnotation(element,Testcase.class);
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		boolean result = false;
		// result = write logic for disable test using your script engine.
		if (result)
			return ConditionEvaluationResult.disabled("@MyDisabledIf is present with valid condition");
		return ENABLED;
	}

}