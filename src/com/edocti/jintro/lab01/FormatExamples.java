package com.edocti.jintro.lab01;

import static java.lang.System.out;

public class FormatExamples {
	public static void main(String[] x) {
		int a = 10, b = 20;
		out.printf("%7d, %07d\n", a, b);
		out.printf("%d, %03d\n", a, b);
		out.printf("Result is: \t \"%s\" \n", "Cucu");

		boolean ok = (a == 10) && (b == 30);
		boolean equal = (a == b);
		out.println("" + ok + " " + equal);
	}
}
