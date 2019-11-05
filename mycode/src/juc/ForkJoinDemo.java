package juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并框架
 *
 * Fork：把一个复杂任务进行分拆，大事化小
 * Join：把分拆任务的结果进行合并
 */
class ForkJoinDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyTask mt = new MyTask(0,100);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask forkJoinTask = forkJoinPool.submit(mt);

        System.out.println(forkJoinTask.get());

    }

}

class MyTask extends RecursiveTask<Integer>{

    public static final int ADJEST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if(end - begin <= ADJEST_VALUE){

            for (int i = begin; i <= end; i++) {
                result = result + i;
            }

        }else {

            int mid = (begin + end)/2;

            MyTask mt1 = new MyTask(begin,mid);
            MyTask mt2 = new MyTask(mid+1,end);

            mt1.fork();
            mt2.fork();

            result = mt1.join() + mt2.join();
        }

        return result;
    }





}