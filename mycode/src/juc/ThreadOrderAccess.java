package juc;


import juc.data.Data01;
import juc.data.Data02;

/**
 * 线程间通信
 *
 * 线程调动资源类
 *
 * 判断 干活 通知
 *
 * test01-------------------------
 * 两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z
 *
 *
 * test02-------------------------
 * 多线程之间按顺序调用，实现A->B->C
 *  * 三个线程启动，要求如下：
 *  *
 *  * AA打印5次，BB打印10次，CC打印15次
 *  * 接着
 *  * AA打印5次，BB打印10次，CC打印15次
 *  * ......来10轮
 *
 */
public class ThreadOrderAccess {

    public static void main(String[] args) {

        Data01 d = new Data01();


        for (int i = 0; i < 26; i++) {
            new Thread(() -> {
                d.one();
            },"AA").start();
        }

        for (int i = 0; i < 26; i++) {
            new Thread(() -> {
                d.two();
            },"BB").start();
        }





        //------------------------------------

        Data02 d2 = new Data02();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                d2.one();
            }
        },"AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                d2.two();
            }
        },"BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                d2.three();
            }
        },"CC").start();




    }



}
