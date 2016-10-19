package com.edocti.jintro.lab03;

class Person {
	private String firstName;
	private String lastName;
	@SuppressWarnings("unused")
	private String cnp;
	private int age;
	private boolean sex; // true => M, false => F

	private static int MAX_AGE = 100;

	// constructor
	public Person(String fn, String lastName, int age, boolean sex) {
		this.firstName = fn;
		this.lastName = lastName;
		this.age = age;
		this.sex = sex;
		cnp = "";
	}

	public Person(String firstName, String lastName, boolean sex) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		age = 0; // optional: age is anyway initialized to default int value (0)
	}

	public String toString() { // exists in java.lang.Object
		return this.firstName + ", " + this.lastName + ", age: " + this.age + ", max age: " + MAX_AGE;
	}

	// we can access only static members from a static context
	// static members belong to the class and live as long as the application lives
	// instance members only live as much as the object lives
	// object lives as much as its context: a for loop, a method, etc.
	public static int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		try {
			Person p = (Person) o;
			return firstName.equalsIgnoreCase(p.firstName) &&
					lastName.equalsIgnoreCase(p.lastName) &&
					sex == p.sex &&
					age == p.age;
		} catch (ClassCastException e) {
			return false;
		}
	}
}
