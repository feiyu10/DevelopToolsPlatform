package com.hezhenguang.developtoolsplatform.study.test;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-06-27
 **/
public class Singleton {

//    private Singleton(){};
//
//    private volatile static Singleton singleton;
//
//    public static Singleton getInstance(){
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    private Singleton(){};

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
