package threadpool;

import java.util.concurrent.*;

public class MyThreadPoolDemo {


    public static void main(String[] args) {

        //自定义一个线程池
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,//核心线程数
                5,//最大可连接数
                5L,//临时线程最大空闲时间
                TimeUnit.SECONDS,//时间的单位
                new ArrayBlockingQueue<>(3),//等待队列
                Executors.defaultThreadFactory(),//默认的工厂
                new ThreadPoolExecutor.DiscardOldestPolicy()//超过 最大可连接数+等待队列数 后采取的拒绝策略

        );


        try {
            for (int i = 0; i < 10; i++) {//启动多少个线程

                threadPool.execute(()->{//执行连接池

                    System.out.println(Thread.currentThread().getName() + "号窗口为您服务~");

                    try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();//关闭连接池
        }


    }


}
