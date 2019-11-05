package juc.data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data02 {

    private Lock lock = new ReentrantLock();

    private int flag = 1;  //1  2  3

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void one(){

        lock.lock();

        try {
            while(flag != 1){
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 1; i <= 5; i++) {

                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
            flag = 2;
            c2.signal();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public void two(){
        lock.lock();

        try {
            while(flag != 2){
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 1; i <= 10; i++) {

                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
            flag = 3;
            c3.signal();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void three(){
        lock.lock();

        try {
            while(flag != 3){
                try {
                    c3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 1; i <= 15; i++) {

                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
            flag = 1;
            c1.signal();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }





}
