package test;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chenfanglin on 2017/7/6.
 */
public class TestListSort {
    public static void main(String[] args) {
        List<Integer> integerList= Lists.newArrayList(1,2,3,5,4);
        Collections.sort(integerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(Integer i:integerList){
            System.out.println(i.toString());
        }
    }
}
