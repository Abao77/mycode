package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class ReadWriteLockDemo {

    private Map<String,String> map = new HashMap<>();

    //读写锁
    private ReadWriteLock lock = new ReentrantReadWriteLock();



    public void write(String key,String value){

        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "正在写入-" + key + "--" + value);

            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);

            System.out.println(Thread.currentThread().getName() + "写入完成" + key + "--" + value);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.writeLock().unlock();
        }
    }

    public String read(String key){


        lock.readLock().lock();

        String result = null;
        try {
            System.out.println(Thread.currentThread().getName() + "-正在读取>");

            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            result = map.get(key);

            System.out.println(Thread.currentThread().getName() + "读到>" + key + "=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }

        return result;

    }


    public static void main(String[] args) {


        ReadWriteLockDemo mc = new ReadWriteLockDemo();

        for (int i = 0; i < 5; i++) {

            new Thread(() -> {

                mc.write(Thread.currentThread().getName(),"value");

            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {

            new Thread(() -> {

                mc.read(Thread.currentThread().getName());

            },String.valueOf(i)).start();
        }


    }




}
