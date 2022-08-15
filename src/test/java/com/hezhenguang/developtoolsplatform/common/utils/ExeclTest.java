package com.hezhenguang.developtoolsplatform.common.utils;

import cn.hutool.core.text.csv.CsvRow;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExeclTest {

    @Test
    void readExecl() {
        String filePath = "C:\\Users\\hspcadmin\\Desktop\\条件单系统配置维护.xlsx";
        List<List<Object>> lists = Execl.readExecl(filePath);
        lists.stream().forEach(System.out::println);
    }
}