package com.cyrill.springboot.util;

public class NumberUtil {
    public static int toInt(String str){
        int num = 0;
        try{
            if(str==null){
                num = 0 ;
            }else{
                num = Integer.parseInt(str);
            }
        }catch (Exception e){
            num = 0;
        }
        return num;
    }
}
