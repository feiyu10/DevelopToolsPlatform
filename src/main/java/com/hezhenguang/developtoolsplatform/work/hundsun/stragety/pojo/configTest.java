package com.hezhenguang.developtoolsplatform.work.hundsun.stragety.pojo;

import com.alibaba.fastjson.JSON;
import com.hezhenguang.developtoolsplatform.common.utils.EasyExcelUtils;

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
public class configTest {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        EasyExcelUtils.readExecl("C:\\Users\\hspcadmin\\Desktop\\无标题表格.csv");

        List<Object> datas = EasyExcelUtils.StringExcelListener.getDatas();

        for (Object line : datas) {
            LinkedHashMap<Integer,String> value = (LinkedHashMap) line;
            if (value.get(0) !=null){
                builder.append(test(value.get(0),value.get(1),value.get(2),value.get(3))).append(",");
            }
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        System.out.println(builder);
    }

    private static String test(String config_no, String config_name, String str_config, String remark){
        JsonRootBean jsonRootBean = new JsonRootBean();
        jsonRootBean.setCate("strategy");
        jsonRootBean.setCateUuid("4411");

        Customer customer = new Customer();
        customer.setStatus(1);
        customer.setPublic1(true);
        customer.setUuid(UUID.randomUUID().toString());
        jsonRootBean.setCustomer(customer);

        jsonRootBean.setEnable(true);


        Data data = new Data();
        data.setBranch_no("-1");
        data.setConfig_no(config_no);
        data.setConfig_name(config_name);
        data.setManage_level("0");
        data.setAccess_level("1");
        data.setData_type("2");
        data.setStr_config(str_config);
        data.setRemark(remark);
        data.setSys2("0");
        data.setSys3("0");



        ExtensibleModel extensibleModel = new ExtensibleModel();
        extensibleModel.setData(data);
        extensibleModel.setStatus(1);
        jsonRootBean.setExtensibleModel(extensibleModel);

        jsonRootBean.setStatus(1);
        jsonRootBean.setUuid(UUID.randomUUID().toString());

        return JSON.toJSONString(jsonRootBean);
    }
}
