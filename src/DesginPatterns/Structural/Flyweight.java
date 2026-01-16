package DesginPatterns.Structural;

import java.util.HashMap;
import java.util.Map;

interface Shape {
    void draw(int x, int y);
}

class Circle implements Shape {

    private String color; // intrinsic state

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) { // extrinsic state
        System.out.println("Drawing " + color + " circle at (" + x + ", " + y + ")");
    }
}

class ShapeFactory {

    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {

        Shape circle = circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating new " + color + " circle");
        }

        return circle;
    }
}


public class Flyweight {
    private static final String[] colors = {"Red", "Green", "Blue"};

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Shape circle = ShapeFactory.getCircle(colors[i % colors.length]);
            circle.draw(i * 10, i * 20);
        }
    }
}
