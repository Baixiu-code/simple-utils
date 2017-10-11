package test;


import org.apache.commons.lang.time.FastDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testCalendar {
	public static void main(String[] args) {
		//获取本月最后一天
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		date.add(Calendar.MONTH,1);
		date.set(Calendar.DAY_OF_MONTH,0);
		FastDateFormat sdf=FastDateFormat.getInstance("yyyy-MM-dd");
		System.out.println(sdf.format(date));
	}
}
