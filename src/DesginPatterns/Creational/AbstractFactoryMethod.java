package DesginPatterns.Creational;

interface Chair {
    void sitOn();
}

interface Sofa {
    void lieOn();
}

class ModernChair implements Chair {
    public void sitOn() {
        System.out.println("Sitting on Modern Chair");
    }
}

class ModernSofa implements Sofa {
    public void lieOn() {
        System.out.println("Lying on Modern Sofa");
    }
}

interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}

class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFurnitureFactory();
        Chair chair = factory.createChair();
        chair.sitOn();
        Sofa sofa = factory.createSofa();
        sofa.lieOn();

    }
}
