package com.hezhenguang.developtoolsplatform.work.hundsun.acct;

import com.hezhenguang.developtoolsplatform.common.utils.Xml;

import java.util.List;
import java.util.Map;

public class dictxml {
    public static void main(String[] args) {
        String filePath = "F:\\恒生\\HSCode\\hstrade20\\Sources\\DevCodes_Acct\\客户账户管理系统V22\\公共资源\\dict.xml";
        List<Map<String, String>> xmlFile = Xml.readXmlFile(filePath);
    }
}
