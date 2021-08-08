package com.hezhenguang.developtoolsplatform.common.utils;

import cn.hutool.core.text.csv.CsvRow;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExeclTest {

    @Test
    void readExecl() {
        String filePath = "F:\\OneDrive\\@恒生电子工作资料\\补丁做包小插件第一版\\modifyProgramMaxVer1023481071.xlsx";
        List<CsvRow> csvRowList = Execl.readExecl(filePath);
        csvRowList.stream().forEach(System.out::println);
    }
}