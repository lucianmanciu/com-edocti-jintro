package com.edocti.jintro.lab09;

import java.util.concurrent.atomic.AtomicInteger;

public class Param {

	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger(100);
		changeVal(a);
		System.out.println(a);
		
		Integer b = new Integer(25);
		changeVal(b);
		System.out.println(b);
	}
	
	public static void changeVal(int a) {
		a = 50;
	}
	
	public static void changeVal(AtomicInteger a) {
		a.incrementAndGet();
	}

}
