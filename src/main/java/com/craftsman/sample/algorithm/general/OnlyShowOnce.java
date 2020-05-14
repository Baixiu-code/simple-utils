package com.craftsman.sample.algorithm.general;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

 */
public class OnlyShowOnce {

    public static void main(String[] args) {
        System.out.println(showOnce(new int[]{2,3,4,3,2}));
        System.out.println(showOnceByBitOp(new int[]{2,3,4,3,2}));
    }

    /**
     * 一般的做法
     * @param nums
     * @return
     */
    public static Integer showOnce(int[] nums){
        if(nums==null || nums.length==0){
            return null;
        }
        if(nums.length==1){
            return nums[0];
        }
        Map<Integer,Integer> existsMap= Maps.newHashMapWithExpectedSize(nums.length);
        for(int i=0;i<nums.length;i++){
            if(existsMap.containsKey(nums[i])){
                existsMap.put(nums[i],existsMap.get(nums[i])+1);
            }else{
                existsMap.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:existsMap.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * 异或操作.当两个相同的数进行异或操作时得到的是0,利用这个特性.在数组中,多个相同的数在一起进行异或操作则互相置为0,
     * 最后则剩下非相同的那个数对0进行异或操作则得到本身
     * @param nums nums
     * @return 得到数组中出现一次的数
     */
    public static Integer showOnceByBitOp(int[] nums){
        int single=0;
        for(int i=0;i<nums.length;i++){
            single=single^nums[i];
        }
        return single;
    }

}
