package com.hezhenguang.developtoolsplatform.study.algorithmExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 系统版本: v1.0<br>
 *
 * @description:字母异位词分组
 * @author: hezg26906@hundsun.com<br>
 * @date: 2022-11-21
 **/
public class groupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);

        System.out.println(countDigitOne(13));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> ans = map.getOrDefault(s, new ArrayList<String>());
            ans.add(str);
            map.put(s, ans);
        }
        return new ArrayList<>(map.values());
    }

    public static long countDigitOne(int n) {
        long k = 1;
        long ans = 0;//初始化数据
        while (n >= k){
            ans += (1+(n/k-1)/10)*k;//计数
            if (n/k%10 == 1) {
                ans = ans-k+1+n%k;//当前位为1，减去数据
            }
            k *= 10;
        }
        return ans;//输出结果
    }




}
