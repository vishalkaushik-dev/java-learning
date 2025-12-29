package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock sharedLock = new ReentrantLock();

        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();

        Thread th1 = new Thread(() -> {
            resource1.producer(sharedLock);
        });

        Thread th2 = new Thread(() -> {
            resource2.producer(sharedLock);
        });

        th1.start();
        th2.start();

    }
}
