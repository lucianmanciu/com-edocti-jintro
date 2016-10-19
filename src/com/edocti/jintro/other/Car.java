package com.edocti.jintro.other;

public class Car {

	protected float fuelLevel;
	protected int gear;
	protected int speed;
	protected String manufacturer;
	protected String model;
	protected String category;
	protected String vinNumber;
	protected String einNumber;
	
	public Car() {
		System.out.println("Car default constructor");
		vinNumber = "xxxxxxxxxxxxxxx";
		gear = 1;
		model = "default model";
		manufacturer = "manufacturer default";
	}

	public Car(String manufacturer, String model, String category) {
		this();  // we can call a constructor from another constructor
		System.out.format("Car members in this point: %s, %s, %s\n",
						  this.manufacturer, this.model, this.category);
		this.manufacturer = manufacturer;
		this.model = model;
		this.category = category;
		System.out.format("%s, %s, %s\n\n\n",
						  this.manufacturer, this.model, this.category);
	}
	
	public String toString() {
		return manufacturer + " " + model;
	}
}
