package com.adeng.http.demo;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 对按指定格式对日期进行转换
 */
public class DateUtil {
    private static Log log = LogFactory.getLog(DateUtil.class);


    /**
     * 默认的日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String FMT_DATE_YYYYMMDD = "yyyy-MM-dd";
    public static final String FMT_DATE_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String FMT_DATE_YYYYMMDD_HH_MM_SS = "yyyyMMdd HH:mm:ss";
    public static final String FMT_DATE_HHMMSS = "HH:mm:ss";
    public static final String FMT_DATE_SPECIAL = "yyyyMMdd";
    public static final String FMT_DATE_MMDD = "MM-dd";
    public static final String FMT_DATE_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String FMT_DATE_MMDD_HHMM = "MM-dd HH:mm";
    public static final String FMT_DATE_MMMDDD = "MM月dd日";
    public static final String FMT_DATE_MMDD_HH = "MM月dd日 HH点";
    public static final String FMT_DATE_YYYYMMDDHHMM_NEW = "yyyyMMddHHmm";
    public static final String FMT_DATE_YYYY年MM月DD日 = "yyyy年MM月dd日";
    public static final String FMT_DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FMT_DATE_YYYYMMDDHH = "yyyyMMddHH";
    public static final String FMT_DATE_YYYY年MM月DD日HHMM = "yyyy年MM月dd日HH:mm";
    public static final String FMT_DATE_YYYYMMDD_1 = "yyyy/MM/dd";
    public static final String FMT_DATE_YYYYMMDD_T_HHMMSS = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String FMT_DATE_YYYYMMDD_HHMMSS_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String FMT_DATE_YYYYMMDD_SLASH = "yyyy/MM/dd";
    public static final String FMT_DATE_YYYYDOTMMDOTDD_HHMMSS = "yyyy.MM.dd HH:mm:ss";
    public static final String FMT_DATE_YYYYDOTMMDOTDD = "yyyy.MM.dd";
    public static final String FMT_DATE_YYYYMMDD_HHMMSS_SSS = "yyyyMMddHHmmssSSS";
    public static final String FMT_DATE_YYYY = "yyyy";
    public static final String FMT_DATE_YYYYMM = "yyyyMM";


    public static void main(String[] args) throws ParseException {
        Date beginDate = DateUtil.getDateBeforeDate(new Date(), 1);
        Date endDate = DateUtil.getDateAfterDay(beginDate, 2);
        Date date = new Date();
        if (date.compareTo(beginDate) > 0) {
            Long intv = date.getTime() - beginDate.getTime();
            beginDate = date;
            getDateByInteval(endDate,intv);
        }

        System.out.println(DateUtil.formatDate(getDateAfterMonth(3), FMT_DATE_YYYYMMDD_HHMMSS));
//      System.out.println(DateUtil.formatDate(new Date(), FMT_DATE_YYYYMMDD_HHMMSS));

    }

    /**
     * @param date    被调整的时间错
     * @param intaval 调整的时间戳
     */
    public static Date getDateByInteval(Date date, Long intaval) {
        date = new Date(date.getTime() + intaval);
        return date;

    }

