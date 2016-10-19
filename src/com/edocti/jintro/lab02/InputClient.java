package com.edocti.jintro.lab02;

import static java.lang.System.out;

import com.edocti.jintro.utils.Input;

/**
 * This class has multiple purposes:
 * <ul>
 * <li>It shows an example of using the Input class</li>
 * <li>It introduces the {@link String#equalsIgnoreCase} method</li>
 * <li>It shows you an example usage of {@link System.out#format}</li>
 * <li>It shows the handy import static: see that we write
 * <code>out.println</code> instead of <code>System.out.println()</code></li>
 * <li>It shows a Javadoc example.</li>
 * </ul>
 *
 * @author pianas
 * @since version 0.1
 * @see java.util.Scanner
 */
class InputClient {

	public static void main(String... args) {

		System.out.print("N = ");
		// 1. create object of type Input
		Input in = new Input();
		// 2. read an integer from standard input
		int N = in.readInt();

		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = in.readInt();
		}

		// 3. close in
		in.close(); // don't forget to close input!

		out.println("The array you entered looks like this:");
		for (int i = 0; i < N; i++) {
			out.format("%d ", numbers[i]);
		}
		out.println();
	}
}
