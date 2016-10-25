package com.edocti.jintro.lab03.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ASuiteRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ASuiteTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure);
		}
	}

}
