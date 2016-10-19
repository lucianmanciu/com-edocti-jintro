package com.edocti.jintro.lab03;

//not necessary to write extends Object: just emphasizing
// that javac does it for us
class A extends java.lang.Object {
	protected int a;
	protected int b;

	public void foo() {
		System.out.println("A.foo()");
	}
}

class B extends A {
	protected int c;

	public void bar() {
		System.out.println("B.bar()");
	}

	@Override
	public void foo() {
		System.out.println("B.foo()");
	}

	@Override
	public String toString() { // java.lang.Object#toString()
		return "B " + c;
	}

	public B() {
		c = 10;
	}

	public static void main(String[] args) {
		A b = new B(); // declared type A, actual type B
		b.a = 10; // all non-private members of A are inherited by B
		b.b = 10;
		b.foo();
		((B) b).bar(); // possible, but discouraged; this is a cast
		System.out.println(b);
	}
}
