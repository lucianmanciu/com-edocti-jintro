package com.edocti.jintro.other;

public class TestEquality {

	public static void main (String[] args) {
		
		Person ionIonescu = new Person("Ion", "Ionescu", 30, false, false);
		Person ionGeorgescu = new Person("Ion", "Georgescu", 30, false, false);
		Person ionIonescu2 = new Person("Ion", "Ionescu", 40, false, false);
		
		System.out.println("IonIonescu equal to Ion Georgescu: " + ionIonescu.equals(ionGeorgescu));
		System.out.println("IonIonescu equal to itself: " + ionIonescu.equals(ionIonescu));

		System.out.println("Identical: " + (ionIonescu == ionGeorgescu));
		System.out.println("Identical to itself: " + (ionIonescu == ionIonescu));
		
		System.out.println("IonIonescu equal to IonIonescu2: " + ionIonescu.equals(ionIonescu2));
		System.out.println("IonIonescu identical to IonIonescu2: " + (ionIonescu == ionIonescu2));
		
		Person ionIonescuDup = ionIonescu;
		System.out.println("IonIonescu equal to IonIonescuDup: " + ionIonescu.equals(ionIonescuDup));
		System.out.println("IonIonescu identical to IonIonescuDup: " + (ionIonescu == ionIonescuDup));
		
		System.out.println(ionIonescu);
		ionIonescuDup.incrementAge();
		System.out.println(ionIonescu);
		
	}
}
