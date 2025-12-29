package StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock stampedLock = new StampedLock();

    public void producer() {
        long stamp = stampedLock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic lock");
            a = 11;
            Thread.sleep(6000);
            if(stampedLock.validate(stamp)) {
                System.out.println("Update a value successfully");
            } else {
                System.out.println("Rollback the changes");
                a = 10; // rollback the changes
            }
        } catch (Exception e) {
            //
        }
    }

    public void consumer() {
        long stamp = stampedLock.writeLock();
        System.out.println("Write lock acquired by " + Thread.currentThread().getName());
        try {
            System.out.println("Performing work");
            a = 9;
        } catch (Exception e) {
            //
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }
}
