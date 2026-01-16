package DesginPatterns.Creational;

// Prototype
interface Shape extends Cloneable {
    Shape clone();
}

// Concrete Prototype
class Circle implements Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public Shape clone() {
        return new Circle(this.radius);
    }
}


public class Prototype {
    public static void main(String[] args) {
        Circle original = new Circle(10);
        Shape copy = original.clone();
        System.out.println(original.radius);
        System.out.println(copy.toString());
    }
}
