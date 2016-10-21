package com.edocti.jintro.lab02;

import com.edocti.jintro.utils.Input;

class FindMinMax {

	public static void main(String... args) {
		// read from stdin instead of command line arguments
		Input in = new Input();
		for (int i = 0; i < 3; i++) {
			int[] arr = createArray(in);
			int max = findMax(arr);
			int min = findMin(arr);
			System.out.format("Min = %d; Max = %d\n", min, max);
		}
		in.close();
	}

	public static int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int numbers : arr) {
			if (max < numbers) {
				max = numbers;
			}
		}
		return max;
	}

	public static int findMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int number : arr) {
			if (min > number) {
				min = number;
			}
		}
		return min;
	}

	public static int[] createArray(Input in) {
		System.out.print("N = ");
		int N = in.readInt();
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = in.readInt();
		}
		return numbers;
	}
}
