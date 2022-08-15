package com.hezhenguang.developtoolsplatform.common.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.cache.selector.SimpleReadCacheSelector;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2021-11-20
 **/
public class EasyExcelUtils {

    public static void readExecl(String path){

        StringExcelListener listener = new StringExcelListener();
        ExcelReaderBuilder readCacheSelector = EasyExcel.read(path, listener)
                .readCacheSelector(new SimpleReadCacheSelector(10000, 12000));
        readCacheSelector.doReadAll();


        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(path, Object.class, new StringExcelListener()).sheet().doRead();
    }







        /**
         * StringList 解析监听器
         *
         * @author zhangcanlong
         * @since 2019-10-21
         */
        @Service
        public static class StringExcelListener extends AnalysisEventListener {
            /**
             * 自定义用于暂时存储data
             * 可以通过实例获取该值
             */
            public static List<Object> datas = new ArrayList<>(1001000);
            /**
             * 每解析一行都会回调invoke()方法
             *
             * @param object  读取后的数据对象
             * @param context 内容
             */
            @Override
            public void invoke(Object object, AnalysisContext context) {
                datas.add(object);
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
            public static List<Object> getDatas() {
                return datas;
            }
        }


    public static void main(String[] args) {

        LocalDateTime begin = LocalDateTime.now();
        System.out.println("已开始: " + begin);

        readExecl("");

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
