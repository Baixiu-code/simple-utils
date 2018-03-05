package test;

import com.craftsman.util.HttpClientUtil;
import com.google.common.collect.Maps;
import com.sun.deploy.net.HttpUtils;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/5/2319:26
 */
public class TestOrder {

    public static void main(String[] args) throws  Exception{
        File sourceFile = new File("/Users/chenfanglin/Desktop/fresh_product.txt");
        InputStreamReader  inputStream=new InputStreamReader(new FileInputStream(sourceFile));
        BufferedReader bufferedReader=new BufferedReader(inputStream);

        String lineTxt;
//        while ((lineTxt=bufferedReader.readLine())!=null) {
//            String productId = lineTxt.trim();
//            System.out.println(productId);
//            String result1 = HttpClientUtil.doGet(urlInstance + productId);
//            String result2 = HttpClientUtil.doGet(urlSpec + productId);
//            System.out.println(productId+":处理成功");
//        }
    }

}
