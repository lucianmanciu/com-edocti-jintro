package com.edocti.jintro.other;

public class Truck extends Car {

	protected final int maxLoad;
	
	// this is how we can define constants in Java
	// note that this field is static and final
	// final means it cannot be modified once we assign a value to it
	// static means it can be referenced by Truck.MIN_LOAD (no instance needed)
	public static final int MIN_LOAD = 1000;
	
	public Truck() {
		System.out.println("Truck default constructor");
		maxLoad = MIN_LOAD;
	}
	
	public Truck(int maxLoad) {
		this.maxLoad = maxLoad;
	}
	
	// we saw we will inherit toString() from the superclass
	// but there are means to make a method more specific: by overriding
	// here Car's toString() is overridden
	public String toString() {
		return "Truck: " + manufacturer + " " + model + " " + maxLoad;
	}
}
