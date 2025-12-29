package Classes;

public class Main {

    // ===============================
    // 1. Concrete Class
    // ===============================
    static class ConcreteClass {
        void show() {
            System.out.println("Concrete Class");
        }
    }

    // ===============================
    // 2. Abstract Class
    // ===============================
    static abstract class AbstractClass {
        abstract void run();
    }

    // ===============================
    // 3. Super Class
    // ===============================
    static class SuperClass {
        void display() {
            System.out.println("Super Class");
        }
    }

    // ===============================
    // 4. Sub Class
    // ===============================
    static class SubClass extends SuperClass {
        @Override
        void display() {
            System.out.println("Sub Class (overridden)");
        }
    }

    // ===============================
    // 5. Object Class Demo
    // ===============================
    static class ObjectClassDemo {
        // inherits methods from Object class
    }

    // ===============================
    // 6. Member Inner Class (Non-static)
    // ===============================
    class MemberInner {
        void msg() {
            System.out.println("Member Inner Class");
        }
    }

    // ===============================
    // 7. Static Nested Class
    // ===============================
    static class StaticNested {
        void msg() {
            System.out.println("Static Nested Class");
        }
    }

    // ===============================
    // 8. Local Inner Class
    // ===============================
    void localInnerDemo() {
        class LocalInner {
            void msg() {
                System.out.println("Local Inner Class");
            }
        }
        LocalInner li = new LocalInner();
        li.msg();
    }

    // ===============================
    // 9. Anonymous Inner Class
    // ===============================
    static abstract class Animal {
        abstract void sound();
    }

    // ===============================
    // 10. Generic Class
    // ===============================
    static class GenericClass<T> {
        T value;
        void set(T value) {
            this.value = value;
        }
        T get() {
            return value;
        }
    }

    // ===============================
    // 11. POJO Class
    // ===============================
    static class POJO {
        private int id;
        private String name;

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    // ===============================
    // 12. Enum Class
    // ===============================
    enum Day {
        MON, TUE, WED
    }

    // ===============================
    // 13. Final Class
    // ===============================
    static final class FinalClass {
        void show() {
            System.out.println("Final Class");
        }
    }

    // ===============================
    // 14. Singleton Class
    // ===============================
    static class Singleton {
        private static Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

    // ===============================
    // 15. Immutable Class
    // ===============================
    static final class ImmutableClass {
        private final int value;

        ImmutableClass(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }

    // ===============================
    // 16. Wrapper Class Demo
    // ===============================
    static class WrapperDemo {
        void test() {
            Integer i = 10; // wrapper
            int j = i;      // unboxing
            System.out.println("Wrapper: " + j);
        }
    }

    // ===============================
    // MAIN METHOD (Execution)
    // ===============================
    public static void main(String[] args) {

        // Concrete class
        ConcreteClass cc = new ConcreteClass();
        cc.show();

        // Abstract class
        AbstractClass ac = new AbstractClass() {
            void run() {
                System.out.println("Abstract Class Implementation");
            }
        };
        ac.run();

        // Super & Sub class (polymorphism)
        SuperClass sc = new SubClass();
        sc.display();

        // Object class
        ObjectClassDemo obj = new ObjectClassDemo();
        System.out.println(obj.toString());

        // Member Inner Class (Non-static)
        Main outer = new Main();
        Main.MemberInner mi = outer.new MemberInner();
        mi.msg();

        // Static Nested Class
        StaticNested sn = new StaticNested();
        sn.msg();

        // Local Inner Class
        outer.localInnerDemo();

        // Anonymous Inner Class
        Animal a = new Animal() {
            void sound() {
                System.out.println("Anonymous Inner Class");
            }
        };
        a.sound();

        // Generic Class
        GenericClass<String> gc = new GenericClass<>();
        gc.set("Generic Class");
        System.out.println(gc.get());

        // POJO Class
        POJO p = new POJO();
        p.setId(1);
        p.setName("POJO");
        System.out.println(p.getId() + " " + p.getName());

        // Enum
        Day d = Day.MON;
        System.out.println(d);

        // Final Class
        FinalClass fc = new FinalClass();
        fc.show();

        // Singleton Class
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); // true

        // Immutable Class
        ImmutableClass im = new ImmutableClass(100);
        System.out.println(im.getValue());

        // Wrapper Class
        WrapperDemo wd = new WrapperDemo();
        wd.test();
    }
}

