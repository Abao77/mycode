package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Executors 线程池工具类
 *
 * Executors.newFixedThreadPool(5);//固定长度的线程池
 * Executors.newSingleThreadExecutor();//只容1个线程池
 * Executors.newCachedThreadPool();//可变长度的线程池
 *
 * 三种方式均不采用（因为消息队列/可连接数 太大！），应自己定义连接池 请参考MyThreadPoolDemo.java
 * new threadPoolExecutor(int corePoolSize,
 *                               int maximumPoolSize,
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue,
 *                               ThreadFactory threadFactory,
 *                               RejectedExecutionHandler handler)
 *
 */
public class MyExecutorsDemo {

    public static void main(String[] args) {

        //List list = new ArrayList();
        //List list2 = Arrays.asList();类似

        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//固定长度的线程池

        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();//只容1个线程池

        ExecutorService threadPool3= Executors.newCachedThreadPool();//可变长度的线程池


        try {

            //10个请求
            for (int i = 0; i < 10; i++) {

                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "号窗口为您服务~");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            threadPool3.shutdown();//关闭线程池
        }


    }





}
