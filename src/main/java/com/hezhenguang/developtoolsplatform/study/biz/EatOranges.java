package com.hezhenguang.developtoolsplatform.study.biz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * 2.1、吃桔子
 * 共计9个桔子，有3个小朋友，小朋友A每次拿2个桔子，小朋友B每次拿3个桔子，小朋友C每次拿1个桔子，小朋友10s吃1个桔子，吃完后继续去拿。
 * 小朋友每次拿桔子之前和拿了桔子之后，都会对桔子数量进行报数。如果剩余的桔子不够小朋友每次拿的数量，小朋友停止拿桔子，喊一声“不拿了”并退出游戏。
 * 请用java多线程程序表述上面的过程。
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-10-26
 **/
public class EatOranges {

    private static volatile int count = 9;

    public static synchronized int getCount(){
        return count;
    }

    public static synchronized int take(int takeNum){
        System.out.println("count:" + count + " takeNum:" + takeNum);
        if (count < takeNum){
            return -1;
        }
        count = count - takeNum;
        return takeNum;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("A", "B", "C");
        stringList.stream().forEach(o -> {
            new Thread(new Client(o)).start();
        });
    }

    public static class Client extends Thread {

        public Client(String name) {
            super.setName(name);
        }

        private static Map<String,Integer> takeNumMap = new HashMap<>(4);
        static {
            takeNumMap.put("A",2);
            takeNumMap.put("B",3);
            takeNumMap.put("C",1);
        }

        @Override
        public void run() {
            int num = 0;
            String name = super.getName();
            int takeNum = takeNumMap.getOrDefault(name,0);
            while (true){
                int curTakeNum = EatOranges.take(takeNum);
                if (curTakeNum == -1){
                    System.out.println(name + "不拿了,退出了游戏");
                    break;
                }
                num += curTakeNum;
                System.out.println(name + "已经拿了" + num);
                for (int i = 0; i < takeNum; i++) {
                    try{
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(name + "总共拿了:" + num);
        }
    }

}
