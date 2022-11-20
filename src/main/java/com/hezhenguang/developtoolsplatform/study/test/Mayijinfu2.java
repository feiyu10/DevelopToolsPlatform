package com.hezhenguang.developtoolsplatform.study.test;

/**
 * 系统版本: v1.0<br>
 *
 * @description: 蚂蚁金服笔试题
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-11-06
 **/
public class Mayijinfu2 {

    /**
     说明：一共两道题，时间一个小时内，做完可以自行结束，不用等待面试官
     **/


/*
 问题1：实现一个多线程类，并用该线程类实例化3个线程A,B,C；
 A线程打印字符A,B线程打印字符B，C线程打印字符C；启动这3个线程，
 要求启动线程的顺序为C线程->B线程->A线程，并且最后输出内容为：
A
B
C
不能用sleep函数，注意考虑线程安全问题。
*/

    public static class ThreadRun extends Thread{

        private String msg;

        private int num;

        public ThreadRun(String msg, int num){
            this.msg = msg;
            this.num = num;
        }

        @Override
        public void run(){
            while(true) {
                if(Test1.curNum == num){
                    System.out.print(msg);
                    Test1.curNum ++;
                    break;
                }
            }
        }
    }

    public static class Test1{

        public static volatile int curNum = 1;//AtomicInteger()

        public static void main(String[] args){
            try{
                new Thread(new ThreadRun("C",3),"C").start();
                new Thread(new ThreadRun("B",2),"B").start();
                new Thread(new ThreadRun("A",1),"A").start();
            }catch(Exception e){
                System.out.print("执行异常");
            }
        }

    }

















}
