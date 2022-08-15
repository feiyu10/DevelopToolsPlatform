package com.hezhenguang.developtoolsplatform.work.hundsun.stragety.function;

import com.alibaba.fastjson.JSON;
import com.hezhenguang.developtoolsplatform.common.utils.EasyExcelUtils;
import org.apache.commons.lang3.StringUtils;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-05-19
 **/
public class FunctionTest {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        EasyExcelUtils.readExecl("C:\\Users\\hspcadmin\\Desktop\\无标题表格(1).csv");

        List<Object> datas = EasyExcelUtils.StringExcelListener.getDatas();

        for (Object line : datas) {
            LinkedHashMap<Integer,String> value = (LinkedHashMap) line;
            if (value.get(0) !=null){
                builder.append(test(value.get(1),value.get(0))).append(",");
            }
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        System.out.println(builder);
    }

    private static String test(String sub_trans_name, String sub_trans_code){
        JsonRootBean jsonRootBean = new JsonRootBean();

        Customer customer = new Customer();
        customer.setPublic1(true);
        customer.setStatus(1);
        customer.setUuid(UUID.randomUUID().toString());
        jsonRootBean.setCustomer(customer);

        jsonRootBean.setEnable(true);

        Data data = new Data();
        data.setSub_trans_name(StringUtils.defaultString(sub_trans_name,""));
        data.setSub_trans_code(sub_trans_code);
        data.setCtrl_flag("0");
        data.setMicro_service("strategy");

        ExtensibleModel extensibleModel = new ExtensibleModel();
        extensibleModel.setData(data);
        extensibleModel.setStatus(1);
        jsonRootBean.setExtensibleModel(extensibleModel);

        jsonRootBean.setStatus(1);
        jsonRootBean.setUuid(UUID.randomUUID().toString());

        return JSON.toJSONString(jsonRootBean);
    }
}
