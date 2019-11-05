package threadpool.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 一个任务一个任务的执行，一池一线程
 */
public class NewSingleThreadExecutor {


    public static void main(String[] args) {


        ExecutorService exe = Executors.newSingleThreadExecutor();


        for (int i = 0; i < 5; i++) {


            exe.execute(()->{

                System.out.println(Thread.currentThread().getName() + "号窗口为您服务~");

                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

            });

        }

        exe.shutdown();



    }





}
