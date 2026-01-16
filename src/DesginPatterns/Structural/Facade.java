package DesginPatterns.Structural;

//sub-system classes
class CPU {
    void start() {
        System.out.println("CPU started");
    }
}

class Memory {
    void load() {
        System.out.println("Memory loaded");
    }
}

class HardDrive {
    void read() {
        System.out.println("Hard drive reading data");
    }
}

// Facade Class
class ComputerFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer started successfully");
    }
}


public class Facade {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}
