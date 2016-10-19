package com.edocti.jintro.other;

import java.util.*;
import java.text.*;

/**
 * This class shows the most important data structures for
 * dealing with time in Java
 *
 * @author pianas
 */
class DateDemo {
	public static void main(String... args) {

		// Simple date operations: date, formats
		Date now = new Date();
		String format1 = String.format("Right now is %tc", now);
		System.out.printf("%s\n", format1);

		DateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
		String format2 = fmt.format(now);
		System.out.format("Today is %s\n", format2);
		
		// Measuring time
		System.out.println("Measuring time...");
		long start = System.currentTimeMillis();
		try{ Thread.sleep(100); } catch (InterruptedException e) {}
		long elapsed = System.currentTimeMillis() - start;
		System.out.printf("Elapsed: %d\n", elapsed);

		// Create a Date from a string
		Date date = null;
		String dateStr = "11.10.2016";
		System.out.format("Trying to understand \"%s\" as date (dd.MM.yyyy): \n", dateStr);
		try {
			date = fmt.parse(dateStr);
		} catch(ParseException e) {
			System.err.format("The given date (%s) is not valid\n", dateStr);
		}
		if (date != null) {
			DateFormat fmt2 = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("The date (MM/dd/yyyy) is: " + fmt2.format(date));
		}
	}
}
