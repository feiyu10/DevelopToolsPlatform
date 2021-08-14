package com.hezhenguang.developtoolsplatform.dailyLife.utils;

import com.hezhenguang.developtoolsplatform.dailyLife.pojo.BookKeepJo;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 登高而望远
 */
public class BookkeepingAndSettlement {

        public static void Settlement(List<BookKeepJo> bookKeepJos){

                Map<String,Map<String,Float>> liquidationData = new HashMap<>();
                String delimiter = "    ";

                bookKeepJos.stream().forEach(bookKeepJo -> {
                        String[] participantArr = bookKeepJo.getParticipant().split("");

                        String payer = bookKeepJo.getPayer();
                        Float averageCost = bookKeepJo.getCost() / participantArr.length;
                        System.out.println(payer + delimiter
                                + bookKeepJo.getRemark() + delimiter
                                + "参与人:" + bookKeepJo.getParticipant() + delimiter
                                + "平均每人:" + averageCost);

                        for (int i = 0; i < participantArr.length; i++) {

                                if (StringUtils.equals(payer,participantArr[i])) continue;

                                String consumerName = participantArr[i];
                                Map<String, Float> floatMap = liquidationData.get(payer);
                                Float oldNumericalValue = Float.valueOf(0);
                                if (MapUtils.isNotEmpty(floatMap)){
                                        oldNumericalValue = floatMap.get(consumerName) == null ? Float.valueOf(0) : floatMap.get(consumerName);
                                }else {
                                        floatMap = new HashMap<String, Float>();
                                }

                                Float newNumericalValue = oldNumericalValue + averageCost;

                                floatMap.put(consumerName,newNumericalValue);

                                liquidationData.put(payer,floatMap);
                        }
                });

                System.out.println("============================所有记录start");
                liquidationData.forEach((s, stringFloatMap) -> {
                        stringFloatMap.forEach((s1, aFloat) -> {
                                System.out.println(s + "收" + s1 + delimiter + aFloat);
                        });
                });
                System.out.println("============================所有记录end");

                HashMap<String, Float> liquidation = new HashMap<>();

                for (Map.Entry<String,Map<String,Float>> item :liquidationData.entrySet()) {
                        String payer = item.getKey();
                        Map<String, Float> floatMap = item.getValue();
                        for (Map.Entry<String,Float> consumer : floatMap.entrySet()) {
                                String consumerName = consumer.getKey();
                                Float consumerCost = consumer.getValue();
                                String key = payer + "收" + consumerName;
                                String rekey = consumerName + "收" + payer;
                                if (liquidation.containsKey(rekey)){
                                        Float payerCost = liquidation.get(rekey);
                                        if (payerCost > consumerCost){
                                                liquidation.put(rekey,payerCost - consumerCost);
                                        }else {
                                                liquidation.put(key,consumerCost - payerCost);
                                                liquidation.remove(rekey);
                                        }
                                }else {
                                        liquidation.put(key,consumerCost);
                                }
                        }
                }

                System.out.println("============================最后结果 start");
                liquidation.forEach((s, aFloat) ->{
                        System.out.println(s + delimiter + aFloat);
                });

                System.out.println("============================最后结果 end");



        }



}
