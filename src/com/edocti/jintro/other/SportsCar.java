//package com.edocti.jintro.other;
//
//public class SportsCar extends Car {
//	protected boolean sportsSuspensionOn;
//	
//	protected boolean automaticGearBox;
//	
//	protected boolean doubleExhaustion;
//	
//	public static final String CATEGORY = "Sports Car";
//	
//	public SportsCar(String manufacturer, String model,
//		boolean sportsSuspensionOn, boolean automaticGearBox, boolean doubleExhaustion) {
//		
//		super(manufacturer, model, CATEGORY);
//
//		this.sportsSuspensionOn = sportsSuspensionOn;
//		this.automaticGearBox = automaticGearBox;
//		this.doubleExhaustion = doubleExhaustion;
//	}
//	
//	
//	public String toString() {
//		String inherited = super.toString();
//		return inherited + "; sportsSuspensionOn: " + sportsSuspensionOn + 
//			"; Automatic Gearbox: " + automaticGearBox + 
//			"; Double exhaust: " + doubleExhaustion;
//	}
//	
//	
//	public boolean equals(Car x) {
//		return  x != null &&
//				this.manufacturer.equalsIgnoreCase(x.manufacturer) &&
//				this.model.equalsIgnoreCase(x.model) &&
//				this.category.equalsIgnoreCase(x.category);
//	}
//}
