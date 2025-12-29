package MultiThreading;

public class SharedResource {

    boolean isItemAvailable = false;

    public synchronized void addItem() {
        isItemAvailable = true;
        try{
            Thread.sleep(5000l);
        } catch(Exception e) {
            // handle exception
        }
        System.out.println("Adding " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consuming " + Thread.currentThread().getName());

        while(!isItemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " waiting");
                wait();
            } catch(Exception e) {
                // handle Exception here
            }
        }

        System.out.println("Item consumed by " + Thread.currentThread().getName());
        isItemAvailable = false;
    }
}
