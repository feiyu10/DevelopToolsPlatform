package com.hezhenguang.developtoolsplatform.study.test;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-11-16
 **/
public class XIeChengTest1 {


    private static AtomicInteger count = new AtomicInteger(3);
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition conditionA = reentrantLock.newCondition();
    private static Condition conditionB = reentrantLock.newCondition();
    private static Condition conditionC = reentrantLock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                reentrantLock.lock();
                try{
                    System.out.print("a");
                    conditionB.signal();
                    conditionA.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if ((i+1) == count.get()){
                        conditionB.signal();
                    }
                    reentrantLock.unlock();
                }
            }
        },"a").start();

        new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                reentrantLock.lock();
                try{
                    System.out.print("b");
                    conditionC.signal();
                    conditionB.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if ((i+1) == count.get()){
                        conditionC.signal();
                    }
                    reentrantLock.unlock();
                }
            }
        },"b").start();

        new Thread(() -> {
            for (int i = 0; i < count.get(); i++) {
                reentrantLock.lock();
                try{
                    System.out.println("c");
                    conditionA.signal();
                    conditionC.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    reentrantLock.unlock();
                }
            }
        },"c").start();
    }
}
