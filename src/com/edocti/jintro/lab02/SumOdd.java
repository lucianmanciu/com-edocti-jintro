package com.edocti.jintro.lab02;

class SumOdd {

	public static void main(String[] args) {
		int[] a = FindMax.createArray();
		long sum = sumOfOddElements(a);
		System.out.format("Sum = %d\n", sum);
	}

	private static long sumOfOddElements(int[] b) {
		long sum = 0L;
		for (int elem : b) {
			System.out.format("elem= %d\n", elem);
			System.out.format("sum = %d\n\n", sum);
			if (elem % 2 == 1) {
				sum = sum + elem;
			}
		}
		return sum;
	}
}
