package com.edocti.jintro.hw1;

/**
 * Write a program which reads 2 integer numbers from the standard input and allows the user to specify the operation to be performed on them.
 * Display the result of that operation to standard output.
 * @author manciul
 */
public class IntegerOperations {

	enum Operation {
		ADD, PROD, DIV, MOD;
	}
	/**
	 * @param args - 0 operand 1, 1 operand 2, 2 operation to perform 
	 */
	public static void main(String[] args) {
		validateArguments(args);
		int a = readInt(args[0]);
		int b = readInt(args[1]);
		Operation op = readOperation(args[2]) ;
		int result = Integer.MIN_VALUE;
		
		switch(op) {
		case ADD:
			result = a + b;
			break;
		case PROD:
			result = a * b;
			break;
		case DIV:
			result = divide(a, b);
			break;
		case MOD:
			result = modulo(a,b);
			break;
		}

		System.out.println("result = " + result);
	}
	
	/**
	 * Checks that string array <code>input</code> contains 3 strings.
	 * @param input - <code>string</code> array 
	 * @throws IllegalArgumentException If the <code>string</code> array is <code>null</code> or does not contain exactly 3 elements
	 *
	 */
	private static void validateArguments(String[] input) {
		if ((input == null) || (input.length != 3))
			throw new IllegalArgumentException("Invalid operand number: 3 are required");
	}
	
	/**
	 * Reads <code>int</code> from <code>string</code>.
	 * @param input <code>string</code> containing an integer value
	 * @return <code>int</code> value read from <code>string</code>
	 * @throws IllegalArgumentException if <code>input</code> is empty or not a valid <code>int</code>
	 */
	private static int readInt(String input) {
		if (isStringEmpty(input)) {
			throw new IllegalArgumentException("One operand is empty!");
		}
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Not a valid int literal: " + input);
		}
	}
	
	/**
	 * Checks if <code>string</code> is empty
	 * @param input <code>string</code>
	 * @return <code>true</code> if <code>string</code> is not <code>null</code> and longer than 0 and <code>false</code> otherwise
	 */
	private static boolean isStringEmpty(String input) {
		return (input == null || input.trim().length() == 0);
	}
	
	/**
	 * Read operation to be performed on operands 1 and 2 from <code>input</code> <code>string</code>
	 * @param input
	 * @return @link Operation enum value matching <code>input</code>
	 * @throws IllegalArgumentException if <code>input</code> is empty or there is no matching @link Operation implemented
	 */
	private static Operation readOperation(String input) {
		if (isStringEmpty(input)) {
			throw new IllegalArgumentException("Operation operand is empty!");
		}
		try {
			return Operation.valueOf(input.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Operation not implemented!\n\t" + e.getMessage());
		}
	}
	
	/**
	 * Divides param a by param b
	 * @param a operand to be divided
	 * @param b operand to be divided by
	 * @return <code>int</code> result of division
	 * @throws IllegalArgumentException if second operand is 0
	 */
	private static int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Invalid 2nd operand: division by 0!");
		}
		return a / b;
	}
	
	/**
	 * Calculates modulo of param a in base b
	 * @param a operand to calculate modulo of 
	 * @param b operand to calculate modulo in
	 * @return <code>int</code> result of modulo
	 * throws IllegalArgumentException if second operand is 0
	 */
	private static int modulo(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Modulo of 0 is undefined!");
		}
		boolean neg = (b < 0);
		a = Math.abs(a);
		b = Math.abs(b);
		
		while (a >= b)
			a-=b;
		if (neg)
			return 0 - a;
		else
			return a;
	}
}
