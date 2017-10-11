package test.base.structure.fastdateformat;

import com.google.common.collect.Lists;
import org.apache.commons.lang.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by chenfanglin on 2017/6/27.
 */
public class TestDateFormat {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(2017,2,28);
        System.out.println(fastDateFormat(calendar.getTime()));
        System.out.println(fastDateFormat(getShouldDate(calendar.getTime())));
    }
    public static Date getShouldDate(Date date){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,15);
        int dayTh=calendar.get(Calendar.DATE);
        List<Integer> daySpecials= Lists.newArrayList(29,30,31);
        if(daySpecials.contains(dayTh)){
            calendar.set(Calendar.DATE,28);
        }
        return calendar.getTime();
    }
    public static String fastDateFormat(Date date){
        FastDateFormat fdf=FastDateFormat.getInstance("yyyy-MM-dd hh:mm:ss");
        return fdf.format(date);
    }
}
