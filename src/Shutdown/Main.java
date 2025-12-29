package Shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService poolExecutorObj = Executors.newFixedThreadPool(5);
        poolExecutorObj.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                //
            }
            System.out.println("New task");
        });

        poolExecutorObj.shutdown();
        try {
            boolean isExecutorTerminated = poolExecutorObj.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("Main thread, isExecutorTerminated: " + isExecutorTerminated);
        } catch (Exception e) {
            //
        }
//        poolExecutorObj.submit(() -> {
//            System.out.println("New task after shutdown");
//        });
        System.out.println("Main thread unblocked and finished processing");
    }
}
