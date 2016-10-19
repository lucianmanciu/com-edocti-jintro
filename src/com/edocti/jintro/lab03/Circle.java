package com.edocti.jintro.lab03;

public final class Circle extends Shape {
    private int radius;
    
    public Circle(int x, int y, int radius) {
        super("Circle", x, y);
        this.radius = radius;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }
    
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", radius: " + radius;
    }
    
    @Override
    public boolean equals(Object o) {
        return false;
    }
}
