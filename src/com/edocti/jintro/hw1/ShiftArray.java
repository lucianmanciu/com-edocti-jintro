package com.edocti.jintro.hw1;

/**
 * Given an array of strings, implement a method which rotates the array n positions to the left.
 * @author manciul
 */
public class ShiftArray {
	
	/**
	 * @param args <code>string</code> array containing <code>int</code> value to shift array by
	 */
	public static void main(String[] args) {
		
		int n;
		String[] a = {"1", "2", "3", "4", "5", "6", "7", "8"};
		
		if (args != null && args.length == 1)
			n = Integer.parseInt(args[0]);
		else
			n = 3;
		
		System.out.println("Original array:");
		displayArr(a);
		
		System.out.printf("Shifting array by %d to the right.\n", n);
		shift(a, n, "right");
		displayArr(a);
		
		System.out.printf("Shifting array by %d to the left.\n", n);
		shift(a, n, "left");
		displayArr(a);
		
	}
	
	/**
	 * Display array of <code>strings</code>.
	 * @param a array of <code>strings</code> to be displayed
	 * @throws IllegalArgumentException if a is <code>null</code>
	 */
	private static void displayArr(String[] a) {
		
		if (a == null)
			throw new IllegalArgumentException("Illegal argument");
		
		for (String s : a) {
			System.out.printf("%s ", s);
		}
		System.out.println();
	}
	
	/**
	 * Shift <code>string</code> array a by n positions in the given direction
	 * @param a array of <code>strings</code> to be shifted
	 * @param n number of positions to shift array by
	 * @param direction direction in which to shift the array
	 * @throws IllegalArgumentException if a is <code>null</code>, a is of length 0, n is smaller than 0 or direction is different than either 'left' or 'right'
	 */
	private static void shift(String[] a, int n, String direction) {
		
		if ((a == null) || (a.length == 0) || (n < 0) || ((direction != "left") && (direction != "right")))
			throw new IllegalArgumentException("Illegal argument");
		
		n = n % a.length;
		
		if (direction == "left")
			n = a.length - n;
		
		reverse(a, 0, a.length - 1 - n);
		reverse(a, a.length - n, a.length - 1);
		reverse(a, 0, a.length - 1);
	}
	
	/**
	 * Reverse a given <code>string<code> array so that its elements are in reverse order.
	 * @param a <code>string</code> array to be reversed
	 * @param left position of first element to be reversed
	 * @param right position of last element to be reversed
	 * @throws IllegalArgumentException if a is <code>null</code>, or if either left or right are out of bounds of the given array
	 */
	private static void reverse(String[] a, int left, int right) {
		
		if ((a == null) || (left < 0) || (right > a.length))
			throw new IllegalArgumentException("Illegal argument");
		
		while (left < right) {
			String tmp = a[left];
			a[left] = a[right];
			a[right] = tmp;
			left++;
			right--;
		}
		
	}
}
