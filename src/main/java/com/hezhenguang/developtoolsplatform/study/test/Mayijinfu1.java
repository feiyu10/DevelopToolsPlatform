//package com.hezhenguang.developtoolsplatform.study.test;
//
//import java.util.List;
//
///**
// * 系统版本: v1.0<br>
// *
// * @description: 蚂蚁金服笔试题
// * @author: hezg26906@hundsun.com<br>
// * @create: 2022-11-06
// **/
//public class Mayijinfu1 {
//
//    按照配置的简单规则表达式求多个集合的交并集结果   括号内交集   括号间并集  如下面的例子。
//    public static Class A{
//        private String code;
//        private String name;
//
//
//        @Override
//        public int hashcode(){
//            return (this.code.hashcode() / 2) + (this.name.hashcode() / 2);
//        }
//
//
//        @Override
//        public boolean equals(A a){
//            return   this.code.equals(a.code) && this.name.equals(a.name)
//                    && a.hashcode() == this.hashcode();
//
//        }
//    }
//
//    A = List<A>
//    B = List<A>
//    C = List<A>
//    D = List<A>
//
//
//    public static Class RuleVo{
//        private String rule;
//        private List param1;
//        private List param2;
//
//        public RuleVo(String rule, List param1, List param2 ){
//            this.rule = rule;
//            this.param1 = param1;
//            this.param2 = param2;
//        }
//
//        // 存放充血模型
//    }
//
//
//    ListX  = ( A && B ) || ( C && D )     注意：这里可以由业务自己定义
//
//    // 解析规则 存放到代办任务中  递归场景
//    List<RuleVo> RuleVoList = new ArrayList();
//RuleVoList.add(new RuleVo("&&", ))
//
//// 循环处理代办任务
//
//
//// 定义好根据具体规则获取当前结果集
//
//
//            if(rule == "&&"){
//        getAndResultList();
//    }
//
//if()
//
//
//    Hashset ABSet = new Hashset<A>();
//ABSet.putAll(A);
//ABSet.putAll(B);
//
//    Hashset CDSet = new Hashset<A>();
//ABSet.putAll(C);
//ABSet.putAll(D);
//
//    List result = new ArrayList<A>();
//result.addAll(ABSet);
//result.addAll(CDSet);
//
//return result;
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
