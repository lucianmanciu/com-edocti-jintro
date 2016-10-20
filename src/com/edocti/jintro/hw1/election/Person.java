package com.edocti.jintro.hw1.election;

/**
 * Represents one person and their info.
 * @author manciul
 */
public class Person {
	
	protected String name;
	protected String CNP;
	protected int age;
	
	Person(String n, String c, int a) {
		this.name = n;
		this.CNP = c;
		this.age = a;
	}
	
	/**
	 * Check if a person is an adult (over the voting age).
	 * @return <code>true</code> if the person's age is over {@link VOTING_AGE} and <code>false</code> otherwise.
	 */
	public boolean isAdult() {
		return (age >= Election.getVotingAge());
	}
	
	/**
	 * Display person info to standard output.
	 */
	public void display() {
		System.out.printf("Name: %24s\nAge: %3d\n", name, age);
	}
}