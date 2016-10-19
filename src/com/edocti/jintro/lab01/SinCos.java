package com.edocti.jintro.lab01;

/**
 * Read a number x from stdin and display sin2(x) + cos2(x) Is the result always
 * 1? Look how we format the output string in order to detect the cases where
 * the result is not 1
 *
 * @author pianas
 * @version 1.0
 */
public class SinCos {
	public static void main(String... args) {
		Double a = Double.parseDouble(args[0]);
		a = Math.toRadians(a);
		System.out.printf("%.20f\n", Math.pow(Math.sin(a), 2) + Math.pow(Math.cos(a), 2));
	}
}
