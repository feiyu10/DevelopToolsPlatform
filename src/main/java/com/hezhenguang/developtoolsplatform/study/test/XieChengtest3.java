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
    private static CountDownLatch countDownLatchA = new CountDownLatch(count.get());
    private static CountDownLatch countDownLatchB = new CountDownLatch(count.get());
    private static CountDownLatch countDownLatchC = new CountDownLatch(count.get());


    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                System.out.print("a");
                try {
                    countDownLatchA.await();
                    countDownLatchB.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"a").start();

        new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                System.out.print("b");
                try {
                    countDownLatchB.await();
                    countDownLatchC.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();

        new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                System.out.println("c");
                try {
                    countDownLatchC.await();
                    countDownLatchA.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c").start();
    }
}
