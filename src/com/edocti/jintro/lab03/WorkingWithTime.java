package com.edocti.jintro.lab03;

import java.util.*;
import java.text.*;

/**
 * Simple class which shows the most important data structures and methods for
 * dealing with time in Java. Convert Date to / from String and vice-versa,
 * working with GregorianCalendar, etc.
 * 
 * @author pianas
 */
class WorkingWithTime {

	private static void dateDemo() {
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
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		long elapsed = System.currentTimeMillis() - start;
		System.out.printf("Elapsed: %d\n", elapsed);

		// Create a Date from a string
		Date date = null;
		String dateStr = "11.10.2016";
		System.out.format("Trying to understand \"%s\" as date (dd.MM.yyyy): \n", dateStr);
		try {
			date = fmt.parse(dateStr);
		} catch (ParseException e) {
			System.err.format("The given date (%s) is not valid\n", dateStr);
		}
		if (date != null) {
			DateFormat fmt2 = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("The date (MM/dd/yyyy) is: " + fmt2.format(date));
		}
	}

	private static void calendarDemo() {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		GregorianCalendar cal = new GregorianCalendar(); // points to current
															// date

		System.out.format("Date: %d %s %d\n", cal.get(Calendar.DATE), months[cal.get(Calendar.MONTH)],
				cal.get(Calendar.YEAR));

		System.out.format("Time: %02d:%02d:%02d\n", cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND));

		if (cal.isLeapYear(cal.get(Calendar.YEAR))) {
			System.out.println("The current year is a leap year");
		} else {
			System.out.println("The current year is not a leap year");
		}
	}

	public static void main(String args[]) {
		dateDemo();
		calendarDemo();
	}
}
