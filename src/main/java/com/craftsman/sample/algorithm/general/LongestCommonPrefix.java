package com.craftsman.sample.algorithm.general;

/**
 * 最长前缀
 * 思路:从最大的子串开始.慢慢回收
 * @author chenfanglin
 * @date 2020年05月15日
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs){
        if(strs.length==0){
            return "";
        }
        String preStr=strs[0];
        for(int i=0;i<strs.length;i++){
            while (strs[i].indexOf(preStr)!=0){
                preStr=preStr.substring(0,preStr.length()-1);
                if(preStr.isEmpty()){
                    return "";
                }
            }
        }
        return preStr;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
