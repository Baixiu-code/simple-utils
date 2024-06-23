package com.craftsman.sample.algorithm.general;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNumSum {

    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                    if(nums[j]==target-nums[i]){
                        return new int[]{i,j};
                    }
                }
            }
        return null;
    }

    public static int[] twoSumOptimize(int[] nums,int target){
        Map<Integer,Integer> numMaps= Maps.newHashMapWithExpectedSize(nums.length);
        for (int i=0;i< nums.length;i++) {
            numMaps.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int leftNum=target-nums[i];
            if(numMaps.get(leftNum)!=i && numMaps.get(leftNum)==target-nums[i]){
                return new int[]{i,numMaps.get(leftNum)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums=new int[4];
        nums[0]=3;
        nums[1]=2;
        nums[2]=4;
        System.out.println(twoSum(nums,6));
        System.out.println(twoSumOptimize(nums,6));
    }
}
