package com.hezhenguang.developtoolsplatform.work.hundsun.stragety;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 系统版本: v1.0<br>
 *
 * @description:
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-06-10
 **/
public class Httptest {

    public static void main(String[] args) {
        String url = "http://10.20.37.85:8088/hezg/strategy/v/closedMarketAutoEntrust?reserved_balance={reserved_balance}";
        //post请求
        HttpMethod method = HttpMethod.GET;
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object > params= new LinkedMultiValueMap<String, Object>();
        params.add("access_token", "ce79b42afceaaadd968f4ee2841f5f16");
        params.add("reserved_balance", 10000000d);
        //发送http请求并返回结果

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        //  执行HTTP请求
        //ResponseEntity<String> response = client.exchange(url, HttpMethod.GET, requestEntity, String.class);
        //String body = response.getBody();


        Double test = 12345678D;
        Map<String,Object> map = new HashMap();
        map.put("access_token","ce79b42afceaaadd968f4ee2841f5f16");
        map.put("reserved_balance", 10000000d);
        map.put("test", test);
        String notice = client.getForObject(url, String.class,map);
        System.out.println(11111);

        Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)[Ee]{1}[\\+-]?[0-9]*");
        boolean isMache=pattern.matcher(test.toString()).matches();//判断是否是科学计数法  true是科学计数法,false不是科学计数法

        System.out.println(test.doubleValue());

    }
}
