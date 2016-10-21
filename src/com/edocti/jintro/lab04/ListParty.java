package com.edocti.jintro.lab04;

import com.edocti.jintro.lab03.*;
import java.util.*;

class ListParty {
	public static void main(String[] args) {
		oldWay();
		genericWay();
		testArray2D();
		List<Shape> l = generateList(10);
		displayList(l);
		l.remove(new Square(10, 10, 10));
		displayList(l);
	}

	private static void displayList(List<?> l) {
		System.out.println(l);
	}

	private static List<Shape> generateList(int n) {
		Shape[] shapes = { new Circle(10, 10, 10), new Square(10, 10, 10), new Circle(20, 20, 20),
				new Circle(30, 30, 30) };
		List<Shape> l = new ArrayList<Shape>(n);
		while (n-- > 0) {
			int randomIdx = (int) (Math.random() * 1_000_000) % shapes.length;
			l.add(shapes[randomIdx]);
		}
		return l;
	}

	private static void testArray2D() {
		List<List<String>> l = new ArrayList<List<String>>();
		l.add(new ArrayList<String>());
		l.get(0).add("Ion");
		l.get(0).add("George");

		Vector<String> v = new Vector<String>();
		v.add("Cucu");
		v.add("Bau");
		l.add(v);

		for (List<String> e : l) {
			for (String t : e) {
				System.out.print(t + "      ");
			}
			System.out.println();
			System.out.println(e);
		}
	}

	private static void genericWay() {
		List<String> l = new ArrayList<String>();
		l.add("Ion");
		l.add("Maria");
		// if uncommented => compilation error
		// l.add(new Circle(10, 10, 20));
		iterateOuter(l);

		List<Shape> l2 = new ArrayList<Shape>();
		l2.add(new Circle(10, 10, 20));
		l2.add(new Square(10, 10, 40));
		iterateOuter(l2);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })  // suppress compiler warning about old / unsafe list operations
	private static void oldWay() {
		List l = new ArrayList();
		l.add("Ana");
		l.add("are");
		l.add("mere");

		l.add(new Circle(10, 10, 20));
		l.add(new Circle(10, 10, 30));

		iterateOuter(l);
		iterate(l);
	}

	@SuppressWarnings("rawtypes")
	private static void iterate(List l) {
		System.out.println("=======");
		Iterator it = l.iterator();
		while (it.hasNext()) {
			try {
				Shape s = (Shape) it.next();
				System.out.println("Shape area: " + s.area());
			} catch (ClassCastException e) {
				System.out.println(it.next());
			}
		}
		System.out.println("=======");
	}

	@SuppressWarnings("rawtypes")
	private static void iterateOuter(List l) {
		System.out.println("=======");
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		System.out.println("=======");
	}
}
