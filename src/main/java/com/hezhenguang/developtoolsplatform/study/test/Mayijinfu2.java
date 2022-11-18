//package com.hezhenguang.developtoolsplatform.study.test;
//
///**
// * 系统版本: v1.0<br>
// *
// * @description: 蚂蚁金服笔试题
// * @author: hezg26906@hundsun.com<br>
// * @create: 2022-11-06
// **/
//public class Mayijinfu2 {
//
//    /**
//     说明：一共两道题，时间一个小时内，做完可以自行结束，不用等待面试官
//     **/
//
//
///*
// 问题1：实现一个多线程类，并用该线程类实例化3个线程A,B,C；
// A线程打印字符A,B线程打印字符B，C线程打印字符C；启动这3个线程，
// 要求启动线程的顺序为C线程->B线程->A线程，并且最后输出内容为：
//A
//B
//C
//不能用sleep函数，注意考虑线程安全问题。
//*/
//
//    public class ThreadRun extends Thread{
//
//        private String msg;
//
//        private int num;
//
//        public ThreadRun(String msg, int num){
//            this.msg = msg;
//            this.num = num;
//        }
//
//        @Override
//        public void run{
//            while(true) {
//                if(Test1.curNum == num){
//                    Systen.out.print(msg);
//                    Test1.num ++;
//                    break;
//                }
//            }
//        }
//    }
//
//    public class Test1{
//
//        public static volatile int curNum = 1;//AtomicInteger()
//
//        public static void main(String[] args){
//            try{
//                new Thread(new ThreadRun("C",3),"C").start();
//                new Thread(new ThreadRun("B",2),"B").start();
//                new Thread(new ThreadRun("A",1),"A").start();
//            }catch(Exception e){
//                System.out.print("执行异常");
//            }
//        }
//
//    }
//
//
//
//
///*
//问题2：题目：实现一个随机红包分配算法，模拟抢红包算法，将一个M元的红包分配给N个人
//要求：尽可能做到符合随机分配，既充分随机，又机会均等
//*/
//
//    public class ThreadRun2 extends Thread{
//
//        private double myMoney;
//
//        @Override
//        public void run{
//            this.myMoney = Test2.getRoundMoney();
//            System.out.print(System.runTime.currentThread().getName() + "抢到了:" + myMoney);
//        }
//    }
//
//    public class Test2{
//
//        // 总金额
//        public static volatile double countMoney = M;
//        // 总人数
//        public static final int COUNT_PEOPLE = N;
//        // 当前红包执行到了第几轮
//        public static volatile int curNum = 0;
//
//        /**
//         * 尽可能做到符合随机分配，
//         * 既充分随机，
//         * 又机会均等
//         */
//        public static synchronized double getRoundMoney(){
//            double money = random(countMoney, COUNT_PEOPLE - curNum);
//            countMoney -= money;
//            curNum++;
//            return money;
//        }
//
//        /**
//         * 获取剩余轮次的金额
//         */
//        public static double random(int money, int count){
//            if(1 == count){
//                return money;
//            }
//            double avgMoney = money/count;
//
//            return new Random().nextDouble(money - avgMoney) + avgMoney/count;
//        }
//
//        public static void main(String[] args){
//
//            for(int i = 0; i < COUNT_PEOPLE; i++){
//                try{
//                    new Thread(new ThreadRun1(),String.valueOf(i)).start();
//                }catch(Exception e){
//                    System.out.print("执行异常");
//                }
//            }
//        }
//    }
//\
//
//
//
//
//
//
//
//
//
//
//
//}
