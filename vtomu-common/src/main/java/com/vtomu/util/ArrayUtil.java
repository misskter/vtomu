package com.vtomu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数组相关的工具类
 */
public class ArrayUtil {

    /**
     * 获取一个double类型的数字的小数位有多长
     * @param dd
     * @return
     */
    public static int doueleBitCount(double dd){
        String temp = String.valueOf(dd);
        int i = temp.indexOf(".");
        if(i > -1){
            return temp.length()-i -1;
        }
        return 0;

    }

    public static Integer[] doubleBitCount(double[] arr){
        Integer[] len = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            len[i] = doueleBitCount(arr[i]);
        }
        return len;
    }
    public static boolean validateParams(Object[]... objects) {
    	for (Object[] object : objects) {
			if(object==null) {
				return false;
			}
		}
    	return true;
    }
    
 
    
    
}
