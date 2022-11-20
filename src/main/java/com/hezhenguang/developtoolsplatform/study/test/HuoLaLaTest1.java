package com.hezhenguang.developtoolsplatform.study.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-06-28
 **/
public class HuoLaLaTest1 {


    /**
     * 系统版本: v1.0<br>
     *
     * @description:
     * 题目1：
     *
     * 我们需要实现一个方法，从包含 sku 的文件中读取数据，并且逐条打印。「注意：假设 sku 数据很多, 无法将 sku 列表完全加载到内存中」
     *
     * 题目 2：
     *
     * 现在需要统计 sku 数据，假设所有sku的价格都是精确到1元且一定小于1万元,计算当前这堆数据中，经过排序后的中间的价格。比如价格为1、1、2、25、25、25、25，按照题目要求，是第4个价格【25】）
     * @author: hezg26906@hundsun.com<br>
     * @create: 2022-11-20
     **/
    public static class BufferReadFile {

        public static void main(String[] args) {

            TreeMap<Integer,Integer> data = new TreeMap<>();

            Path path = new File("C:\\Users\\14166\\Desktop\\test.txt").toPath();
            try {
                Files.lines(path)
                        .skip(0)
                        .forEach(line -> {
                            System.out.println(line);
                            data.merge(Integer.valueOf(line), 1 , Integer :: sum);
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }

            int midSize = data.size() / 2;
            int midPrice = 0;
            int count = 0;
            for (Map.Entry<Integer,Integer> entry : data.entrySet()){
                if (count + entry.getValue() > midSize){
                    midPrice = entry.getKey();
                    break;
                }
                count += entry.getValue();
            }
            System.out.println("中位数价格=" + midPrice);


        }
    }
}
