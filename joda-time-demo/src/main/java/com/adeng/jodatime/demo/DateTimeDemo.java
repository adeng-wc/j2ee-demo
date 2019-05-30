package com.adeng.jodatime.demo;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * {@link DateTime}
 *
 * @author hzwengcheng 2019-05-30 18:51
 */
public class DateTimeDemo {

    @Test
    public void test() {
        System.out.println(DateTime.now());

        DateTime dt = new DateTime();
        System.out.println(dt);
        System.out.println(DateTime.now().toDate());

        DateTime dt2 = new DateTime("2004-12-13T21:39:45.618-08:00");
        System.out.println(dt2);
    }

    @Test
    public void test1() {
        // from Joda to JDK
        DateTime dt = new DateTime();
        Date jdkDate = dt.toDate();
        System.out.println(jdkDate);

        // from JDK to Joda
        dt = new DateTime(jdkDate);
        System.out.println(dt);
    }

    @Test
    public void test2() {
        // 获取当前年的第几天
        System.out.println("getDayOfYear:" + DateTime.now().getDayOfYear());
        // 获取当前月的第几天
        System.out.println("getDayOfMonth:" + DateTime.now().getDayOfMonth());
        // 当前星期的第几天
        System.out.println("getDayOfWeek:" + DateTime.now().getDayOfWeek());
    }


    @Test
    public void test3() {
        // from Joda to JDK
        DateTime dt = new DateTime();
        Calendar jdkCal = dt.toCalendar(Locale.CHINESE);
        System.out.println(jdkCal);

        // from JDK to Joda
        dt = new DateTime(jdkCal);
        System.out.println(dt);
    }

    @Test
    public void test4() {
        DateTime dt = new DateTime();
        DateTime.Property pDoW = dt.dayOfWeek();
        String strST = pDoW.getAsShortText(); // returns "Mon", "Tue", etc.
        String strT = pDoW.getAsText(); // returns "Monday", "Tuesday", etc.
        String strTF = pDoW.getAsText(Locale.FRENCH); // returns "Lundi", etc.

        System.out.println(strST);
        System.out.println(strT);
        System.out.println(strTF);
    }

    @Test
    public void test5() {
        DateTime dt = new DateTime();
        System.out.println(dt.getEra());
        System.out.println(dt.getYear());
        System.out.println(dt.getWeekyear());
        System.out.println(dt.getCenturyOfEra());
        System.out.println(dt.getYearOfEra());
        System.out.println(dt.getYearOfCentury());
        System.out.println(dt.getMonthOfYear());
        System.out.println(dt.getWeekOfWeekyear());
        System.out.println(dt.getDayOfYear());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getDayOfWeek());
    }

    @Test
    public void test6() {
        DateTime dt = new DateTime();
        int hour = dt.getHourOfDay();
        int min = dt.getMinuteOfHour();
        int sec = dt.getSecondOfMinute();

        System.out.println(hour);
        System.out.println(min);
        System.out.println(sec);
    }

    @Test
    public void test7() {
        DateTime dt = new DateTime();
        System.out.println(dt);
        DateTime result = dt.dayOfWeek().setCopy(DateTimeConstants.MONDAY);
        System.out.println(result);
        result = dt.dayOfWeek().addToCopy(3);
        System.out.println(result);
    }

    @Test
    public void test8() {
        DateTime dt = new DateTime();
        System.out.println(dt);
        DateTime result = dt.plusDays(4);
        System.out.println(result);
    }

    @Test
    public void test9() {
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
        String strOutputDateTime = fmt.print(dt);
        System.out.println(strOutputDateTime);
    }

    @Test
    public void test10() {
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
        String strOutputDateTime = fmt.print(dt);
        System.out.println(strOutputDateTime);
    }

    @Test
    public void test11() {
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = new DateTimeFormatterBuilder()
                .appendDayOfMonth(2)
                .appendLiteral('-')
                .appendMonthOfYearShortText()
                .appendLiteral('-')
                .appendTwoDigitYear(1956)  // pivot = 1956
                .toFormatter();
        String strOutputDateTime = fmt.print(dt);
        System.out.println(strOutputDateTime);
    }

    @Test
    public void test12(){
        DateTime dt = new DateTime();
        String a = dt.toString();
        System.out.println(a);
        String b = dt.toString("dd:MM:yy");
        System.out.println(b);
        String c = dt.toString("EEE", Locale.FRENCH);
        System.out.println(c);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");
        String d = dt.toString(fmt);
        System.out.println(d);
    }

}
