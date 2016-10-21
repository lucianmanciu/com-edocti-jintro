package com.edocti.jintro.hw1;
import java.io.*;

/**
 * Write a program which reads a String from the standard input and verifies whether it is a palindrome.
 * Do the same thing with a number. Try to add Javadoc to your implementation.
 * @author manciul
 */
public class Palindrome {

	/**
	 * @param args not used
	 */
	public static void main(String[] args) {

		String s = getInput();
		boolean p;
		
		do {
			try {
				p = isPalindrome(Integer.parseInt(s));
			} catch(NumberFormatException ex) {
				p = isPalindrome(s);
			}
			
			if (p)
				System.out.println("It's a palindrome.");
			else
				System.out.println("Not a palindrome.");		
			
			System.out.println("Input nothing to exit.");
			s = getInput();
		} while(s.length() != 0);
	}
	
	/**
	 * Get standard input from user
	 * @return <code>string</code> containing user input, empty <code>string</code> if IOException is thrown
	 */
	private static String getInput() {
		
		String s = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Palindrome to be checked:");
		
		try {
			s = br.readLine();
		} catch (IOException e) {
			System.out.println("Reading user input failed: " + e.getMessage());
		}
		
		return s;
	}
	
	/**
	 * Check if given <code>string</code> is a palindrome
	 * @param s <code>string</code> to be checked
	 * @return <code>boolean true</code> if <code>s</code> is a palindrome, <code>false</code> otherwise
	 */
	private static boolean isPalindrome(String s) {
		
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			if (c[i] != c[c.length - 1 - i])
				return false;
		}
		
		return true;			
	}
	
	/**
	 * Check if given <code>int</code> is a palindrome
	 * @param x <code>int</code> to be checked
	 * @return <code>boolean true</code> if <code>x</code> is a palindrome, <code>false</code> otherwise
	 */
	private static boolean isPalindrome(int x) {
		
		x = Math.abs(x);
		int k = 1;
		
		while(x / k >= 10) {
			k *= 10;
		}
		
		while(x != 0) {
			int l = x / k;
			int r = x % 10;
			if (l != r) return false;
			x = (x % k) / 10;
			k /= 100;
		}
		
		return true;
	}
}
