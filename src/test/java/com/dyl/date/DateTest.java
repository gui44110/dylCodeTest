package com.dyl.date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Classname DateTest
 * @Description TODO
 * @Date 2.6.20 11:48 上午
 * @Created by dongyuliang
 */
public class DateTest {

    @Test
    public void testBefore(){
        Date date = new Date(1588262399000L);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1 - 1);
        System.out.println(DateFormatUtils.format(calendar.getTime(),"yyyy-MM-dd HH:mm:ss"));
        calendar.add(Calendar.MONTH, 1 - 2);
        System.out.println(DateFormatUtils.format(calendar.getTime(),"yyyy-MM-dd HH:mm:ss"));
        calendar.add(Calendar.MONTH, 1 - 3);
        System.out.println(DateFormatUtils.format(calendar.getTime(),"yyyy-MM-dd HH:mm:ss"));
    }
}
