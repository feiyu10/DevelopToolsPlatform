package com.hezhenguang.developtoolsplatform.common.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Xml {
    private static final Logger log = LoggerFactory.getLogger(Xml.class);

    public static List<Map<String,String>> readXmlFile(String filePath){
        File file = new File(filePath);
        Document document = XmlUtil.readXML(file);
        return new ArrayList<>();
    }
}
