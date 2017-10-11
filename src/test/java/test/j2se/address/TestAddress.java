package test.j2se.address;

import com.google.common.collect.Lists;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author chenfanglin 【chenfanglincfl@163.com】
 * @Date 2017/2/2115:14
 */
public class TestAddress {
    public static void changeStr(String str){
        str="123455";
    }

    public static void main(String[] args) {
        String str="[\n" +
                "            {\n" +
                "                \"amount\": 0,\n" +
                "                \"costPrice\": 2.76,\n" +
                "                \"marketPrice\": 3,\n" +
                "                \"outSkuId\": 0,\n" +
                "                \"salePrice\": 3,\n" +
                "                \"skuId\": 481,\n" +
                "                \"specs\": [\n" +
                "                    {\n" +
                "                      \"sid\":\"1\",\n" +
                "                        \"isCustom\": 1,\n" +
                "                        \"isExist\": 1,\n" +
                "                        \"isRequired\": 0,\n" +
                "                        \"seq\": 1,\n" +
                "                        \"specName\": \"颜色\",\n" +
                "                        \"specValue\": [\n" +
                "                            {\n" +
                "                                \"svId\": 1,\n" +
                "                                \"value\": \"黑色\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "            ,\n" +
                "            {\n" +
                "                \"amount\": 0,\n" +
                "                \"costPrice\": 2.76,\n" +
                "                \"marketPrice\": 3,\n" +
                "                \"outSkuId\": 0,\n" +
                "                \"salePrice\": 3,\n" +
                "                \"skuId\": 481,\n" +
                "                \"specs\": [\n" +
                "                    {\n" +
                "                      \"sid\":\"1\",\n" +
                "                        \"isCustom\": 1,\n" +
                "                        \"isExist\": 1,\n" +
                "                        \"isRequired\": 0,\n" +
                "                        \"seq\": 1,\n" +
                "                        \"specName\": \"颜色\",\n" +
                "                        \"specValue\": [\n" +
                "                            {\n" +
                "                                \"svId\": 1,\n" +
                "                                \"value\": \"黑色\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]";
        AddProductItemDTO addProductItemDTO=null;
        List<AddProductItemDTO> addProductItemDTOList= Lists.newArrayList();
        AddProductSpec addProductSpec=null;
        List<AddProductSpec> addProductSpecList=null;
        SkuValues skuValue=null;
        List<SkuValues> skuValueList=null;
        JSONArray array = JSONArray.fromObject(str);
        for(Object o:array.toArray()){
            //产品Item
            addProductItemDTO=new AddProductItemDTO();
            JSONObject addProductItemDTOJsonObject=JSONObject.fromObject(o);
            addProductItemDTO.setAmount(Integer.parseInt(addProductItemDTOJsonObject.get("amount").toString()));
            addProductItemDTO.setCostPrice(new BigDecimal(addProductItemDTOJsonObject.get("costPrice").toString()));
            addProductItemDTO.setMarketPrice(new BigDecimal(addProductItemDTOJsonObject.get("marketPrice").toString()));
            addProductItemDTO.setOutSkuId(Long.parseLong(addProductItemDTOJsonObject.get("outSkuId").toString()));
            addProductItemDTO.setSalePrice(new BigDecimal(addProductItemDTOJsonObject.get("salePrice").toString()));
            addProductItemDTO.setSkuId(Long.parseLong(addProductItemDTOJsonObject.get("skuId").toString()));

            //产品规格
            JSONObject json = JSONObject.fromObject(o);
            for(Object o1:JSONArray.fromObject(json.get("specs"))){
                JSONObject addProductSpecDTOJsonObject=JSONObject.fromObject(o1);
                addProductSpec=new AddProductSpec();
                addProductSpecList=Lists.newArrayList();
                addProductSpec.setIsCustom(Integer.parseInt(addProductSpecDTOJsonObject.get("isCustom").toString()));
                addProductSpec.setIsExist(Integer.parseInt(addProductSpecDTOJsonObject.get("isExist").toString()));
                addProductSpec.setIsRequired(Integer.parseInt(addProductSpecDTOJsonObject.get("isRequired").toString()));
                addProductSpec.setSeq(Integer.parseInt(addProductSpecDTOJsonObject.get("seq").toString()));
                addProductSpec.setSpecName(addProductSpecDTOJsonObject.get("specName").toString());
                for(Object o2:JSONArray.fromObject(addProductSpecDTOJsonObject.get("specValue"))){
                    JSONObject specValueJsonObject=JSONObject.fromObject(o2);
                    skuValue=new SkuValues();
                    skuValueList=Lists.newArrayList();
                    skuValue.setSvId(Long.parseLong(specValueJsonObject.get("svId").toString()));
                    skuValue.setValue(specValueJsonObject.get("value").toString());
                    skuValueList.add(skuValue);
                }
                addProductSpec.setSpecValue(skuValueList);
                addProductSpecList.add(addProductSpec);
            }
            addProductItemDTO.setSpecs(addProductSpecList);
            addProductItemDTOList.add(addProductItemDTO);
        }
        System.out.println(addProductItemDTOList.size());
        for(AddProductItemDTO bean:addProductItemDTOList){
            System.out.println(bean.getCostPrice());
            for(AddProductSpec bean1:bean.getSpecs()){
                System.out.println(bean1.getIsCustom());
                for(SkuValues bean2:bean1.getSpecValue()){
                    System.out.println(bean2.getValue());
                }
            }
        }
    }
}
