package SemaphoreLock;

import StampedLock.SharedResource;

public class Main {
    public static void main(String[] args) {
        StampedLock.SharedResource resource = new SharedResource();

        Thread th1 = new Thread(resource::producer); // this line is same as below but written with method reference way
        Thread th2 = new Thread(() -> {
            resource.consumer();
        });
        Thread th3 = new Thread(resource::producer);
        Thread th4 = new Thread(resource::producer);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
