package com.edocti.jintro.lab03;

/**
 * An abstract class is something between a class and an interface:
 * <p>
 * It is a class which cannot be instantiated (like interfaces) but which has
 * some implementation (something which makes sense for your particular type
 * hierarchy).
 * 
 * @author pianas
 *
 */
public abstract class Shape {

	protected int x;
	protected int y;
	protected String name;

	public abstract double area();

	public abstract double perimeter();

	public Shape(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public final void setX(int x) {
		this.x = x;
	}

	public final int getX() {
		return x;
	}

	public final int getY() {
		return y;
	}

	// Use @Override in order for the compiler to tell you if
	// you have mistaken something in the method signature!

	@Override
	public String toString() {
		return name + ": " + x + ", " + y;
	}
}

/**
 * This is an interface example: same as Shape, but lacks implementation
 * 
 * In this case it has exactly the same methods as Shape, so it's not very
 * useful. It's just a didactic example. You can safely extend Shape and
 * implement IShape
 * 
 * @author pianas
 */
interface IShape {
	double area();

	double perimeter();
}
