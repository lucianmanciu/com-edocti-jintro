package com.edocti.jintro.utils;

/**
 * Simple utility class.
 * 
 * @author pianas
 */
public final class Utils {

	/**
	 * Verifies whether the given String is empty or not
	 *
	 * @param input		the String to be verified
	 * @return			true if @param input is null or made just of white spaces and false otherwise
	 */
	public static final boolean stringIsEmpty(String input) {
		return input == null || input.trim().length() == 0;
	}
	
	/**
	 * Prints the given arr one element on each line of stdout
	 *
	 * @param arr		the array to be prited
	 */
	public static final void printArr(Object[] arr) {
		for (Object o : arr) {
			System.out.println(o);
		}
		System.out.println();
	}
}
