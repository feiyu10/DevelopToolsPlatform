package com.hezhenguang.developtoolsplatform.common.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.cache.selector.SimpleReadCacheSelector;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2021-11-20
 **/
public class EasyExcelUtils {

    public static void readExecl(){
        // 第一个参数的意思是 多少M共享字符串以后 采用文件存储 单位MB 默认5M
        // 第二个参数 文件存储时，内存存放多少M缓存数据 默认20M
        // 比如 你希望用100M内存(这里说的是解析过程中的永久占用,临时对象不算)来解析excel，前面算过了 大概是 20M+90M 所以设置参数为:20 和 90
        // 这里再说明下 就是加了个readCacheSelector(new SimpleReadCacheSelector(5, 20))参数而已，其他的参照其他demo写 这里没有写全

        String path = "C:\\Users\\14166\\Downloads\\gas_test.csv";
        //String path = "C:\\Users\\14166\\Downloads\\wc_forecasts.csv";
        StringExcelListener listener = new StringExcelListener();
        ExcelReaderBuilder readCacheSelector = EasyExcel.read(path, listener).readCacheSelector(new SimpleReadCacheSelector(10000, 12000));
        readCacheSelector.doReadAll();
    }







        /**
         * StringList 解析监听器
         *
         * @author zhangcanlong
         * @since 2019-10-21
         */
        @Service
        private static class StringExcelListener extends AnalysisEventListener {
            /**
             * 自定义用于暂时存储data
             * 可以通过实例获取该值
             */
            //public static List<List<String>> datas = new ArrayList<>();
            public static List<Object> datas = new ArrayList<>(1001000);
            //public static List<Object> datas = new LinkedList<>();
            /**
             * 每解析一行都会回调invoke()方法
             *
             * @param object  读取后的数据对象
             * @param context 内容
             */
            @Override
            public void invoke(Object object, AnalysisContext context) {
                //@SuppressWarnings("unchecked")
                //Map<String, String> stringMap = (HashMap<String, String>) object;
                // 这里可以获取excel的基本信息，包含excel的总行数
                //System.out.println("不一定十分准确的总行数：" + context.readRowHolder().getRowIndex());
                //数据存储到list，供批量处理，或后续自己业务逻辑处理。
                //datas.add(new ArrayList<>(stringMap.values()));
                datas.add(object);
                //根据自己业务做处理
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                //解析结束销毁不用的资源
                //注意不要调用datas.clear(),否则getDatas为null
            }

            /**
             * 返回数据
             *
             * @return 返回读取的数据集合
             **/
            //public static List<List<String>> getDatas() {
              //  return datas;
            //}
            public static List<Object> getDatas() {
                return datas;
            }
        }


    public static void main(String[] args) {

        LocalDateTime begin = LocalDateTime.now();
        System.out.println("已开始: " + begin);

        readExecl();

        LocalDateTime end = LocalDateTime.now();
        System.out.println("已结束: " + end);

        Duration duration = Duration.between(begin, end);
        System.out.println("毫秒: " + duration.toMillis());
        System.out.println("秒: " + duration.getSeconds());
        System.out.println("分钟: " + duration.toMinutes());

        List<Object> datas = StringExcelListener.getDatas();
        System.out.println("总数据条数为: " + datas.size());
    }
}
