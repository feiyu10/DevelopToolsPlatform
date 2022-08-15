package com.hezhenguang.developtoolsplatform.study.grammarExercises;

import java.util.concurrent.CountDownLatch;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-04-17
 **/
public class CountDownLatchtest {
    public static void main(String[] args) {
        CountDownLatch countDownLatchA = new CountDownLatch(1);
        CountDownLatch countDownLatchB = new CountDownLatch(1);
        CountDownLatch countDownLatchC = new CountDownLatch(1);
        int i = 0;

        Thread A = new Thread(()->{
            try {
                countDownLatchA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
            countDownLatchA.countDown();
        },"A");
        Thread B = new Thread(()->{
            try {
                countDownLatchB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
            countDownLatchB.countDown();
        },"B");
        Thread C = new Thread(()->{
            try {
                countDownLatchC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
            countDownLatchC.countDown();
        },"C");

        C.start();
        B.start();
        A.start();
        countDownLatchA.countDown();
    }
}
