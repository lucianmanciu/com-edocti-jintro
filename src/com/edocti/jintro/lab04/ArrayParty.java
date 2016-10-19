package com.edocti.jintro.lab04;

import com.edocti.jintro.lab03.*;

class ArrayParty {

	// this is how we define a constant in Java:
	private static final boolean DISPLAY_ARR = true;

	public static void main(String[] args) {
		@SuppressWarnings("unused")  // suppress compiler warning about unused variable
		Shape[][] shapes = generateArr(5, 10);
	}

	private static void printArr(Shape[] shapes) {
		for (Shape s : shapes) {
			if (s == null) {
				System.out.print("    null    ");
			} else {
				System.out.printf("%04d,%04d   ", s.getX(), s.getY());
			}

		}
		System.out.println();
	}

	private static Shape[][] generateArr(int N, int M) {
		Shape[][] arr = new Shape[N][];
		for (int i = 0; i < N; i++) {
			int cols = 1 + (int) (M * Math.random());
			arr[i] = new Shape[cols];
			if (DISPLAY_ARR)
				printArr(arr[i]);
			for (int j = 0; j < cols; j++) {
				arr[i][j] = new Circle(10 + i, 20 + j, i + j);
			}
			if (DISPLAY_ARR)
				printArr(arr[i]);
		}
		return arr;
	}
}
