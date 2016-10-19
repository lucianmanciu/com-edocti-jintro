package com.edocti.jintro.lab02;

/**
 * Simple class meant to show how a search in an unsorted array takes place.
 * 
 * <p>
 * Other operations with arrays follow a similar pattern.
 * </p>
 *
 * @author pianas
 */
class Find {

	public static void main(String... args) {
		int N = Integer.parseInt(args[0]);
		int value = Integer.parseInt(args[1]);

		// 1. generate an array
		int[] elements = new int[N];
		printArr(elements); // see how the array is initialized

		for (int i = 0; i < N; i++)
			elements[i] = i * i;

		printArr(elements); // see the array after we populate it

		// 2. find value in the array
		// note that we have a variable which "lives" outside the for loop
		// this is our result; the result can be found only after we
		// iterate through the array
		int index = -1;
		for (int i = 0; i < N; i++) {
			if (elements[i] == value) {
				index = i;
				break;
			}
		}

		// now we display the index which contains the element
		System.out.println(index);
	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
