package threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * 执行长期任务性能好，创建一个线程池，
 * 一池有N个固定的线程，有固定线程数的线程
 */
public class NewFixedThreadPll {


    public static void main(String[] args) {

        //new一个固定连接数的线程池
        ExecutorService es = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {

            es.execute(()->{

                System.out.println(Thread.currentThread().getName() + "号窗口为您服务~");

                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

            });
        }

        es.shutdown();//关闭线程池

    }


}
