package com.craftsman.util;

import net.sf.json.JSONArray;
import javax.ws.rs.core.Response;

/**
 * 
* @ClassName: JsonUtils
* @Description:用于常用json格式化的包
* @author 陈方林
* @date 2015年11月22日 下午5:42:36
*
 */
public class JsonUtils {
	/**
	 * 
	* @Title: toJson 
	* @Description: json-lib-2.4-jdk15.jar 用于转换为json格式的
	* @author:陈方林
	* @date:2015年11月22日
	* @param @param object
	* @param @return    设定文件 
	* @return Response    返回类型 
	* @throws
	 */
	public Response toJson(Object object){
		JSONArray jsonArray = JSONArray.fromObject(object);
		return Response.ok(jsonArray.toString()).build();
	}
}
