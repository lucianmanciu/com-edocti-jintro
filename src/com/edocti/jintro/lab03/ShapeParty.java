package com.edocti.jintro.lab03;

import java.util.Comparator;
import java.util.Arrays;

class AreaComparator implements Comparator<Shape> {

	public int compare(Shape s1, Shape s2) {
		return new ShapeAreaComparator().compareTo(s1, s2);
	}
}

class ShapeParty {
	public static void main(String[] args) {
		Shape[] shapes = generateShapes(10);
		displayArr(shapes);

		ShapeComparator c1 = new ShapeAreaComparator();
		ShapeComparator c2 = new ShapeXYComparator();

		Comparator<Shape> c3 = new AreaComparator();
		Arrays.sort(shapes, c3);
		displayArr(shapes);

		sort(shapes, c1);
		displayArr(shapes);

		sort(shapes, c2);
		displayArr(shapes);
	}

	private static final void displayArr(Shape[] a) {
		for (Shape s : a) {
			System.out.println(s); // equivalent with ...println(s.toString())
		}
		System.out.println();
	}

	public static void sort(Shape[] a, ShapeComparator c) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0 && c.compareTo(a[j], a[j - 1]) < 0; j--) {
				swap(a, j, j - 1);
			}
		}
	}

	private static void swap(Shape[] a, int i, int j) {
		Shape tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static Shape[] generateShapes(int N) {
		Shape[] arr = new Shape[N];
		for (int i = 0; i < N; i++) {
			// Math.random() returns double between [0, 1)
			// 2 * Math.random() gives number between [0,2); we cast this =>
			// int: 0 or 1
			int type = (int) (2 * Math.random());
			int x = (int) (100 * Math.random());
			int y = (int) (100 * Math.random());
			switch (type) {
			case 0: // Circle
				int radius = 1 + (int) (29 * Math.random());
				arr[i] = new Circle(x, y, radius);
				break;
			case 1: // Square
				int edge = 1 + (int) (50 * Math.random());
				arr[i] = new Square(x, y, edge);
				break;
			default:
				arr[i] = null;
			}
		}

		return arr;
	}
}
