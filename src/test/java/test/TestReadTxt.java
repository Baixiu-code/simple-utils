package test;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/2319:26
 */
public class TestReadTxt {

    public static void main(String[] args) throws  Exception{
        File sourceFile = new File("C:\\Users\\Administrator\\Desktop\\user_wantedPaper_index.jsp");
        InputStreamReader  inputStream=new InputStreamReader(new FileInputStream(sourceFile));
        BufferedReader bufferedReader=new BufferedReader(inputStream);
        String str=new String();
        TreeMap<String,Integer> hashMap=new TreeMap();
        while (bufferedReader.readLine()!=null){
            if("</body>".equals(str)){;
                System.out.println(str);
            }
            str=bufferedReader.readLine();
            String regBreakSpace = "\\s+";
            String regLetter ="\\w+";
            //将读取的文本进行分割
            if(str!=null){
                String strs[] = str.split(regBreakSpace);
                for(String s:strs){
                    if(s.matches(regLetter)){
                        if(!hashMap.containsKey(s)){
                            hashMap.put(s,1);
                        }else{
                            int num = hashMap.get(s);
                            num++;
                            hashMap.put(s, num);
                        }
                    }
                }
            }
        }
        System.out.println(hashMap.toString());
    }

}
