/**
  * Copyright 2022 bejson.com 
  */
package com.hezhenguang.developtoolsplatform.work.hundsun.stragety.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Auto-generated: 2022-05-19 19:32:52
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */

public class Data {

    @JSONField(ordinal = 1)
    private String branch_no;
    @JSONField(ordinal = 2)
    private String config_no;
    @JSONField(ordinal = 3)
    private String config_name;
    @JSONField(ordinal = 4)
    private String manage_level;
    @JSONField(ordinal = 5)
    private String access_level;
    @JSONField(ordinal = 6)
    private String data_type;
    @JSONField(ordinal = 7)
    private String str_config;
    @JSONField(ordinal = 8)
    private String remark;
    @JSONField(ordinal = 9)
    private String sys2;
    @JSONField(ordinal = 10)
    private String sys3;

    public String getBranch_no() {
        return branch_no;
    }

    public void setBranch_no(String branch_no) {
        this.branch_no = branch_no;
    }

    public String getConfig_no() {
        return config_no;
    }

    public void setConfig_no(String config_no) {
        this.config_no = config_no;
    }

    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    public String getManage_level() {
        return manage_level;
    }

    public void setManage_level(String manage_level) {
        this.manage_level = manage_level;
    }

    public String getAccess_level() {
        return access_level;
    }

    public void setAccess_level(String access_level) {
        this.access_level = access_level;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getStr_config() {
        return str_config;
    }

    public void setStr_config(String str_config) {
        this.str_config = str_config;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSys2() {
        return sys2;
    }

    public void setSys2(String sys2) {
        this.sys2 = sys2;
    }

    public String getSys3() {
        return sys3;
    }

    public void setSys3(String sys3) {
        this.sys3 = sys3;
    }
}