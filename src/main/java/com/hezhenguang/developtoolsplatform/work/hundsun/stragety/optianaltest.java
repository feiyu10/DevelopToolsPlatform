package com.hezhenguang.developtoolsplatform.work.hundsun.stragety;

import java.util.Optional;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-08-01
 **/
public class optianaltest {

    public static void main(String[] args) {
        long waitTime = 5000;
        long DEFAULT_WATE_TIME = 1000;
        long waitTimeTemp = Optional.ofNullable(waitTime).orElse(DEFAULT_WATE_TIME);
        System.out.println(waitTimeTemp);
    }
}
