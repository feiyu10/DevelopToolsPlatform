package com.hezhenguang.developtoolsplatform.common.utils;

import cn.hutool.core.text.csv.*;

import java.nio.file.Paths;
import java.util.List;

public class Execl {

    public static List<CsvRow> readExecl(String filePath) {
        CsvReadConfig csvReadConfig = new CsvReadConfig();
        CsvReader csvReader = new CsvReader(Paths.get(filePath),csvReadConfig);
        CsvData csvRows = csvReader.read();
        return csvRows.getRows();
    }
}
