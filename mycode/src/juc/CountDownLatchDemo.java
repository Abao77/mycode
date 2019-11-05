package juc;

import enums.MyEnum;

import java.util.concurrent.CountDownLatch;


/**
 *  CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
 *
 *  其它线程调用countDown方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 *
 *  当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行。
 *
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {


        CountDownLatch cd = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {

            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + " 国被灭-----------");

                cd.countDown();

            }, MyEnum.get(i)).start();

        }

        cd.await();

        System.out.println(Thread.currentThread().getName() + " +++++++秦国统一六国+++++++");

    }

}
