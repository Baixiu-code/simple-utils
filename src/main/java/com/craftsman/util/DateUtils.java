package com.craftsman.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.LocalTime;
import org.springframework.util.StringUtils;

/**
 * 
 * @ClassName: DateUtils
 * @Description:日期的处理类
 * @author 陈方林
 * @date 2015年9月10日 下午4:41:40
 *
 */
public class DateUtils {

	/**
	 * 
	* @Title: minusDate 
	* @Description: 两个时间的差集得到毫秒数
	* @author:陈方林
	* @param @param dateOne
	* @param @param dateTwo
	* @param @return    设定文件 
	* @return Long    返回类型 
	* @throws
	 */
	public static Long minusDate(DateTime dateOne,DateTime dateTwo){
		Duration duration=new Duration(dateOne,dateTwo);
		return duration.getMillis();
	}
	/**
	 * 
	* @Title: getZoneDateTime 
	* @Description: 获取不同时区的时间
	* @author:陈方林
	* @param @param pattern
	* @param @return    设定文件 
	* @return DateTime    返回类型 
	* @throws
	 */
	public static DateTime getZoneDateTime(String pattern){		
		//默认设置为日本时间
		DateTimeZone.setDefault(DateTimeZone.forID("America/Los_Angeles"));		
		return  new DateTime(DateTimeZone.forID(pattern));		
	}
	/**
	 * 
	* @Title: longToDateTime 
	* @Description: long类型日期转换为日期格式
	* @author:陈方林
	* @param @param datetime
	* @param @return    设定文件 
	* @return DateTime    返回类型 
	* @throws
	 */
	public static DateTime longToDateTime(long datetime){	        
	       
	        return new DateTime(datetime);
	}
	/**
	 * 
	 * @Title: getStartofDay
	 * @Description: return startofday
	 * @author:陈方林
	 * @date: 2015年9月10日16:41:29
	 * @param
	 * @return DateTime 返回类型
	 * @throws
	 */
	public static DateTime getStartofDay() {
		DateTime nowTime = new DateTime();
		DateTime startOfDay = nowTime.withTimeAtStartOfDay();

		return startOfDay;
	}

	/**
	 * 
	 * @Title: getEndofDay
	 * @Description: 获取今天最后的时间
	 * @author:陈方林
	 * @param @return 设定文件
	 * @return DateTime 返回类型
	 * @throws
	 */
	public static DateTime getEndofDay() {
		DateTime nowTime = new DateTime();
		DateTime endOfDay = nowTime.millisOfDay().withMaximumValue();
		return endOfDay;
	}

	/**
	 * 
	 * @Title: getLeftOfDay
	 * @Description: 获取距离今天结束还有多长时间
	 * @author:陈方林
	 * @param @return 设定文件
	 * @return Long 返回类型
	 * @throws
	 */
	public static Long getLeftOfDay() {
		DateTime nowTime = new DateTime();
		DateTime endOfDay = nowTime.millisOfDay().withMaximumValue();

		return endOfDay.getMillis() - nowTime.getMillis();
	}

	/**
	 * 
	 * @Title: timeStmap2Long
	 * @Description: 将时间戳转换为long类型 2015年9月10日17:06:38
	 * @author:陈方林
	 * @param @param strDate
	 * @param @throws ParseException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void timeStmap2Long(String strDate) throws ParseException {
		String tranDate = strDate.replace(".", ":").toString().replace(" ", "");
		System.out.println("字符串长度为:" + tranDate.trim().length());
		// target 日期pattern
		// 1.获取月份
		String month = tranDate.substring(3, 4);
		if (tranDate.trim().length() == 26) {
			// 1.获取月份
			month = tranDate.substring(3, 5);
		}

		System.out.println("月份为:" + month);
		// 2.获取天数
		String day = tranDate.substring(0, 2);

		// 返回第二次出现"-"的索引
		int twoindex = tranDate.lastIndexOf("-");
		// 3.获取年份
		String year = "20" + tranDate.substring(twoindex + 1, twoindex + 3);
		// 4.获取时间
		// 取得上下午来判断小时
		String time = tranDate.substring(twoindex + 3, twoindex + 12);

		// 取得上下午
		String h = tranDate.substring(twoindex + 18, twoindex + 20);
		String rightTime = time;
		int intHHtime = 0;
		if ("下午".equals(h)) {
			String HHtime = tranDate.substring(twoindex + 4, twoindex + 5);
			System.out.println(HHtime + "小时");
			intHHtime = Integer.parseInt(HHtime) + 12;
			rightTime = intHHtime + ":"
					+ tranDate.substring(twoindex + 6, twoindex + 11);
			System.out.println(rightTime);
		}

		// 5.获取毫秒
		String msec = tranDate.substring(twoindex + 12, twoindex + 18);
		int msecInt = Integer.parseInt(msec);
																								
		String targetDate = month + "/" + day + "/" + year + " " + rightTime;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date dt = sdf.parse(targetDate);
		long tarLong = dt.getTime() / 1000 + msecInt;
		System.out.println(tarLong);

	}

	public static Long strToLong(String str){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isEmpty(str))return 0l;
		if(str.matches("\\d{4}-\\d{2}-\\d{2}")){
			try {
				return simpleDateFormat.parse(str).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
				return 0l;
			}
		}
		return 0l;
	}
	public static void main(String args[]) throws ParseException {
		System.out.println("Date格式：现在的时间是："+new Date());
		System.out.println("joda-time：现在的时间是："+new DateTime());

		System.out.println("joda-time:只获取年月日时间："+(new DateTime()).toString("yyyy-MM-dd"));
		System.out.println("joda-time:今天是"+(new DateTime()).toString("E"));
		System.out.println("joda-time:获取时间到秒："+(new DateTime()).toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println("joda-time:获取时间到毫秒："+(new DateTime())
				.toString(" yyyy/MM/dd/ E HH:mm:ss.SSS"));
		System.out.println("joda-time:获取时间带下午："+(new DateTime()).toString("MM/dd/yyyy hh:mm:ss.SSSa"));


		System.out.println("joda-time:获取所在时区名称时间："+(new DateTime()).toString("MM/dd/yyyy HH:mm ZZZZ"));
		System.out.println("joda-time:获取所在时区时间（依据格林威治时间标准）："+(new DateTime()).toString("MM/dd/yyyy HH:mm Z")+"（时区号）");

		System.out.println("距离今天结束还有 " + getLeftOfDay() + " 毫秒");

		String strDate2 = "24-10月-14 05.59.16.000000 下午";

		timeStmap2Long(strDate2);

		System.out.println((longToDateTime(121211L).toString("MM/dd/yyyy hh:mm:ss.SSSa")));
		Calendar calendar=Calendar.getInstance();
		LocalTime localTime=new LocalTime(calendar);
		System.out.println("由calendar转化为localtime的时间："+localTime.toString());
		System.out.println("今天是农历"+(new LunarDateUtils(calendar)));
		System.out.println("获取洛杉矶时间："+getZoneDateTime("America/Los_Angeles"));
		System.out.println(minusDate((new DateTime()),new DateTime()));
		//某天是否存在于区间内
		Interval i = new Interval(new DateTime("2012-02-01"), new DateTime("2012-04-01"));
		System.out.println( i.contains(new DateTime("2012-03-01")));
		DateTime dt=new DateTime();
		System.out.println(dt.plusDays(1));
		System.out.println(strToLong("2017-02-21"));
	}
}
