package com.hezhenguang.developtoolsplatform.dailyLife.utils;

import com.hezhenguang.developtoolsplatform.common.utils.Txt;
import com.hezhenguang.developtoolsplatform.dailyLife.pojo.BookKeepJo;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BookkeepingAndSettlementTest {

    @Test
    void bookkeepingAndSettlementTest(){
        String filePath = "C:\\Users\\14166\\Desktop\\20220706清算测试.txt";
        List<String> collect = Txt.readTxtFile(filePath)
                .stream()
                .skip(1)
                .collect(Collectors.toList());

        List<BookKeepJo> bookKeepJos = new ArrayList<BookKeepJo>();
        for (String line : collect) {
            String[] split = line.split("\\s+");
            BookKeepJo bookKeepJo = new BookKeepJo();
            bookKeepJo.setPayer(split[0]);
            bookKeepJo.setCost(Double.parseDouble(split[1]));
            bookKeepJo.setParticipant(split[2]);
            bookKeepJo.setRemark(StringUtils.defaultString(split[3],""));
            bookKeepJos.add(bookKeepJo);
        }

        BookkeepingAndSettlement.Settlement(bookKeepJos);
    }

}