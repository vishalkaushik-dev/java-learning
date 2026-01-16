package DesginPatterns.Creational;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a Car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a Bike");
    }
}

class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("car"))
            return new Car();
        else if (type.equalsIgnoreCase("bike"))
            return new Bike();
        return null;
    }
}


public class FactoryMethod {
    public static void main(String[] args) {
        Vehicle v = VehicleFactory.getVehicle("car");
        v.drive();

    }
}
