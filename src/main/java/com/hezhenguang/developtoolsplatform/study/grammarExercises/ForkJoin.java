package com.hezhenguang.developtoolsplatform.study.grammarExercises;

import java.util.stream.IntStream;

public class ForkJoin {


    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long startTime = System.currentTimeMillis();
        long reduce = IntStream.rangeClosed(1,10_0000_0000).parallel().reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("time==>" + String.valueOf(endTime-startTime)+ "result==>" + String.valueOf(reduce));
    }


}
