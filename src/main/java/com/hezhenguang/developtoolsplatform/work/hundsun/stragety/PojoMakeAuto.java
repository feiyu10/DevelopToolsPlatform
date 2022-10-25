package com.hezhenguang.developtoolsplatform.work.hundsun.stragety;

import com.hezhenguang.developtoolsplatform.common.utils.Txt;
import com.hezhenguang.developtoolsplatform.dailyLife.pojo.BookKeepJo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @create: 2022-07-24
 **/
public class PojoMakeAuto {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\14166\\Desktop\\pojomakeauto.txt";
        List<String> collect = Txt.readTxtFile(filePath)
                .stream()
                .collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (String line : collect) {
                String[] split = line.split("\\s+");
            builder.append("/**").append("\n");
            builder.append("  *").append(split[1]).append(" ").append(split[2]).append(" ").append(split[3]).append("\n");
            builder.append("  */").append("\n");
            builder.append("private String ").append(camel(split[0])).append(";").append("\n").append("\n");
        }
        System.out.println(builder.toString());
    }

    /**
     * 将下划线格式字符串转驼峰格式
     * @param str string 待处理字符串
     * @return string 处理结果
     */
    public static String camel(String str) {
        //正则匹配下划线及后一个字符，删除下划线并将匹配的字符转成大写
        Pattern UNDERLINE_PATTERN = Pattern.compile("_([a-z])");
        Matcher matcher = UNDERLINE_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            //将当前匹配的子串替换成指定字符串，并且将替换后的子串及之前到上次匹配的子串之后的字符串添加到StringBuffer对象中
            //正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            //把之后的字符串也添加到StringBuffer对象中
            matcher.appendTail(sb);
        } else {
            return sb.toString();
        }
        return camel(sb.toString());
    }


}
