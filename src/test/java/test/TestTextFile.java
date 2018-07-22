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
public class TestTextFile {

    public static void main(String[] args) throws Exception {
        File sourceFile = new File("/Users/chenfanglin/Desktop/update_amount.txt");
        InputStreamReader inputStream = new InputStreamReader(new FileInputStream(sourceFile));
        BufferedReader bufferedReader = new BufferedReader(inputStream);
//        String urlInstance = "https://m..net/mall/product/order/updateOrder?orderNo=";
        String lineTxt;
        while ((lineTxt = bufferedReader.readLine()) != null) {
            String skuCode = lineTxt.trim() + "&status=2";
            System.out.println(skuCode);
            String result1 = HttpClientUtil.doGet(skuCode);
            System.out.println(skuCode + ":处理成功" + result1);
        }
    }

}
