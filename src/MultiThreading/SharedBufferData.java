package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBufferData {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedBufferData(int bufferSize) {
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void generateData(int item) throws Exception {
        try {
            while(sharedBuffer.size() == bufferSize) {
                System.out.println("Buffer is full, waiting data to be consumed");
                wait();
            }
            sharedBuffer.add(item);
            System.out.println("Generated data: " + item);
            notify();
        } catch (Exception e) {
            //
        }
    }

    public synchronized int consumeData() {
        try{
            while(sharedBuffer.isEmpty()) {
                System.out.println("Buffer is empty, Consumer is waiting for producer");
                wait();
            }
            int item = sharedBuffer.poll();
            System.out.println("Consumed data : " + item);
            notify();
            return item;
        } catch(Exception e){
            //
            return -1;
        }
    }
}
