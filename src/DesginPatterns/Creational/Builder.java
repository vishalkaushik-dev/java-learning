package DesginPatterns.Creational;

// Product
class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        Computer build() {
            return new Computer(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        Computer pc = new Computer.Builder()
                .setCpu("Intel i7")
                .setRam("16GB")
                .setStorage("1TB SSD")
                .build();

        System.out.println(pc);

    }
}
