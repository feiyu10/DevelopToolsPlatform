package com.hezhenguang.developtoolsplatform.study.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-11-15
 **/
public class XieChengTest2 {

    //abc abc abc

    private static volatile AtomicInteger  num = new AtomicInteger(1);
    private static volatile AtomicInteger  count = new AtomicInteger(0);


    public static void main(String[] args) {

        new Thread(() -> {
            while (count.get() < 3){
                if (num.get() == 1){
                    System.out.print("a");
                    num.getAndIncrement();
                }
            }

        },"a").start();

        new Thread(() -> {
            while (count.get() < 3){
                if (num.get() == 2){
                    System.out.print("b");
                    num.getAndIncrement();
                }
            }
        },"b").start();

        new Thread(() -> {
            while (count.get() < 3){
                if (num.get() == 3){
                    System.out.println("c");
                    num.set(1);
                    count.getAndIncrement();
                }
            }
        },"c").start();
    }


}
