package com.hezhenguang.developtoolsplatform.dailyLife.utils;

import com.hezhenguang.developtoolsplatform.dailyLife.pojo.BookKeepJo;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 登高而望远
 */
public class BookkeepingAndSettlement {

        public static void Settlement(List<BookKeepJo> bookKeepJos){

                Map<String,Map<String,Double>> liquidationData = new HashMap<>();
                String delimiter = "    ";

                System.out.println("============================所有记录 start");
                bookKeepJos.stream().forEach(bookKeepJo -> {
                        String[] participantArr = bookKeepJo.getParticipant().split("");

                        String payer = bookKeepJo.getPayer();
                        Double averageCost = bookKeepJo.getCost() / participantArr.length;


                        System.out.println(payer + delimiter
                                + bookKeepJo.getRemark() + delimiter
                                + "支出费用:" + bookKeepJo.getCost() + delimiter
                                + "参与人:" + bookKeepJo.getParticipant() + delimiter
                                + "平均每人:" + averageCost);

                        for (int i = 0; i < participantArr.length; i++) {

                                if (StringUtils.equals(payer,participantArr[i])) continue;

                                String consumerName = participantArr[i];
                                Map<String, Double> floatMap = liquidationData.get(payer);
                                Double oldNumericalValue = Double.valueOf(0);
                                if (MapUtils.isNotEmpty(floatMap)){
                                        oldNumericalValue = floatMap.get(consumerName) == null ? Double.valueOf(0) : floatMap.get(consumerName);
                                }else {
                                        floatMap = new HashMap<String, Double>();
                                }

                                Double newNumericalValue = oldNumericalValue + averageCost;

                                floatMap.put(consumerName,newNumericalValue);

                                liquidationData.put(payer,floatMap);
                        }
                });
                System.out.println("============================所有记录 end");

                System.out.println("============================所有应收款项 start");
                liquidationData.forEach((s, stringFloatMap) -> {
                        stringFloatMap.forEach((s1, aFloat) -> {
                                System.out.println(s + "收" + s1 + delimiter + aFloat);
                        });
                });
                System.out.println("============================所有应收款项 end");

                HashMap<String, Double> liquidation = new HashMap<>();

                for (Map.Entry<String,Map<String,Double>> item :liquidationData.entrySet()) {
                        String payer = item.getKey();
                        Map<String, Double> floatMap = item.getValue();
                        for (Map.Entry<String,Double> consumer : floatMap.entrySet()) {
                                String consumerName = consumer.getKey();
                                Double consumerCost = consumer.getValue();
                                String key = payer + "收" + consumerName;
                                String rekey = consumerName + "收" + payer;
                                if (liquidation.containsKey(rekey)){
                                        Double payerCost = liquidation.get(rekey);
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
                NumberFormat instance = NumberFormat.getInstance();
                instance.setMaximumFractionDigits(2);
                instance.setRoundingMode(RoundingMode.DOWN);

                liquidation.forEach((s, aFloat) ->{
                        System.out.println(s + delimiter + instance.format(aFloat));
                });

                System.out.println("============================最后结果 end");



        }



}
