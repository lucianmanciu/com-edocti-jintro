package com.edocti.jintro.lab02;

class Median {
	public static void main(String[] args) {
		// we can call a method from another class
		int[] a = FindMax.createArray();
		double median = calculateMedian(a);
		System.out.format("Median = %.20f\n", median);
	}

	public static double calculateMedian(int[] a) {
		if (a == null || a.length == 0) {
			return 0.0;
		}

		long sum = 0L;
		for (int elem : a) {
			sum += elem;
		}

		return sum / (double) a.length;
	}
}
