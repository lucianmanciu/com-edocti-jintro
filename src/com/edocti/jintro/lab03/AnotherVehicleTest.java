package com.edocti.jintro.lab03;

class Vehicle extends Object {
	protected String manufacturer;
	protected String model;
	protected String subtype;

	public Vehicle() {
		super(); // optional: compiler inserts it anyway
	}

	public Vehicle(String manufacturer, String model, String subtype) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.subtype = subtype;
	}

	@Override
	public String toString() {
		return model + ", " + subtype;
	}
}

class Car extends Vehicle {
	protected int wheels;
	protected int seats;
	protected int gears;

	public Car(String manufacturer, String model, String subtype,
			int wheels, int seats, int gears) {
		super(manufacturer, model, subtype);
		// super(); - if not explicitly inserted, compiler will insert super()
		// on the first line
		// this.manufacturer = manufacturer;
		// this.model = model;
		// this.subtype = subtype;

		this.wheels = wheels;
		this.seats = seats;
		this.gears = gears;
	}

	@Override
	public String toString() {
		// return model + ", " + subtype + ", " + wheels + ", " + seats;
		return super.toString() + wheels + ", " + seats;
	}
}

class Test {
	public static void main(String... args) {
		Vehicle tm09adr = new Car("GM", "Mercedes", "C220", 4, 5, 6);
		System.out.println(tm09adr);
	}
}
