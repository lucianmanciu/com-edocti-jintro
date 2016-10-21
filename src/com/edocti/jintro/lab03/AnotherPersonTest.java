package com.edocti.jintro.lab03;

class AnotherPersonTest {
	public static void main(String[] args) {

		Person maria = new Person("Maria", "Dragomir", 30, false);

		System.out.println(maria);

		Person[] persons = {
				new Person("Ion", "Ionescu", 33, true),
				new Person("George", "Georgescu", 40, true),
				new Person("Ana", "Imbrescu", 35, false),
				new Person("Cucu", "Bau", true),
				maria
				};
		
		printArr(persons);
		
		anotherWay();
	}

	private static void anotherWay() {
		Person p1 = new Person("Ion", "Ionescu", 33, true);
		Person p2 = new Person("George", "Georgescu", 40, true);
		Person p3 = new Person("Ana", "Imbrescu", 35, false);
		Person p4 = new Person("Cucu", "Bau", true);

		Person[] persons = { p1, p2, p3, p4 };
		printArr(persons);
	}

	private static final void printArr(Object[] arr) {
		for (Object o : arr) {
			System.out.println(o.toString());
		}
		System.out.println();
	}
	
}
