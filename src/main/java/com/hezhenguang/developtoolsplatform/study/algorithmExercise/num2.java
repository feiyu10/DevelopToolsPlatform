package com.hezhenguang.developtoolsplatform.study.algorithmExercise;

/**
 * ClassName ReplaceSpace02<br>
 * Function <br>
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * </p>
 *
 * @author 辛江勇
 * @version 1.0.0
 */
public class num2 {

    public static  String replace(String str){
        if (str.length() <= 0){
            return "";
        }
        if (str.indexOf(" ") == -1){
            return str;
        }
        //return str.replace(" ","%20");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length();i++){
          if (str.charAt(i) == ' '){
              result.append("%20");
          }else {
              result.append(str.charAt(i));
          }
      }
        return result.toString();
    }
}