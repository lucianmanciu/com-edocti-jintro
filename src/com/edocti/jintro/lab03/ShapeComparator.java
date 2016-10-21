package com.edocti.jintro.lab03;

interface ShapeComparator {
	int compareTo(Shape s1, Shape s2);
}

class ShapeAreaComparator implements ShapeComparator {

	public int compareTo(Shape s1, Shape s2) {
		double a1 = s1.area();
		double a2 = s2.area();

		// could work also return (int) (a1 - a2); BUT: loss of precision
		if (a1 < a2) {
			return -1;
		} else if (a1 > a2) {
			return 1;
		} else {
			return 0;
		}
	}
}

class ShapeXYComparator implements ShapeComparator {
	public int compareTo(Shape s1, Shape s2) {
		return s1.x - s2.x;
	}
}

class ShapePerimeterComparator implements ShapeComparator {
	public int compareTo(Shape s1, Shape s2) {
		double p1 = s1.perimeter();
		double p2 = s2.perimeter();
		if (p1 < p2) {
			return -1;
		} else if (p1 > p2) {
			return 1;
		}
		return 0;
	}
}