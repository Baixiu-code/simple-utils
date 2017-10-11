package test.base.structure.map;

import java.util.*;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/4/2710:53
 */
public class TestTreeMapSort {
    /**
     * TreeMap 结构默认ASCII码
     *
     */
    public static void main(String[] args) {
        Map<String,String> map=new TreeMap<String,String>();
        map.put("a","d");
        map.put("b","c");
        map.put("c","b");
        map.put("d","a");

        List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //降序排序
            public int compare(Map.Entry<String, String> o1,Map.Entry<String, String> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
