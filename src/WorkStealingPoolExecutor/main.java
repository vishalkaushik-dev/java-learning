package WorkStealingPoolExecutor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class main {
    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> futureObj = pool.submit(new ComputeSumTask(0,10));
        try{
            System.out.println(futureObj.get());
        } catch(Exception e) {
            //
        }
    }
}

class ComputeSumTask extends RecursiveTask<Integer> {

    int start;
    int end;

    public ComputeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if(end - start <= 4){
            int totalSum = 0;
            for(int i = start;i<=end;i++) {
                totalSum += i;
            }
            return totalSum;
        } else {
            int middle = (start + end) / 2;

            ComputeSumTask leftTask = new ComputeSumTask(start, middle);
            ComputeSumTask rightTask = new ComputeSumTask(middle + 1, end);

            // fork the subtasks for the parallel execution
            leftTask.fork();
            rightTask.fork();

            // combine the result of subtasks
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            return leftResult + rightResult;
        }
    }
}
