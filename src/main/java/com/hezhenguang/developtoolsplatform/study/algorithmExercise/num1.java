package com.hezhenguang.developtoolsplatform.study.algorithmExercise;

/**
 * ClassName SearchInArray01<br>
 * Function <br>
 * <p>在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右
 * 递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。</p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class num1 {
    public static boolean findTest(int target,int[][] array){
        int row = array.length;
        if (row <= 0){
            return false;
        }
        int i = 0;
        while (row > 0 &&  i < array[row-1].length){
            if (array[row-1][i] == target){
                System.out.println("目标值找到了" + "\n" +
                                    "当前所在行为：" + (row -1)  + "\n" +
                                    "所在列为" + i + "\n" +
                                    "目标值为" + target);
                return true;
            }else if (array[row-1][i] < target){
                i++;
            }else if (array[row-1][i] > target){
                row--;
            }
        }
        return false;
    }
}
