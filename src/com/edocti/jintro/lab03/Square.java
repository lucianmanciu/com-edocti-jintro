package com.edocti.jintro.lab03;

public class Square extends Shape implements IShape {
	private int edge;

	public Square(int x, int y, int edge) {
		super("Square", x, y);
		this.edge = edge;
	}

	public double area() {
		return edge * edge;
	}

	public double perimeter() {
		return 4 * edge;  // same as edge << 2
	}

	@Override
	public String toString() {
		return super.toString() + ", edge: " + edge;
	}

	@Override
	public int hashCode() {
		return x * y * edge;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals called");  // make it visible when equals() is called
		Square another = (Square) obj;
		return this.x == another.x && y == another.y && edge == another.edge;
	}
}
