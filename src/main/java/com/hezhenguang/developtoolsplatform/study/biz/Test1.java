package com.hezhenguang.developtoolsplatform.study.biz;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-10-26
 **/
public class Test1 {

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

    public static class ThreadRun extends Thread{

        private String msg;

        private int num;

        public ThreadRun(String msg, int num){
            this.msg = msg;
            this.num = num;
        }

        @Override
        public void run() {
            while(true) {
                if(Test1.curNum == num){
                    System.out.print(msg);
                    Test1.curNum++;
                    break;
                }
            }
        }
    }

}
