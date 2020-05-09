package com.craftsman.util;

import org.apache.commons.lang.StringUtils;

import java.util.Optional;


/**
 * strUtils
 * @author chenfanglin
 * @date 2020年05月09日
 */
public class StringCommonUtil {

    /**
     * 获取非空字符,当为null,则return EMPTY
     * @param value value
     * @return 返回值
     */
    public static String getString(String value){
        return Optional.ofNullable(value).orElse("");
    }

    /**
     * 获取append str
     * @param strs strs
     * @return 拼接字符串
     */
    public static String getAppendStr(String ... strs){
        if(strs==null || strs.length==0){
            return StringUtils.EMPTY;
        }
        StringBuilder stringResult=new StringBuilder();
        for (String str : strs) {
            stringResult.append(str);
        }
        return stringResult.toString();
    }
}
