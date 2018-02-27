package test;

import com.craftsman.util.HttpClientUtil;
import com.google.common.collect.Maps;
import java.io.*;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFreshUser {


        public static void main(String[] args) throws  Exception{
            File sourceFile = new File("/Users/chenfanglin/Desktop/fresh_user.txt");
            InputStreamReader inputStream=new InputStreamReader(new FileInputStream(sourceFile));
            BufferedReader bufferedReader=new BufferedReader(inputStream);
            String url="http://beta-mall.system.wecash.net/wecashMarketSystem/system/customer/limit/get?customerId=";
            int count=0;
            Map<String,String> successMap= Maps.newHashMap();
            Map<String,String> failMap= Maps.newHashMap();
            String lineTxt;
            ExecutorService executor = Executors.newFixedThreadPool(6);
            while ((lineTxt=bufferedReader.readLine())!=null){
                String customerIdUrl=url+lineTxt;
                String customerId=lineTxt;
                System.out.println(customerIdUrl);
                executor.execute(new Thread(){
                    @Override
                    public void run(){
                        String result= HttpClientUtil.doGet(customerIdUrl);
                        if(result.contains("limitRatio")){
                            successMap.put(customerId,customerId);
                        }else{
                            failMap.put(customerId,customerId);
                        }
                    }
                });
            }
            System.out.println("处理了用户count"+count);
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/chenfanglin/Desktop/fresh_user_success2.txt")),
                        "UTF-8"));
                BufferedWriter bwFail = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/Users/chenfanglin/Desktop/fresh_user_fail2.txt")),
                        "UTF-8"));
                for (String name : successMap.keySet()) {
                    bw.write(name);
                    bw.newLine();
                }
                for (String name : failMap.keySet()) {
                    bwFail.write(name );
                    bwFail.newLine();
                }
                bw.close();
                bwFail.close();
            } catch (Exception e) {
                System.err.println("write errors :" + e);
            }

        }


}
