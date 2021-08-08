package com.hezhenguang.developtoolsplatform.common.utils;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

public class Execl {

    public static List<List<Object>> readExecl(String filePath) {
        ExcelReader reader = ExcelUtil.getReader(filePath,2);
        List<List<Object>> read = reader.read();
        return read;
    }
}
