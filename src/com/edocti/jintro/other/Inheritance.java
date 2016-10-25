//package com.edocti.jintro.other;
//
//class A {
//	protected int a;
//	protected int b;
//	public void foo() { System.out.println("A.foo()"); }
//}
//
//
//class B extends A {
//	protected int c;
//	public void bar() { System.out.println("B.bar()"); }
//}
//
//
//public class Inheritance {
//	public static void main(String... args) {
//		A b = new B();  // declared type A, actual type B
//		b.a = 10;	  // all non-private members of A are inherited by B
//		b.b = 10;
//		// b.c = b.a + b.b;
//		b.foo();
//		// b.bar();
//	}
//}
