package com.edocti.jintro.utils;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Convenient class for reading from stdin.
 *
 * @author pianas
 * @see java.util.Scanner
 */
public class Input {
	private static final String CHARSET_NAME = "UTF-8";

	// the default token separator
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

	private static final Pattern EMPTY_PATTERN = Pattern.compile("");

	private Scanner scanner;

	public Input() {
		scanner = new Scanner(new BufferedInputStream(System.in), CHARSET_NAME);
		scanner.useLocale(Locale.US);
	}

	public byte readByte() {
		return scanner.nextByte();
	}

	public short readShort() {
		return scanner.nextShort();
	}

	public int readInt() {
		return scanner.nextInt();
	}

	public long readLong() {
		return scanner.nextLong();
	}

	public char readChar() {
		scanner.useDelimiter(EMPTY_PATTERN);
		String ch = scanner.next();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return ch.charAt(0);
	}

	public String readLine() {
		return scanner.nextLine();
	}

	public boolean isEmpty() {
		return !scanner.hasNext();
	}

	public void close() {
		scanner.close();
	}
}
