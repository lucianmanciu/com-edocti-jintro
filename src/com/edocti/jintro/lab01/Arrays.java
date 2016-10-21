package com.edocti.jintro.lab01;

/**
 * A first touch with arrays in Java
 * 
 * @author pianas
 */
public class Arrays {
	public static void main(String[] args) {
		String[] names = { "Ion", "Liviu", "Paul", "Alex" };
		
		// arrays allow us (among other things) to apply the same operation(s)
		// on multiple objects of the same type (or subtypes)
		// without them we would need to have ~tens of variables with different names
		// and apply the same operation(s) on each of them
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i].toUpperCase());
		}
	}
}
