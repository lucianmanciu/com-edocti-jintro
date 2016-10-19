package com.edocti.jintro.lab03;

import com.edocti.jintro.utils.Input;
import com.edocti.jintro.utils.Utils;

/**
 * Simple test class for Person Allows you to create a number of Persons and
 * read their properties from the standard input (keyboard)
 * 
 * @author pianas
 *
 */
public class PersonManagement {

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage");
			System.out.println("java PersonManagement nr_persons");
			System.exit(1);
		}
		int N = 0;
		try {
			N = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.err.println("Not a whole number: " + e.getMessage());
			System.exit(2);
		}
		Person[] persons = new Person[N];

		// in this point the array contains only null references
		// we said that the array contains *references* to objects
		// and not the objects themselves. references are sort of memory
		// addresses
		// null means memory address 0. It's a special reference value
		Utils.printArr(persons);

		Input in = new Input();

		for (int i = 0; i < N; i++) {
			System.out.print("First name: ");
			String firstName = in.readLine();
			System.out.print("Last name: ");
			String lastName = in.readLine();
			System.out.print("Sex: ");
			boolean sex = in.readLine().equalsIgnoreCase("M") ? false : true;
			System.out.print("Age: ");
			int age = in.readInt();
			// this is only for consuming the "enter" we press after introducing
			// the age
			in.readLine();
			persons[i] = new Person(firstName, lastName, age, sex);
		}

		for (int i = 0; i < N - 1; i++) {
			Person p1 = persons[i];
			Person p2 = persons[i + 1];
			if (p1.equals(p2)) {
				System.out.println(p1);
			}
		}

		in.close();

		// now the array contains references to *objects of type Person*
		// the constructor has the role of initializing the object
		// (by assigning values to members)
		// when we call "new" 2 things happen:
		// 1. JVM allocates memory for the object (in the HEAP memory area)
		// 2. the constructor is called => the object is initialized
		// there are multiple types of constructors (we'll see later)
		Utils.printArr(persons);
	}

}
