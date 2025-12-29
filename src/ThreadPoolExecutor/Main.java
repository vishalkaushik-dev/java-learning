package ThreadPoolExecutor;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10), new CustomThreadFactory(), new CustomRejectedHandler());

        poolExecutor.allowCoreThreadTimeOut(true);

        //submit tasks
        for(int i=0;i<25;i++) {
            poolExecutor.submit(() -> {
                try{
                    Thread.sleep(5000);
                    System.out.println("Thread name : " + Thread.currentThread().getName());
                } catch(Exception e) {
                    // handle exception
                }
            });
        }
        poolExecutor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        return th;
    }
}

class CustomRejectedHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // logging
        System.out.println("Task denied: " + r.toString());
    }
}
