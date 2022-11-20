package com.hezhenguang.developtoolsplatform.study.grammarExercises;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 系统版本: v1.0<br>
 *
 * @description: 多线程顺序打印
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-04-17
 **/
public class MutThread {

    private  static int times = 50;
    private  static int state = 0;
    private  static int printNum = 1;
    private static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        new Thread(()->{
            print(0);
        },"A").start();

        new Thread(()->{
            print(1);
        },"B").start();
    }

    private static void print(int targetNum){
        for (int i = 0; i < times;) {
            lock.lock();
            try{
                if (state%2 == targetNum){
                    state++;
                    i++;
                    System.out.println(Thread.currentThread().getName() + " " + printNum++);
                }
            } finally {
                lock.unlock();
            }
        }
    }


}
