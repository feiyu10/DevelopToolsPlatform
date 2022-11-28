package com.hezhenguang.developtoolsplatform.study.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-11-16
 **/
public class XieChengtest3 {

    private static AtomicInteger count = new AtomicInteger(3);
    private static CountDownLatch countDownLatchA = new CountDownLatch(1);
    private static CountDownLatch countDownLatchB = new CountDownLatch(1);
    private static CountDownLatch countDownLatchC = new CountDownLatch(1);


    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                try {
                    System.out.print("a");
                    countDownLatchB.countDown();
                    countDownLatchA.await();
                    countDownLatchA = new CountDownLatch(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "a");

        Thread b = new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                try {
                    countDownLatchB.await();
                    System.out.print("b");
                    countDownLatchB = new CountDownLatch(1);
                    countDownLatchC.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b");

        Thread c = new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                try {
                    countDownLatchC.await();
                    System.out.println("c");
                    countDownLatchC = new CountDownLatch(1);
                    countDownLatchA.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c");

        c.start();
        b.start();
        a.start();
    }
}
