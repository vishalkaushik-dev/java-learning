package DesginPatterns.Structural;

// Component Interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }
    public double cost() {
        return 50;
    }
}

// Decorator (IS-A + HAS-A)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;   // HAS-A relationship

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double cost() {
        return coffee.cost() + 10;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    public double cost() {
        return coffee.cost() + 5;
    }
}

// Client Code
public class Decorator {
    public static void main(String[] args) {
        Coffee coffee =
                new SugarDecorator(
                        new MilkDecorator(
                                new SimpleCoffee()
                        )
                );

        System.out.println(coffee.getDescription());
        System.out.println(coffee.cost());
    }
}
