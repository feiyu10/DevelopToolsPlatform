package com.hezhenguang.developtoolsplatform.study.biz;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.maven.lifecycle.internal.BuildThreadFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 系统版本: v1.0<br>
 *
 * @description: 快速获取并处理100w条映射列表相关的数据
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-10-25
 **/
public class QuickAccessToMappingListData {

    public static void main(String[] args) {
        Map<String,String> data = new HashMap<>();
        for (Map.Entry<String,String>item : data.entrySet()) {
            System.out.println(item.getKey() + item.getValue());
        }

        Thread.currentThread().interrupt();
        for (String key : data.keySet()) {
            System.out.println(key);
        }

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("pool-%s").build();
        //ExecutorService executorService = Executors.newFixedThreadPool(3, threadFactory);
        ExecutorService executorService = Executors.newFixedThreadPool(3, new BuildThreadFactory());
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }


        for (String value : data.values()) {
            System.out.println(value);
        }

        Iterator<Map.Entry<String, String>> iterator = data.entrySet().iterator();
        iterator.hasNext();



    }

    public static void main1(String[] args) {

        long start = System.currentTimeMillis();

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(i);
        }
        AtomicLong num = new AtomicLong(0);
        CompletableFuture[] cfs = data.stream().map(o -> {
            return CompletableFuture.runAsync(() -> {
                data.get(o);
                num.getAndIncrement();
            });
        }).toArray(CompletableFuture[] :: new);

        CompletableFuture.allOf(cfs).join();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(num.get());
    }


    private static AtomicLong at = new AtomicLong(1);
    private static AtomicInteger at1 = new AtomicInteger(0);
    private static ConcurrentHashMap<Long, String> chm = new ConcurrentHashMap<>();
    private static int THREAD_COUNT = Runtime.getRuntime().availableProcessors()+1;


    public static void main2(String[] args) throws Exception {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            data.add(i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        executorService.submit(() -> {
            data.get(at1.getAndIncrement());
        });

        executorService.shutdown();
        while (true){
            if (executorService.isTerminated()){
                break;
            }
        }
    }

    public static void main24(String[] args) throws Exception {
        for(long i = 1;i <=1000000;i++) {
            chm.put(i, "元素"+i);
        }
        System.out.println("----100w条数据加载完毕，开始执行-----");
        ExecutorService tenThread = Executors.newFixedThreadPool(THREAD_COUNT);
        long start = System.currentTimeMillis();
        for(long i = 1;i <=1000000;i++) {
            tenThread.submit(new Runnable() {
                @Override
                public void run() {
                    //System.out.println(Thread.currentThread().getName()+"获取的元素为："+chm.get(at.getAndIncrement())); //打印也十分耗性能
                    chm.get(at.getAndIncrement());
                }
            });
        }
        tenThread.shutdown();
        while (true) {
            if (tenThread.isTerminated()) {
                System.out.println("结束了！");
                long  end = System.currentTimeMillis();
                System.out.println("获取列表所有元素运行时间："+(end-start)+"ms");
                break;
            }
        }
    }

}
