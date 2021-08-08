package com.hezhenguang.developtoolsplatform.common.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TxtTest {

    @Test
    void readTxtFile() {
        String filePath = "C:\\Users\\feiyu\\Desktop\\计划.txt";
        List<String> strings = Txt.readTxtFile(filePath);
        strings.stream().forEach(System.out::println);
    }
}