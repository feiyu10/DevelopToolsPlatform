package com.hezhenguang.developtoolsplatform.work.hundsun.stragety.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-05-20
 **/
@Data
public class Config {

    @ExcelProperty(value = "id", index = 0)
    private String id;

    @ExcelProperty(value = "param_name", index = 1)
    private String param_name;

    @ExcelProperty(value = "param_value", index = 2)
    private String param_value;

    @ExcelProperty(value = "remark", index = 3)
    private String remark;

    @ExcelProperty(value = "param_type", index = 4)
    private String param_type;

}
