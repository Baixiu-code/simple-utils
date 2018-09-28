package test.mq;


import com.google.common.collect.Lists;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @author chenfanglin
 * @desc 测试 refrence
 */
public class TestRefrence {
    private static List<String> STRS= Lists.newArrayList("12","1212","232");
    public static void main(String[] args) {
        //test refrence
        String str;
        List<String> result=Lists.newArrayList();
        for (int i=0;i<5;i++){
            str=new String(i+"");
            result.add(str);
        }
        result.forEach(item->{
            System.out.println(item);
        });

        JSONArray jsonArray=JSONArray.fromObject("[{\n" +
                "  \"url\": \"https://qqe2.com\",\n" +
                "  \"name\": \"欢迎使用JSON在线解析编辑器\",\n" +
                "  \"array\": {\n" +
                "    \"JSON校验\": \"http://jsonlint.qqe2.com/\",\n" +
                "    \"Cron生成\": \"http://cron.qqe2.com/\",\n" +
                "    \"JS加密解密\": \"http://edit.qqe2.com/\"\n" +
                "  },\n" +
                "  \"boolean\": true,\n" +
                "  \"12\": null,\n" +
                "  \"number\": 123,\n" +
                "  \"object\": {\n" +
                "    \"a\": \"b\",\n" +
                "    \"c\": \"d\",\n" +
                "    \"e\": \"f\"\n" +
                "  }\n" +
                "}]");
        JSONObject jsonObject=jsonArray.getJSONObject(0);
        jsonObject.put("testReference","1");
        for (Object o : jsonArray) {
            System.out.println(o.toString());
        }
    }
}
