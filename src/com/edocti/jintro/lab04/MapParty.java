package com.edocti.jintro.lab04;

import com.edocti.jintro.lab03.*;
import java.util.*;

class MapParty {

    public static void main(String[] args) {
        Map<Shape, Integer> map = generateMap(10);
        System.out.println(map);
        System.out.println(map.size());
        
        Shape key = new Square(10, 10, 10);
        Integer value1 = map.get(key);
        if (value1 == null) {
            System.out.println("Not found");
        } else {
            System.out.printf("map[%s] = %d\n", key, value1);
        }
    }

    private static Map<Shape, Integer> generateMap(int n) {
        Shape[] shapes = {
            new Circle(10, 10, 10), new Square(10, 10, 10),
            new Circle(20, 20, 20), new Circle(30, 30, 30),
            new Square(100, 100, 100)
        };
        
        Map<Shape, Integer> map = new HashMap<Shape, Integer>();
        while (n-- > 0) {
            int idx = (int) (Math.random() * 1_000_000) % shapes.length;
            int value = (int) (Math.random() * 100);
            map.put(shapes[idx], value);
        }
        
        return map;
    }

}