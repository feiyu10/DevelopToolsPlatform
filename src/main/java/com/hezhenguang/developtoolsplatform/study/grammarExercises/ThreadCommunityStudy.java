package com.hezhenguang.developtoolsplatform.study.grammarExercises;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadCommunityStudy{
    private static int threadNum = 3; //线程数量
    private static int times = 10; //循环打印次数
    private static  int state=0;//当前线程状态，用于记录当前应该是哪个线程打印了
    private static  int number=0;//线程打印的数字
    private static Lock lock =new ReentrantLock(false);

    public static void printNumByLock(int self) throws InterruptedException {
        for(int i=0;i<times;){
            lock.lock(); //不可置于try中，否则可能出现加锁失败，最终又去finally中unlock
            try{
                if(state%threadNum==self){ //判断是否是到自己打印了
                    state++;
                    i++;
                    System.out.println(Thread.currentThread().getName()+"-------正在打印-->"+(++number));
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }finally {
                lock.unlock(); //记得释放锁
            }
        }
    }

    public static void main(String[] args) {

        for(int i=0;i<threadNum;i++){
            final int threadId=i;
            new Thread(()->{
                try {
                    ThreadCommunityStudy.printNumByLock(threadId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
