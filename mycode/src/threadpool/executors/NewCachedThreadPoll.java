package threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 执行很多短期异步任务，线程池根据需要创建新线程，
 * 但在先前构建的线程可用时将重用它们。可扩容，遇强则强
 */
public class NewCachedThreadPoll {

    public static void main(String[] args) {


        ExecutorService es = Executors.newCachedThreadPool();


        try {
            for (int i = 0; i < 100; i++) {

                es.execute(()->{

                    System.out.println(Thread.currentThread().getName() + "号窗口为您服务~");

                    try { TimeUnit.SECONDS.sleep(0); } catch (InterruptedException e) { e.printStackTrace(); }

                });

            }
        } finally {
            es.shutdown();
        }


    }


}
