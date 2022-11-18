package com.hezhenguang.developtoolsplatform.study.biz;

import java.util.Random;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-10-26
 **/
public class Test2 {

    // 总金额
    public static volatile int countMoney = 100;
    // 总人数
    public static final int COUNT_PEOPLE = 10;
    // 当前红包执行到了第几轮
    public static volatile int curNum = 0;

    /**
     * 尽可能做到符合随机分配，
     * 既充分随机，
     * 又机会均等
     */
    public static synchronized int getRoundMoney(){
        int money = random(countMoney, COUNT_PEOPLE - curNum);
        countMoney -= money;
        curNum++;
        return money;
    }

    /**
     * 获取剩余轮次的金额
     */
    public static int random(int money, int count){
        if(1 == count){
            return money;
        }
        int avgMoney = money/count;

        return new Random().nextInt((money - avgMoney)) + avgMoney/count;
    }

    public static void main(String[] args){

        for(int i = 0; i < COUNT_PEOPLE; i++){
            try{
                new Thread(new ThreadRun2(),String.valueOf(i)).start();
            }catch(Exception e){
                System.out.print("执行异常");
            }
        }
    }

    public static class ThreadRun2 extends Thread{

        private int myMoney;

        @Override
        public void run(){
            this.myMoney = Test2.getRoundMoney();
            System.out.println(Thread.currentThread().getName() + "抢到了:" + myMoney);
        }
    }
}
