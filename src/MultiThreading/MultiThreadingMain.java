package MultiThreading;

public class MultiThreadingMain {
//    public static void main(String[] args) {
//        System.out.println("MultiThreadingMain started");
//        SharedResource sharedResource = new SharedResource();
//        Thread producerThread = new Thread(() -> {
//            System.out.println("Producer thread started");
//            sharedResource.addItem();
//        });
//
//        Thread consumerThread = new Thread(() -> {
//            System.out.println("Consumer thread started");
//            sharedResource.consumeItem();
//        });
//
//        producerThread.start();
//        consumerThread.start();
//
//        System.out.println("MultiThreadingMain finished");
//    }

    public static void main(String[] args) {
        SharedBufferData sharedBuffer = new SharedBufferData(3);

        // creating producer thread using lambda expression
        Thread producerThread = new Thread(() -> {
            try {
                for(int i=0;i<6;i++) {
                    sharedBuffer.generateData(i);
                }
            } catch (Exception e) {
                //
            }
        });

        // creating consumer thread using lambda expression
        Thread consumerThread = new Thread(() -> {
            try{
                for(int i=0;i<6;i++) {
                    sharedBuffer.consumeData();
                }
            } catch (Exception e) {
                //
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
