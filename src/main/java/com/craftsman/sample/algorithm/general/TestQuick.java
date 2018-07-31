package com.craftsman.sample.algorithm.general;

public class TestQuick {
    public static void main(String[] args) {
        Integer[] arrays={212,232,423,53,6,43,312,1};
        sortCore(arrays,0,7);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
    public static void sortCore(Integer[] arrays,int startIndex,int endIndex){
       int i=startIndex;
       int j=endIndex;
       int standValue=arrays[(startIndex+endIndex)/2];
       while (i<=j){

           while (standValue>arrays[i]){
               i++;
           }
           while (standValue<arrays[j]){
               j--;
           }
           if(i<=j){
               int temp=arrays[i];
               arrays[i]=arrays[j];
               arrays[j]=temp;
               i++;
               j--;
           }
           if(startIndex<j){
               sortCore(arrays,startIndex,j);
           }
            if(i<endIndex){
               sortCore(arrays,i,endIndex);
           }

       }
    }


}
