package juc.data;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z
 */
public class Data01 {

    private Lock lock = new ReentrantLock();

    private  int flag = 1; // 1 执行one线程   2 执行two线程

    private  Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    private static int one = 1;
    private static char two = 'A';

    public void one(){

        lock.lock();

        try {
            while( flag != 1){
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "--" + one++);
            System.out.println(Thread.currentThread().getName() + "--" + one++);
            flag = 2;
            c2.signal();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            lock.unlock();
        }


    }

    public  void two(){

        lock.lock();

        try {
            while( flag != 2){
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "--" + two++);
            flag = 1;
            c1.signal();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            lock.unlock();
        }

    }




}

