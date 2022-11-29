package com.hezhenguang.developtoolsplatform.study.test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-11-29
 **/
public class Consumer {

    private static ArrayList<String> data = new ArrayList<>(200);

    // 全局锁
    private static ReentrantLock lock  = new ReentrantLock();

    private static AtomicInteger count = new AtomicInteger(0);
    private static AtomicInteger count_take = new AtomicInteger(0);

    // 生产数据
    public static boolean put(String value){
        lock.lock();
        try{
            data.add(value);
        }catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }finally {
            lock.unlock();
        }
        return true;
    }

    // 消费数据
    public static String take(){
        lock.lock();
        try{
            String result = data.get(0);
            // 数据移位 保持顺序性
            for(int i = 0; i< data.size() - 1 ;i++){
                data.set(i, data.get(i+1));
            }
            count.getAndIncrement();
            return result;
        }catch(Exception e){
            System.out.print(e.getMessage());
            return null;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args){

        for (int i = 0; i < 100; i++) {
            put(String.valueOf(i));
        }

        new Thread(() -> {
        while (count.get() < 100){
            System.out.println(take());
        }
        },"b").start();

        new Thread(() -> {
            while (count.get() < 100){
                System.out.println(take());
            }
        },"c").start();
    }
}
