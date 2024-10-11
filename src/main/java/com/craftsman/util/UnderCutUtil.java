package com.craftsman.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用以处理版本切量 util
 * @author baixiu
 * @date 创建时间 2024/6/19 3:19 PM
 */
public class UnderCutUtil {

    public static void main(String[] args) {
        //获取配置文件控制切量
        //配置文件示例.
        //{
        //    "1":"100",
        //    "2":"10-19",
        //    "3":"0"
        //}
        //获取 uuid
        System.out.println(isGetRange("baixiu","10-19"));
    }
    public static boolean isGetRange(String underCutKey,String configRange){
        int localRange=hashByRange(underCutKey);
        String []revenge=configRange.split("-");
        String regEx = "^(?:0|[1-9][0-9]?|100)-(?:0|[1-9][0-9]?|100)$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(configRange);
        if(matcher.matches()){
            if(localRange>=Integer.parseInt(revenge[0])&&localRange<=Integer.parseInt(revenge[1])){
                //get range
                return true;
            }
        }
        return false;
    }
    public static int hashByRange(String dataStr){
        //支持 100 分比切量
        return Math.abs(hashByStr(dataStr)) % 100;
    }
    
    public static int hashByStr(String dataStr){
        // never change
        int seed = 31;         
        byte[] dataBytes = new byte[0];
        try {
            dataBytes = dataStr.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        return hash(dataBytes, 0, dataBytes.length, seed);
    }
    
    /**
     * hash
       byte[] data: 需要进行哈希的数据。
       int offset: 数据的起始点（在数组中的偏移量）。
       int length: 要哈希的数据的长度。
       int seed: 哈希的种子值，通常用于多次哈希时的初始值。
     * @return hash 值 return
     */
    public static int hash(byte[] data, int offset, int length, int seed) {
        int m = 0x5bd1e995;      // never change
        int r = 24;
        int h = seed ^ length;
        int len_4 = length >> 2;

        for (int i = 0; i < len_4; i++) {
            int i_4 = (i << 2) + offset;
            int k = data[i_4 + 3];
            k = k << 8;
            k = k | (data[i_4 + 2] & 0xff);
            k = k << 8;
            k = k | (data[i_4 + 1] & 0xff);
            k = k << 8;
            k = k | (data[i_4] & 0xff);
            k *= m;
            k ^= k >>> r;
            k *= m;
            h *= m;
            h ^= k;
        }
        int len_m = len_4 << 2;
        int left = length - len_m;
        int i_m = len_m + offset;

        if (left != 0) {
            if (left >= 3) {
                h ^= data[i_m + 2] << 16;
            }
            if (left >= 2) {
                h ^= data[i_m + 1] << 8;
            }
            if (left >= 1) {
                h ^= data[i_m];
            }

            h *= m;
        }

        h ^= h >>> 13;
        h *= m;
        h ^= h >>> 15;
        return h;
    }
    
}
