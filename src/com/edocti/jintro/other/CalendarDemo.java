package com.edocti.jintro.other;

import java.util.*;
public class CalendarDemo {
	public static void main(String args[]) {
		String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
                           "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

		GregorianCalendar cal = new GregorianCalendar(); // points to current date

		System.out.format("Date: %d %s %d\n",
				cal.get(Calendar.DATE),
				months[cal.get(Calendar.MONTH)],
				cal.get(Calendar.YEAR));

		System.out.format("Time: %02d:%02d:%02d\n",
				cal.get(Calendar.HOUR),
				cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND));


		if (cal.isLeapYear(cal.get(Calendar.YEAR))) {
			System.out.println("The current year is a leap year");
		} else {
			System.out.println("The current year is not a leap year");
		}
	}
}
