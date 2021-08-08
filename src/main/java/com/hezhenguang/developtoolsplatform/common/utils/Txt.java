package com.hezhenguang.developtoolsplatform.common.utils;

import cn.hutool.core.io.file.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 登高而望远
 * 读取txt文件
 */
public class Txt {

    private static final Logger log = LoggerFactory.getLogger(Txt.class);

    public static List<String> readTxtFile(String filePath){
        FileReader fileReader = new FileReader(filePath);
        List<String> strings = fileReader.readLines();
        return strings;
    }
}
