package com.hezhenguang.developtoolsplatform.study.grammarExercises;

import com.hezhenguang.developtoolsplatform.work.hundsun.stragety.pojo.Customer;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-06-29
 **/
public class zhengze {
    public static void main(String[] args) {
        String querySql2 = "select\n" +
                "    hs_openid,\n" +
                "    client_id,\n" +
                "    branch_no,\n" +
                "    comp_id,\n" +
                "    client_name,\n" +
                "    userpassword,\n" +
                "    create_datetime,\n" +
                "    crop_risk_level \n" +
                "from\n" +
                "    user \n" +
                "where\n" +
                "    hs_openid = ? ";
        String s = StringUtils.replaceAll(querySql2, "\\buser\\b", "\"user\"");

        String rex = "\\buser\\b";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(querySql2);
        boolean b = matcher.find();
        boolean matches = matcher.matches();
        System.out.println(11111);

        Customer customer = new Customer();
        customer.setUuid(null);
        System.out.println(customer.getUuid());
    }
}
