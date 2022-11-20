package com.hezhenguang.developtoolsplatform.study.grammarExercises;

import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-11-20
 **/
public class PriorityQueueTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(16);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        PriorityQueue<String> priorityQueue = new PriorityQueue(2, (s1, s2) -> {
            return map.get(s1) - map.get(s2);
        });

        /*
        add         增加一个元索                      如果队列已满，则抛出一个IIIegaISlabEepeplian异常
        remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
        element  返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
        offer       添加一个元素并返回true        如果队列已满，则返回false
        poll         移除并返问队列头部的元素     如果队列为空，则返回null
        peek       返回队列头部的元素              如果队列为空，则返回null
        put         添加一个元素                       如果队列满，则阻塞
        take        移除并返回队列头部的元素     如果队列为空，则阻塞
         */
        for (Map.Entry<String,Integer> entry : map.entrySet()){
            priorityQueue.offer(entry.getKey());
            if (priorityQueue.size() > 2){
                priorityQueue.poll();
            }
        }


        ArrayList<Object> list = new ArrayList<>(2);
        while (priorityQueue.size() > 0 ){
            list.add(priorityQueue.poll());
        }

        System.out.println(list);

    }
}