    /**
     * 按自定义日期格式格式化日期
     *
     * @param target
     * @param format
     * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
     */
    public static String formatDate(Date target, String format) {
        if (target == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(target);
    }

    /**
     * 按默认日期格式 格式化日期
     *
     * @param target
     * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
     */
    public static String formatDate(Date target) {
        return formatDate(target, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将字符串格式化为日期对象
     *
     * @param date
     * @param format
     * @return 如果date为空或格式不标准，返回NULL，否则返回对应的日期对象
     */
    public static Date formatToDate(String date, String format) {
        try {
            if (StringUtils.isBlank(date)) {
                return null;
            }

            SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
            return new Date(sorceFmt.parse(date).getTime());
        } catch (ParseException e) {
            log.warn("invalid date :" + date);
            return null;
        }
    }

    /**
     * 将字符串格式化为日期对象
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Timestamp formatToTimestamp(String dateStr, String format) {
        try {
            SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
            return new Timestamp(sorceFmt.parse(dateStr).getTime()); // 一天的时间24*3600*1000
        } catch (ParseException e) {
            log.warn("invalid date2Get :" + dateStr);
            return null;
        }
    }

    /**
     * 将Timestamp对象格式化
     *
     * @param time
     * @param format
     * @return 格式化后的日期字符串，如果传入的Timestamp对象为NULL，返回空字符串
     */
    public static String formatTimestamp(Timestamp time, String format) {
        if (time == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(time);
    }

    /**
     * 得到当前时间的TimeStamp格式
     *
     * @return
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 得到当前的日期
     *
     * @return string
     */
    public static String getCurrentDate(String formatStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatStr);
        return dateFormat.format(new Date());
    }

    public static Timestamp getIntervalTimestamp(Timestamp date, int days) {
        return new Timestamp(getIntervalDate(date, days).getTime());
    }

    public static boolean isSameMonth(Calendar source, Calendar target) {
        if (source == null || target == null) {
            return false;
        }
        SimpleDateFormat sorceFmt = new SimpleDateFormat("yyyy-MM");
        String sourceDate = sorceFmt.format(source.getTime());
        String targetDate = sorceFmt.format(target.getTime());
        if (StringUtils.isNotBlank(sourceDate) && StringUtils.equals(sourceDate, targetDate)) {
            return true;
        }
        return false;
    }

    public static Date getDateBeforeMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -month); // month月前
        Date dayBeforeHalfYear = new Date(calendar.getTimeInMillis());
        return dayBeforeHalfYear;
    }

    /**
     * 当前天几个月后
     *
     * @param month
     * @return
     */
    public static Date getDateAfterMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, month); // month月后
        Date dayBeforeHalfYear = new Date(calendar.getTimeInMillis());
        return dayBeforeHalfYear;
    }

    public static Date getDateBeforeDate(int date) {
        return getDateBeforeDate(new Date(), date);
    }

    public static Date getDateBeforeDate(Date time, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(time);
        calendar.add(Calendar.DATE, -date); // day前
        Date newDate = new Date(calendar.getTimeInMillis());
        return newDate;
    }

    public static Date getDateBeforeHour(Date time, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(time);
        calendar.add(Calendar.HOUR_OF_DAY, -hours); // day前
        Date newDate = new Date(calendar.getTimeInMillis());
        return newDate;
    }

    public static Date getDateBeforeHour(int hours) {
        return getDateBeforeHour(new Date(), hours);
    }

    public static Date getDateAfterDay(Date beforeDate, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(beforeDate);
        calendar.add(Calendar.DAY_OF_MONTH, days); // day天后
        return calendar.getTime();
    }


    /**
     * 得到当天开始的Timestamp
     *
     * @return
     */
    public static Timestamp getBeginOfToday() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 00:00:00";
        Date date = null;
        try {
            date = form.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 得到当天结束的Timestamp
     *
     * @return
     */
    public static Timestamp getEndOfToday() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 23:59:59";
        Date date = null;
        try {
            form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = form.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 判断是否是当天的时间
     *
     * @return
     */
    public static Boolean isToday(Date date) {
        Timestamp beginOfToday = getBeginOfToday();
        Timestamp endOfToday = getEndOfToday();
        if (date.getTime() > beginOfToday.getTime() && date.getTime() < endOfToday.getTime()) {
            return true;
        }
        return false;
    }


    /**
     * 判断是否是当天的时间
     *
     * @return
     */
    public static Boolean isTodayBydataStr(String dataStr) {
        if (StringUtils.isBlank(dataStr)) {
            return false;
        }

        Timestamp beginOfToday = getBeginOfToday();
        Timestamp endOfToday = getEndOfToday();
        long data = Long.parseLong(dataStr);
        if (data > beginOfToday.getTime() && data < endOfToday.getTime()) {
            return true;
        }
        return false;
    }


    public static Timestamp getBeginOfThisDay(Timestamp time) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(time) + " 00:00:00";
        Date date = null;
        try {
            date = form.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    public static Date getTimestampAfter(Timestamp from, int days) {
        Date dayFrom = new Date(from.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayFrom);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 时间加减n个月
     *
     * @return
     */
    public static Timestamp getTimestampAfterMonth(Timestamp from, int months) {
        Date dayFrom = new Date(from.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayFrom);
        calendar.add(Calendar.MONTH, months);
        return new Timestamp(calendar.getTime().getTime());
    }

    public static Timestamp getTimestampAfterYear(Timestamp from, int year) {
        Date dayFrom = new Date(from.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dayFrom);
        calendar.add(Calendar.YEAR, year);
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 判断传入的两个日期是否是同年同月同日
     *
     * @param source
     * @param target
     * @return
     */
    public static boolean isSameDay(Calendar source, Calendar target) {
        if (source == null || target == null) {
            return false;
        }
        SimpleDateFormat sorceFmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String sourceDate = sorceFmt.format(source.getTime());
        String targetDate = sorceFmt.format(target.getTime());
        if (StringUtils.isNotBlank(sourceDate) && StringUtils.equals(sourceDate, targetDate)) {
            return true;
        }
        return false;
    }

    public static boolean isSameDay(Timestamp source, Timestamp target) {
        if (source == null || target == null) {
            return false;
        }
        SimpleDateFormat sorceFmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        String sourceDate = sorceFmt.format(source.getTime());
        String targetDate = sorceFmt.format(target.getTime());
        if (StringUtils.equals(sourceDate, targetDate)) {
            return true;
        }
        return false;
    }

    public static Integer getIntervalDay(Timestamp beginDate, Timestamp endDate) {
        try {
            SimpleDateFormat sorceFmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            String sourceDate = sorceFmt.format(beginDate.getTime());
            String targetDate = sorceFmt.format(endDate.getTime());
            return (int) ((sorceFmt.parse(sourceDate).getTime() - sorceFmt.parse(targetDate).getTime()) / (3600L * 1000 * 24));
        } catch (Exception e) {
            log.error("date trans error", e);
            return null;
        }

    }

    public static Timestamp getEndOfThisDay(Timestamp time) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(time) + " 23:59:59";

        SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = fmtDate.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 获取当前是周几
     *
     * @param dt
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 获取当前是一周第几天 周日 1 周一 2 周二 3...
     *
     * @param dt
     * @return
     */
    public static int getWhatOfWeek(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK);
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    /**
     * 获取当前是一周第几天 周日 1 周一 2 周二 3...
     *
     * @param timeStamp
     * @return
     */
    public static int getWhatOfWeek(Timestamp timeStamp) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeStamp.getTime());
        int w = cal.get(Calendar.DAY_OF_WEEK);
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    public static Date getIntervalDate(Date date2Get, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date2Get);
        c.add(Calendar.DAY_OF_YEAR, days); // 增加天数(如果days为负数,则为减少天数)
        return c.getTime();
    }

    public static Long getCurrentDateTime(String format) {
        String date = getCurrentDate(format);
        Long result = new Long(date);
        return result;
    }

    public static int compareSystemTime(Long startTime, Long endTime, Long nowDate) {
        if (nowDate <= endTime && nowDate >= startTime) {
            return 2;
        } else if (nowDate > endTime) {
            return 1;
        }
        return 0;
    }

    public static Integer getParititionDateFormat(Long date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String s = format.format(date);
        return Integer.valueOf(s);
    }

    public static Long getDate(Long date, String stringFormat) {
        SimpleDateFormat format = new SimpleDateFormat(stringFormat);
        String s = format.format(date);
        return Long.valueOf(s);
    }

    public static Long getIntevalMunite(Long date1, Long date2) {
        Long d1 = getDate(date1, FMT_DATE_YYYYMMDDHHMM_NEW);
        Long d2 = getDate(date2, FMT_DATE_YYYYMMDDHHMM_NEW);
        return d2 - d1;
    }

}

