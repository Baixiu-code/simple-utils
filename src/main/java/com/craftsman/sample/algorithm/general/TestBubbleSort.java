package com.craftsman.sample.algorithm.general;

/**
 * @author chenfanglin
 * @desc 冒泡排序
 * 两层排序1.第一层控制排序的有几趟2.内部排序
 */
public class TestBubbleSort {
    public static void main(String[] args) {
        Integer[] arrays={23,12,43,5,6,7,1,12,9};
        sortCore(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
    public static void sortCore(Integer[] arrays){
        int isChange=0;
        int temp;
        //升序排列，每次将最大的数排出来。之后每次都仅需要排这最大数之前的数组
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length-i-1; j++) {
                if(arrays[j]>arrays[j+1]){
                    temp=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=temp;
                }
                isChange=1;
            }
            if(isChange==0){
                break;
            }
        }
    }
}
