package com.edocti.jintro.lab02;

import com.edocti.jintro.utils.Input;

class FindMax {

	public static void main(String[] args) {
		int[] arr = createArray();
		int max = findMax(arr);
		System.out.println("max = " + max);
	}

	public static int findMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int elem : arr) {
			if (max < elem) {
				max = elem;
			}
		}
		return max;
	}

	public static int[] createArray() {
		System.out.print("N = ");
		Input in = new Input();
		int N = in.readInt();
		int[] arr = new int[N];

		// now we read N integers and add them to the array
		int i = 0;
		while (i < N) {
			arr[i++] = in.readInt();
		}
		// same as
		// for (int i = 0; i < N; i++) {...}
		in.close();
		return arr;
	}
}
