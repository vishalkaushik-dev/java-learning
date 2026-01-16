package DesginPatterns.Structural;

// Implementor Interface
interface Device {
    void turnOn();
}

// Concrete Implementors
class TV implements Device {
    public void turnOn() {
        System.out.println("TV is ON");
    }
}

class Radio implements Device {
    public void turnOn() {
        System.out.println("Radio is ON");
    }
}

// Abstraction
abstract class Remote {
    protected Device device;   // HAS-A (Bridge)

    public Remote(Device device) {
        this.device = device;
    }

    abstract void pressPower();
}

// Refined Abstraction
class BasicRemote extends Remote {

    public BasicRemote(Device device) {
        super(device);
    }

    public void pressPower() {
        device.turnOn();
    }
}


public class Bridge {
    public static void main(String[] args) {
        Remote tvRemote = new BasicRemote(new TV());
        tvRemote.pressPower();

        Remote radioRemote = new BasicRemote(new Radio());
        radioRemote.pressPower();
    }
}
