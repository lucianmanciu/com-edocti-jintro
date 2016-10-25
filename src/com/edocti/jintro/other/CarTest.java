//package com.edocti.jintro.other;
//
//public class CarTest {
//	public static void main (String[] args) {
//		
//		// we use the new operator to instantiate (create instances)
//		// cars[0] is a reference to an object of type Car
//		// cars[2] is a reference to an object of type Truck
//		Car[] cars = new Car[7];
//		cars[0] = new Car();
//		cars[1] = new Car("Audi", "A4", "autoturism");
//		cars[2] = new Truck();
//
//		cars[3] = new SportsCar("Subaru", "WRX", true, true, true);
//		cars[4] = new SportsCar("Maserati", "Cucu", true, true, true);
//		cars[5] = new SportsCar("Subaru", "WRX", true, true, true);
//		cars[6] = new SportsCar("Maserati", "Cucu", true, true, true);
//		
//		for (Car car : cars) {
//			System.out.println(car);  // toString() is called automatically
//		}
//		
//		findDuplicates(cars);
//	}
//	
//	private static void findDuplicates(Car[] cars) {
//		System.out.println("\n\nFinding duplicates...");
//		boolean duplicatesFound = false;
//		for (int i = 0; i < cars.length - 1; i++) {
//			for (int j = i + 1; j < cars.length; j++) {
//				if (cars[i] instanceof SportsCar && cars[j] instanceof SportsCar) {
//					SportsCar sportsCar1 = (SportsCar) cars[i];
//					SportsCar sportsCar2 = (SportsCar) cars[j];
//					if (sportsCar1.equals(sportsCar2)) {
//						System.out.println("Found duplicates:\n" + cars[i]);
//						duplicatesFound = true;
//					}
//				} else if (cars[i].equals(cars[j])) {
//						System.out.println("Found duplicates:\n" + cars[i]);
//						duplicatesFound = true;
//				}
//			}
//		}
//
//		if (!duplicatesFound) {
//			System.out.println("No duplicates found!");
//		}
//	}
//}
