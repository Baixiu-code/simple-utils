package com.craftsman.sample.algorithm.general;

/**
 * @author chenfanglin
 * @desc 选择排序
 * 1.两层排序 外层控制排序存在几趟 内层控制排序的规则
 * 每次取出最大的，则下一趟排序则不需要排列着最大的数
 */
public class TestSelectSort {

    public static void main(String[] args) {
        Integer[] arrays={12,2,4,5,1,1,3,2121,423,53};
        sortCore(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    private static void sortCore(Integer[] arrays){
        int temp;
        int pos;
        for (int i = 0; i < arrays.length-1; i++) {
            pos=0;
            for (int j = 0; j < arrays.length-i; j++) {
                if(arrays[j]>arrays[pos]){
                    pos=j;
                }
            }
            temp=arrays[pos];
            arrays[pos]=arrays[arrays.length-i-1];
            arrays[arrays.length-i-1]=temp;
        }
    }
}
